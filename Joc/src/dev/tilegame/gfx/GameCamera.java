package dev.tilegame.gfx;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.entities.Entity;
import dev.tilegame.tiles.Tile;

public class GameCamera {

    private float xOffset, yOffset;
    private Handler handler;

    public GameCamera(Handler handler, float xOffset, float yOffset)
    {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    public void checkBlankSpace()
    {
        if(xOffset<0)
        {
            xOffset = 0; //limiteaza camera sa nu randeze spatii albe din afara mapei si astfel blocheaza camera sa nu iasa din mapa
        }else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth())
        {
            xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth(); //opreste camera sa depaseasca marginea din dreapta
        }
        if(yOffset < 0)
        {
            yOffset = 0;
        }else if(yOffset > handler.getWorld().getHeight()*Tile.TILEHEIGHT - handler.getHeight())
        {
            yOffset = handler.getWorld().getHeight()*Tile.TILEHEIGHT - handler.getHeight();
        }
    }
    public void centerOnEntity(Entity e)
    {
        xOffset = e.getX() - handler.getWidth()/2 + e.getWidth()/2; //centreaza playerul in mijloc
        yOffset = e.getY() - handler.getHeight()/2 + e.getHeight()/2;
        checkBlankSpace();

    }
    public void move(float xAmt, float yAmt)
    {
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }
    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
