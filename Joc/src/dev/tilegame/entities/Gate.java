package dev.tilegame.entities;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.SQL.SQL;
import dev.tilegame.gfx.Assets;
import dev.tilegame.states.State;

import java.awt.*;

public class Gate extends Entity{
    private boolean clean_on_next_level = true;
    public Gate(Handler handler, float x, float y) {
        super(handler, x, y, 64,64);
        health = 1;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.decor_1,(int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width, height,null);
    }

    @Override
    public void die() {
        //daca player-ul loveste gate-ul, trece la levelul urmator

        //handler.getWorld().getEntityManager().delete_all_creatures();

        int current_level = handler.getGame().getLevel();
        int level_max = handler.getGame().getLevel_max();
        current_level++;
        if(current_level > level_max)
        {
            State.setState(handler.getGame().getWonState());
            handler.getMouseManager().setUiManager(handler.getGame().getWonState().getUIManager());
            handler.getGame().setLevel(1);
            handler.getWorld().getEntityManager().getPlayer().setLives(10);

            handler.getWorld().loadWorld(Game.getPath() + "world1.txt");

//            handler.getGame().get_music_player().stop();
//            handler.getGame().get_music_player().setClip("/audio/GameState.wav");
//            handler.getGame().get_music_player().loop_play();
                handler.getGame().playMenuMusic();

            SQL.setHearts(10);
            SQL.setLevel(1);
            SQL.setScore(0);
            SQL.update();
        }
        else
        {
            handler.getGame().setLevel(current_level);
            String current_lvl_str = Integer.toString(current_level);
            handler.getWorld().loadWorld("res/worlds/world" + current_lvl_str + ".txt");

            SQL.setHearts(handler.getWorld().getEntityManager().getPlayer().getLives());
            SQL.setLevel(current_level);
            SQL.setScore(handler.getGame().getScore());
            SQL.update();
        }

    }
    //                SQL.setHearts(handler.getWorld().getEntityManager().getPlayer().getLives());
//            SQL.setLevel(current_level);
//            SQL.setScore(handler.getGame().getScore());
//            SQL.update();
    @Override
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
    public boolean can_be_removed()
    {
        return this.clean_on_next_level;
    }

}
