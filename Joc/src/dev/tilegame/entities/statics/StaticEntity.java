package dev.tilegame.entities.statics;

import dev.tilegame.Handler;
import dev.tilegame.entities.Entity;

import java.awt.*;

public class StaticEntity extends Entity {
    //entitate care nu se misca pe mapa, ramane fixa
    public StaticEntity(Handler handler, float x, float y, int width, int height){
        super(handler, x,y,width,height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void die() {

    }

}
