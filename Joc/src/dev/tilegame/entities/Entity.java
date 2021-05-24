package dev.tilegame.entities;

import dev.tilegame.Game;
import dev.tilegame.Handler;

import java.awt.*;

public abstract class Entity { //evident
    //contine orice entitate din joc detine
    //protected, similar cu private, in schimb clasele derivate din Entity au acces

    public static final int DEFAULT_HEALTH = 100;
    protected Handler handler;
    protected float x,y;
    protected int width, height;
    protected int health;
    protected boolean active = true; //active = exista in game, false = a fost sterg din joc
    protected Rectangle bounds;  //rectangle folosit pentru coliziuni
    private boolean clean_on_next_level;

    public Entity(Handler handler, float x, float y, int width, int height)
    {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        health = DEFAULT_HEALTH;

        bounds  = new Rectangle(0,0,width, height); //by default, fiecare entitate are un rectangle care are marimea entitatii
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void die();

    public void hurt(int amt)
    {
        System.out.print("Cnv primeste damage");
        health -=amt;
        if(health <=0)
        {
            active = false;
            die();
        }
    }

    public boolean checkEntityCollisions(float xOffset, float yOffset)
    {
        for(Entity e: handler.getWorld().getEntityManager().getEnitites())
        {
            if(e.equals(this))
                continue; //nu veririfica coliziunea cu el insusi
            if(e.getCollisionBound(0f,0f).intersects(getCollisionBound(xOffset,yOffset)))
            {
                return true;
            }
        }
        return false;
    }
    public Rectangle getCollisionBound(float xOffset, float yOffset){
        return new Rectangle((int) (x+ bounds.x + xOffset),(int)(y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public int getHealth() {
        return health;
    }

    public boolean isActive() {
        return active;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    public Rectangle getBounds()
    {
        return this.bounds;
    }
    public boolean can_be_removed()
    {
        return this.clean_on_next_level;
    }

}
