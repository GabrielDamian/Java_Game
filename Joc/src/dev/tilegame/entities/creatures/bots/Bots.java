package dev.tilegame.entities.creatures.bots;

import dev.tilegame.Handler;
import dev.tilegame.entities.Entity;
import dev.tilegame.entities.creatures.Creature;
import dev.tilegame.gfx.Animation;
import dev.tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

//public class Bots extends Creature {
//    //Difera de un player normal prin automatizarea miscarii si a atacului
//
//    //Animatii movement
//    private Animation animStop;
//    private Animation animRight;
//    private Animation animLeft;
//
//    //Animatii attack
//    private Animation anim_attack_right;
//    private Animation anim_attack_left;
//
//
//    //Attack limit timer
//    private long lastAttackTimer = 0, attackCoolDown = 2000;
//    private int raza_attack = 30;
//
//    //alege intre movement si attack
//    private boolean pause_move = false;
//
//    private boolean attack_left = false,
//                    attack_right = false;
//
//    private boolean move_left = false,
//                    move_right = false;
//
//
//    private boolean directie; //true -  orizontal, false - vertical
//    private int lungime_drum;
//    private int counter_lungime_drum = 0;
//    private boolean sens_move = true; //true - dreapta/jos, false - stanga/sus
//
//
//    public Bots(Handler handler, float x, float y, boolean directie, int lungime_drum) {
//        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
//
//        this.directie = directie;
//        this.lungime_drum = lungime_drum;
//
//        bounds.x = 16;
//        bounds.y = 32;
//        bounds.width = 32;
//        bounds.height = 32;
//
//
//        //Animatii movement
//        animStop = new Animation(100, Assets.eyeball_stop_right);
//        animLeft = new Animation(100, Assets.eyeball_run_left);
//        animRight = new Animation(100, Assets.eyeball_run_right);
//
//        //Animatii attack
//
//        anim_attack_right = new Animation(100, Assets.eyeball_attack_right);
//        anim_attack_left = new Animation(100, Assets.eyeball_attack_left);
//
//
//    }
//
//    @Override
//    public void tick() {
//        animStop.tick();
//        animRight.tick();
//        animLeft.tick();
//        anim_attack_left.tick();
//        anim_attack_right.tick();
//        //Movement
//
//        getInput();
//        move();
//        handler.getGameCamera().centerOnEntity(this);
//
//
//        verificaAttacksBot();
//    }
//
//
//    @Override
//    public void die() {
//        System.out.println("You lose");
//    }
//
//
//    private BufferedImage getCurrentAnimationFrame() {
//        return anim_attack_left.getCurrentFrame();
//    }
//
//    private void verificaAttacksBot() {
//        //daca player-ul este mort, porneste miscarea (pause_move = false)
//
//        if (handler.getWorld().getEntityManager().getPlayer().isActive() == false) {
//            attack_left = false;
//            attack_right = false;
//            attack_up = false;
//            attack_down = false;
//
//            pause_move = false;
//
//
//        } else {
//
//            //
//            boolean exista_intersectie = false;
//
//
//            //Rectangle UP
//            Rectangle rectangle_up = new Rectangle();
//            rectangle_up.width = width;
//            rectangle_up.height = raza_attack;
//            rectangle_up.x = (int) this.getX();
//            rectangle_up.y = (int) this.getY() - raza_attack;
//
//            //daca player-ul intra in zona de sus, opreste move si ataca
//            if (rectangle_up.intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBound(0, 0))) {
//                exista_intersectie = true;
//                System.out.print("ESTI SUS");
//                pause_move = true;
//                attack_up = true;
//
//
//                //Damage limitat de cooldown
//                if (System.currentTimeMillis() - lastAttackTimer > attackCoolDown) {
//                    handler.getWorld().getEntityManager().getPlayer().hurt(1);
//                    lastAttackTimer = System.currentTimeMillis();
//                } else {
//                    System.out.print("Boot in cooldown");
//                }
//
//                //Daca player-ul moare, pune bot-ul in miscare
//                if (handler.getWorld().getEntityManager().getPlayer().isActive() == false) {
//                    pause_move = false;
//                }
//            }
//
//
//            //Rectangle DOWN
//            Rectangle rectangle_down = new Rectangle();
//            rectangle_down.width = width;
//            rectangle_down.height = raza_attack;
//            rectangle_down.x = (int) (x);
//            rectangle_down.y = (int) (y + height);
//
//
//            //daca player-ul intra in zona de jos, opreste move si ataca
//            if (rectangle_down.intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBound(0, 0))) {
//                exista_intersectie = true;
//                System.out.print("ESTI SUS");
//                pause_move = true;
//                attack_down = true;
//
//                if (System.currentTimeMillis() - lastAttackTimer > attackCoolDown) {
//                    handler.getWorld().getEntityManager().getPlayer().hurt(1);
//                    lastAttackTimer = System.currentTimeMillis();
//                } else {
//                    System.out.print("Boot in cooldown");
//                }
//
//                System.out.print("Last attack timer" + lastAttackTimer);
//                if (handler.getWorld().getEntityManager().getPlayer().isActive() == false) {
//                    pause_move = false;
//                }
//            }
//
//
//            //Rectangle in partea stanga
//            Rectangle rectangle_left = new Rectangle();
//            rectangle_left.width = raza_attack;
//            rectangle_left.height = height;
//            rectangle_left.x = (int) (x) - raza_attack;
//            rectangle_left.y = (int) (y);
//
//
//            //daca player-ul intra in zona stanga, opreste move si ataca
//            if (rectangle_left.intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBound(0, 0))) {
//                exista_intersectie = true;
//                System.out.print("ESTI SUS");
//                attack_left = true;
//                pause_move = true;
//
//                if (System.currentTimeMillis() - lastAttackTimer > attackCoolDown) {
//                    handler.getWorld().getEntityManager().getPlayer().hurt(1);
//                    lastAttackTimer = System.currentTimeMillis();
//                } else {
//                    System.out.print("Boot in cooldown");
//                }
//
//                System.out.print("Last attack timer" + lastAttackTimer);
//                if (handler.getWorld().getEntityManager().getPlayer().isActive() == false) {
//                    pause_move = false;
//                }
//            }
//
//
//            //Rectangle in partea dreapta
//            Rectangle rectangle_right = new Rectangle();
//            rectangle_right.width = raza_attack;
//            rectangle_right.height = raza_attack;
//            rectangle_right.x = (int) (x) + width;
//            rectangle_right.y = (int) (y);
//
//
//            //daca player-ul intra in zona dreapta, opreste move si ataca
//            if (rectangle_right.intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBound(0, 0))) {
//                exista_intersectie = true;
//                System.out.print("ESTI SUS");
//                attack_right = true;
//                pause_move = true;
//
//                if (System.currentTimeMillis() - lastAttackTimer > attackCoolDown) {
//                    handler.getWorld().getEntityManager().getPlayer().hurt(1);
//                    lastAttackTimer = System.currentTimeMillis();
//                } else {
//                    System.out.print("Boot in cooldown");
//                }
//
//                System.out.print("Last attack timer" + lastAttackTimer);
//                if (handler.getWorld().getEntityManager().getPlayer().isActive() == false) {
//                    pause_move = false;
//                }
//            }
//
//
//            if (exista_intersectie == false) {
//                //daca player-ul nu se afla in vreo zona din apropierea bot-ului, pune-l in miscare
//
//                //nu mai ataca si pune-l in move
//                pause_move = false;
//                attack_down = false;
//                attack_up = false;
//                attack_left = false;
//                attack_right = false;
//            }
//
//        }
//
//    }
//    private void getInput() {
//        xMove = 0; // xMove-speed -> mica la dreapta, xMove+speed  misca la stanga
//        yMove = 0;
//    }
//
//    @Override
//    public void render(Graphics g) {
//
//        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
//        g.setColor(Color.red);
////        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
////                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
////                 bounds.width, bounds.height);
//
//        //Dreptunghi zona de sus
//        g.fillRect((int)(x - handler.getGameCamera().getxOffset()),
//                (int)(y - raza_attack - handler.getGameCamera().getyOffset()),
//                width,raza_attack);
//
//        //Dreptunghi zona de jos
//        g.fillRect((int)(x - handler.getGameCamera().getxOffset()),
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
//
//    }
//}