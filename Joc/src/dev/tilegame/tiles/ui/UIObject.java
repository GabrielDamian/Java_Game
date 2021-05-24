package dev.tilegame.tiles.ui;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UIObject
{
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;
    protected boolean hovering = false;

    public UIObject(float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle((int)x,(int)y,width, height);
    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void onClick();


    public void onMouseMove(MouseEvent e){
        //verifica daca mouse-ul este peste butonul curent
        if(bounds.contains(e.getX(),e.getY()))
        {
            hovering = true;
        }
        else
        {
            hovering = false;
        }
    }
    public void onMouseRelease(MouseEvent e){
        if(hovering)
        {
            //daca suntem pe buton si dam drumul la click
            onClick();
        }
    }
    //Getters && setters

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isHovering() {
        return hovering;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setHovering(boolean hovering) {
        this.hovering = hovering;
    }
}