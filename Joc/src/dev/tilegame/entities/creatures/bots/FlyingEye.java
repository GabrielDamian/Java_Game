package dev.tilegame.entities.creatures.bots;

import dev.tilegame.Handler;
import dev.tilegame.entities.creatures.Creature;
import dev.tilegame.gfx.Animation;
import dev.tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FlyingEye extends Creature {

    private Animation animStop;
    private Animation animMoveRight;
    private Animation animMoveLeft;

    private Animation animAttackLeft;
    private Animation animAttackRight;

    private Animation anim_take_damage;

    private long lastAttackTimer, attackCoolDown = 500,attackTimer = attackCoolDown;
    private int raza_attack = 20;


    private boolean isAttacking = true;
    private boolean isTakingDamage = false;

    private boolean isMovingPositive = false; //moving right
    private int  distantaParcursa = 0;
    private int raza_patrulare;

    private boolean attackLeft = false,
                    attackRight = false,
                    moveLeft = false,
                    moveRight = false;

    private int damage_power = 1;
    private int score_plus = 3;

    private boolean clean_on_next_level = true;

    public FlyingEye(Handler handler, float x, float y,int raza_patrulare,float custom_speed) {
        super(handler,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 16;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;
        speed = custom_speed;

        this.raza_patrulare = raza_patrulare;

        animStop = new Animation(100, Assets.eyeball_stop_right);
        animMoveLeft = new Animation(100, Assets.eyeball_run_left);
        animMoveRight = new Animation(100, Assets.eyeball_run_right);

        animAttackRight = new Animation(100, Assets.eyeball_attack_right);
        animAttackLeft = new Animation(100, Assets.eyeball_attack_left);

        anim_take_damage = new Animation(20,Assets.take_damage);
    }

    @Override
    public void tick() {
        animStop.tick();
        animMoveLeft.tick();
        animMoveRight.tick();
        animAttackLeft.tick();
        animAttackRight.tick();
        anim_take_damage.tick();

        checkAttack();
        getInputAutomatic();
        move();
    }
    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width, height,null);

        if(isTakingDamage)
        {
            g.drawImage(anim_take_damage.getCurrentFrame(),(int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width, height,null);
            isTakingDamage = false;
        }


//                g.fillRect((int)(x - handler.getGameCamera().getxOffset()),
//                (int)(y - raza_attack - handler.getGameCamera().getyOffset()),
//                width,raza_attack);
//
//
//                g.fillRect((int)(x - handler.getGameCamera().getxOffset()),
//                (int)(y + height - handler.getGameCamera().getyOffset()),
//                width,raza_attack);
//
//        //Dreptunghi stanga
//        g.fillRect((int)(x - raza_attack - handler.getGameCamera().getxOffset()),
//                (int)(y  - handler.getGameCamera().getyOffset()),
//                raza_attack,height);
//
//        //Dreptunghi dreapta
//        g.fillRect((int)(x + width - handler.getGameCamera().getxOffset()),
//                (int)(y  - handler.getGameCamera().getyOffset()),
//                raza_attack,height);
    }

    @Override
    public void die() {

        int current_score = handler.getGame().getScore();
        handler.getGame().setScore(current_score + score_plus);

    }

    public BufferedImage getCurrentAnimationFrame()
    {
//        return animMoveRight.getCurrentFrame();
        if(isAttacking)
        {
            if(attackLeft)
            {
                return animAttackLeft.getCurrentFrame();
            }
            else
            {
                return animAttackRight.getCurrentFrame();
            }
        }
        else
        {
            if(moveLeft)
            {
                return animMoveLeft.getCurrentFrame();
            }
            else
            {
                return animMoveRight.getCurrentFrame();
            }
        }
    }

    private void getInputAutomatic()
    {
        xMove = 0;
        yMove = 0;

        if(isAttacking)
        {
            return;
        }
        else
        {
           if(distantaParcursa >= raza_patrulare)
           {
               //schimba senstul de movement
               isMovingPositive = !isMovingPositive;

               //reinitilaizare contor
               distantaParcursa = 0;
           }
           if(isMovingPositive)
           {
               xMove = speed;
               distantaParcursa += speed;
               moveLeft = false;
               moveRight = true;
           }
           else
           {
               xMove = -speed;
               distantaParcursa += speed;
               moveRight = false;
               moveLeft = true;
           }

        }
    }
    private void checkAttack()
    {
        //daca player-ul este mort, sari logica de verificare
        if (handler.getWorld().getEntityManager().getPlayer().isActive() == false) {
            isAttacking = false;
        }
        else
        {
            boolean macar_o_coliziune = false;

            //Verifica la stanga si seteaza boole-urile corespunzator
            Rectangle rectangle_left = new Rectangle();
            rectangle_left.width = raza_attack;
            rectangle_left.height = height;
            rectangle_left.x = (int) (x) - raza_attack;
            rectangle_left.y = (int) (y);

            if (rectangle_left.intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBound(0, 0))) {
                isAttacking = true;
                attackLeft = true;
                macar_o_coliziune = true;

                if (System.currentTimeMillis() - lastAttackTimer > attackCoolDown) {
                    handler.getWorld().getEntityManager().getPlayer().hurt(1);
                    lastAttackTimer = System.currentTimeMillis();
                } else {
                    System.out.print("Boot in cooldown");
                }

            }

            Rectangle rectangle_right = new Rectangle();
            rectangle_right.width = raza_attack;
            rectangle_right.height = raza_attack;
            rectangle_right.x = (int) (x) + width;
            rectangle_right.y = (int) (y);

            if (rectangle_right.intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBound(0, 0))) {
                isAttacking = true;
                attackRight = true;
                macar_o_coliziune = true;


                if (System.currentTimeMillis() - lastAttackTimer > attackCoolDown) {
                    handler.getWorld().getEntityManager().getPlayer().hurt(1);
                    lastAttackTimer = System.currentTimeMillis();
                } else {
                    System.out.print("Boot in cooldown");
                }
            }

            if(!macar_o_coliziune)
            {
                isAttacking = false;
                attackRight = false;
                attackLeft = false;
            }

        }
        }

    @Override
    public void hurt(int amt)
    {
        System.out.print("Cnv primeste damage");
        health -=amt;
        if(health <=0)
        {
            active = false;
            die();
        }

        //folosit la animatie
        isTakingDamage = true;
    }
    public boolean can_be_removed()
    {
        return this.clean_on_next_level;
    }

}

