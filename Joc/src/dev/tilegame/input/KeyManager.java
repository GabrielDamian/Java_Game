package dev.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener { //keylistener este clasa de sistem java

    private boolean[] keys;
    public boolean up, down, left, right;
    public boolean aUp, aDown, aLeft, aRight;
    public boolean esc;

    public boolean p_help, o_menu,i_start,u_exit;

    public KeyManager(){
        keys = new boolean[256]; //vector de "frecventa" dar pentru true and false pentru toate codurile key-lor de input
    }

    public void tick(){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];

        aUp = keys[KeyEvent.VK_UP];
        aDown = keys[KeyEvent.VK_DOWN];
        aLeft = keys[KeyEvent.VK_LEFT];
        aRight = keys[KeyEvent.VK_RIGHT];

        esc = keys[KeyEvent.VK_ESCAPE];

        p_help = keys[KeyEvent.VK_P];
        o_menu = keys[KeyEvent.VK_O];
        i_start = keys[KeyEvent.VK_I];
        u_exit = keys[KeyEvent.VK_U];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println("Pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {

        keys[e.getKeyCode()] = false;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    //temp setter

}
