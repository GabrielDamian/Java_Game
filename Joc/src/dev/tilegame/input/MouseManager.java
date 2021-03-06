package dev.tilegame.input;

import dev.tilegame.tiles.ui.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;
    private UIManager uiManager;

    public MouseManager(){

    }

    public void setUiManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }

    //Getters
    public boolean isLeftPressed(){
        return leftPressed;
    }
    public boolean isRightPressed(){
        return rightPressed;
    }
    public int getMouseX(){
        return mouseX;
    }
    public int getMouseY(){
        return mouseY;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) //buton stanga mouse
        {
            leftPressed = true;
        }
        else if(e.getButton() == MouseEvent.BUTTON3) //buton dreapta mouse, Button2 = click pe rotita de la mouse
        {
            rightPressed = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) //buton stanga mouse
        {
            leftPressed = false;
        }
        else if(e.getButton() == MouseEvent.BUTTON3) //buton dreapta mouse, Button2 = click pe rotita de la mouse
        {
            rightPressed = false;
        }

        if(uiManager != null)
            uiManager.onMouseRelease(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        if(uiManager != null)
            uiManager.onMouseMove(e);

    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }


}
