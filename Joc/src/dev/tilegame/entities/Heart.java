package dev.tilegame.entities;

import dev.tilegame.Handler;
import dev.tilegame.SQL.SQL;
import dev.tilegame.entities.creatures.Creature;
import dev.tilegame.gfx.Animation;
import dev.tilegame.gfx.Assets;

import javax.xml.ws.soap.Addressing;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Heart extends Entity{

    private Animation up_down;
    private boolean clean_on_next_level = true;

    public Heart(Handler handler, float x, float y) {
        super(handler, x, y, 32, 32);
        health = 1;

        up_down = new Animation(100,Assets.heart);
    }

    @Override
    public void tick() {
        up_down.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width, height,null);
    }

    @Override
    public void die() {
        //cand o entitate de tip heart moare prin attack, creste numarul de vieti ale player-ului
        int current_lives = handler.getWorld().getEntityManager().getPlayer().getLives();
        handler.getWorld().getEntityManager().getPlayer().setLives(current_lives+1);



    }
    private BufferedImage getCurrentAnimationFrame()
    {
        return up_down.getCurrentFrame();
    }
    public boolean can_be_removed()
    {
        return this.clean_on_next_level;
    }
}
