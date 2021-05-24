package dev.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Animation {

    private int speed, index;
    private BufferedImage[] frames;
    private long lastTime, timer;
    public Animation(int speed, BufferedImage[] frames)
    {
        this.speed = speed;
        this.frames = frames;
        index = 0;
        lastTime = System.currentTimeMillis(); //secunde trecute de cand a inceput jocul
        timer = 0;
    }

    public void tick(){
        timer += System.currentTimeMillis() - lastTime; //secunde trecute intre metodele tick ale jocului
        lastTime = System.currentTimeMillis(); //update la noul lastTime

        if(timer > speed)
        {
            index++;
            timer = 0;
            if(index >= frames.length)
            {
                index = 0; //restart la animatie
            }
        }
    }
    public BufferedImage getCurrentFrame(){
        return frames[index];
    }

}
