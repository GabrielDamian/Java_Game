package dev.tilegame.entities.creatures;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.entities.Entity;
import dev.tilegame.gfx.Animation;
import dev.tilegame.gfx.Assets;

import javax.annotation.processing.SupportedSourceVersion;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Evil_test extends Creature{

    //Animatii
    private Animation animStop;
    private Animation animUp;
    private Animation animRight;
    private Animation animDown;
    private Animation animLeft;


    private boolean temp = false; //sterge dupa teste /stanga/dreapta
    //Attack limit timer
    private long lastAttackTimer, attackCoolDown = 400,attackTimer = attackCoolDown;



    public Evil_test(Handler handler, float x, float y) {
        super(handler,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 16;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;

        //Animatii
        animStop = new Animation(100,Assets.player_stop);
        animUp = new Animation(100,Assets.player_up);
        animRight = new Animation(100,Assets.player_right);
        animDown = new Animation(100,Assets.player_down);
        animLeft = new Animation(100,Assets.player_left);

    }

    @Override
    public void tick() {
        animStop.tick();
        animUp.tick();
        animRight.tick();
        animDown.tick();
        animLeft.tick();
        //Movement

        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);

        //Attack
        checkAttacks();
    }
    private void checkAttacks()
    {
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCoolDown)
            return; //daca nu a trecut intervalul din attackCoolDown, iesi din functie fara sa ataci

        Rectangle cb = getCollisionBound(0,0);
        Rectangle ar = new Rectangle() ;
        int arSize = 20; //ataca la distanta de 20px
        ar.width = arSize;
        ar.height = arSize;

        if(handler.getKeyManager().aUp)
        {
            ar.x = cb.x + cb.width /2 - arSize/2;
            ar.y= cb.y - arSize;
        }
        else if(handler.getKeyManager().aDown) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        }else if(handler.getKeyManager().aLeft)
        {
            ar.x = cb.x - arSize;
            ar.y= cb.y + cb.height/2 - arSize / 2;
        }else if(handler.getKeyManager().aRight)
        {
            ar.x = cb.x +cb.width;
            ar.y= cb.y + cb.height/2 - arSize / 2;
        }else
        {
            return;
        }
        //in acest punct, sigur s-a efectuat un atac

        attackTimer = 0; //reseteaza timerul pentru atac;

        for(Entity e:handler.getWorld().getEntityManager().getEnitites())
        {
            if(e.equals(this))
                continue; //skip, echivalent cu break;

            if(e.getCollisionBound(0,0).intersects(ar))//ne-am intersectat cu aceasta entitate
            {
                e.hurt(1);
                return;
            }
        }
    }
    @Override
    public void die()
    {
        System.out.println("You lose");
    }
    private void getInput()
    {
        xMove = 0; //avem acces pt ca sunt protected si extindem clasa creatures
        yMove = 0;
        if(this.getX() < 400 && this.temp == false)
        {
            xMove  +=speed;
        }
        else if(this.getX() > 380 && this.getX() < 400) {
            this.temp = true;
        }
        else
        {
            xMove -=speed;
        }


    }
    @Override
    public void render(Graphics g) {

        g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width, height,null);
//        g.setColor(Color.red);
//        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
//                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
//                 bounds.width, bounds.height);
    }
    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0) //moving left
        {
            return animLeft.getCurrentFrame();

        }else if(xMove >  0)
        {
            return animRight.getCurrentFrame();
        }else if(yMove < 0)
        {
            return animUp.getCurrentFrame();

        }else if(yMove > 0){
            return animDown.getCurrentFrame();
        }else{
            return animStop.getCurrentFrame();
            //return Assets.player_stop[1];
        }
    }
}
