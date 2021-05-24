package dev.tilegame.entities.creatures;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.SQL.SQL;
import dev.tilegame.entities.Entity;
import dev.tilegame.gfx.Animation;
import dev.tilegame.gfx.Assets;
import dev.tilegame.states.State;

import javax.annotation.processing.SupportedSourceVersion;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{

    //Animatii movement
    private Animation animStop;
    private Animation animUp;
    private Animation animRight;
    private Animation animDown;
    private Animation animLeft;

    //Animatii attack
    private Animation anim_attack_down;
    private Animation anim_attack_up;
    private Animation anim_attac_right;
    private Animation anim_attac_left;

    private Animation anim_take_damage;
    private boolean isTakingDamage;
    private long attack_started_at;



    //Attack limit timer
    private long lastAttackTimer, attackCoolDown = 0,attackTimer = attackCoolDown;

    //Butoane care raman "apasate" cateva secunde, daca a fost apasat macar un tick un buton de atack

    private boolean attack_left = false,
                    attack_right = false,
                    attack_up = false,
                    attack_down = false;

    public static int player_healt = 10;
    public static float Customspeed = 3f;


    private boolean clean_on_next_level = false;

    public Player(Handler handler, float x, float y) {
        super(handler,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 16;
        bounds.y = 16;
        bounds.width = 32;
        bounds.height = 45;

        //Animatii movement
        animStop = new Animation(100,Assets.player_stop);
        animUp = new Animation(100,Assets.player_up);
        animRight = new Animation(100,Assets.player_right);
        animDown = new Animation(100,Assets.player_down);
        animLeft = new Animation(100,Assets.player_left);

        //Animatii attack
        anim_attack_down = new Animation(100,Assets.player_attack_down);
        anim_attack_up = new Animation(100,Assets.player_attack_up);
        anim_attac_right = new Animation(100, Assets.player_attack_right);
        anim_attac_left = new Animation(100, Assets.player_attack_left);

        anim_take_damage = new Animation(60, Assets.take_damage);

        health = player_healt;
        speed = Customspeed;

    }

    @Override
    public void tick() {
        animStop.tick();
        animUp.tick();
        animRight.tick();
        animDown.tick();
        animLeft.tick();
        anim_attack_down.tick();
        anim_attac_left.tick();
        anim_attack_up.tick();
        anim_attac_right.tick();
        anim_take_damage.tick();

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
        {
            return; //daca nu a trecut intervalul din attackCoolDown, iesi din functie fara sa ataci
        }else
        {
            //a trecut perioada de cooldown si trebuie oprita animatia
            this.attack_right = false;
            this.attack_left = false;
            this.attack_down = false;
            this.attack_up = false;
        }


        Rectangle cb = getCollisionBound(0,0);
        Rectangle ar = new Rectangle() ;
        int arSize = 40; //ataca la distanta de 20px
        ar.width = arSize;
        ar.height = arSize;

        if(handler.getKeyManager().aUp)
        {
            ar.x = cb.x + cb.width /2 - arSize/2;
            ar.y= cb.y - arSize;
            attack_up = true;
        }
        else if(handler.getKeyManager().aDown) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
            attack_down = true;

        }else if(handler.getKeyManager().aLeft)
        {
            ar.x = cb.x - arSize;
            ar.y= cb.y + cb.height/2 - arSize / 2;
            attack_left = true;

        }else if(handler.getKeyManager().aRight)
        {
            ar.x = cb.x +cb.width;
            ar.y= cb.y + cb.height/2 - arSize / 2;
            attack_right = true;
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
                System.out.print("Ai luat damage!");
                return;
            }
        }
    }
    @Override
    public void die()
    {
        System.out.println("You lose");
        State.setState(handler.getGame().getLoseState());
        handler.getMouseManager().setUiManager(handler.getGame().getLoseState().getUIManager());

        player_healt = 10;
        handler.getWorld().loadWorld("res/worlds/world1.txt");

        handler.getGame().stopPlayingMusic();
        handler.getGame().playMenuMusic();

        //update date echivalent cu un restart la joc
        SQL.setHearts(10);
        SQL.setLevel(1);
        SQL.setScore(0);
        SQL.update();
    }
    private void getInput()
    {
        xMove = 0; //avem acces pt ca sunt protected si extindem clasa creatures
        yMove = 0;

        if(handler.getKeyManager().up)
            yMove = -speed;

        if(handler.getKeyManager().down) {
            yMove = speed;
        }
        if(handler.getKeyManager().left)
            xMove = -speed;

        if(handler.getKeyManager().right)
            xMove = speed;


    }
    @Override
    public void render(Graphics g) {

        g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width, height,null);
//        g.setColor(Color.red);
//        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
//                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
//                 bounds.width, bounds.height);

        if(isTakingDamage)
        {
            g.drawImage(anim_take_damage.getCurrentFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width, height,null);

            //System.out.println("Timp trecut de la atac:" + (System.currentTimeMillis() - attack_started_at));

            if((System.currentTimeMillis() - attack_started_at) > 500)
           {
               System.out.print("assadasd");
               isTakingDamage = false;
               //opreste animatia abia dupa ce aceasta a avut timp sa se completeze
           }
        }
    }
    private BufferedImage getCurrentAnimationFrame(){
        //atacul are prioritate in fata movementului
        if(attack_right || attack_left || attack_up || attack_down)
        {
            //return animatie pentru atack
            if(attack_up)
            {
                return anim_attack_up.getCurrentFrame();
            }else if(attack_down)
            {
                return anim_attack_down.getCurrentFrame();
            }else if(attack_left)
            {
                return anim_attac_left.getCurrentFrame();
            }else
            {
                return anim_attac_right.getCurrentFrame();
            }

        }
        else
        {
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

    @Override
    public void hurt(int amt) {
        handler.getGame().get_attack_player().play();

        health -= amt;
        if (health <= 0) {
            active = false;
            die();
        }
        isTakingDamage = true;

        attack_started_at = System.currentTimeMillis();

        System.out.println("Am luat dmaage la:" + attack_started_at);
    }
    public int getLives()
    {
        return this.health;
    }
    public int setLives(int new_healt)
    {
       return this.health = new_healt;
    }
    public boolean can_be_removed()
    {
        return this.clean_on_next_level;
    }

    public static  void setPlayerSpeed(float new_speed){
        Customspeed = new_speed;
         }
    public void setSpeed(float speed){
        this.speed = speed;
    }
    public static  float getPlayerSpeed(){return Customspeed;}
    public static void setPlayerHealt(int new_healt){player_healt = new_healt;}


}
