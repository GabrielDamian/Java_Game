package dev.tilegame.entities.statics;

import dev.tilegame.Handler;
import dev.tilegame.gfx.Assets;
import dev.tilegame.states.State;
import dev.tilegame.tiles.Tile;

import java.awt.*;

public class Tree extends StaticEntity{

    public Tree(Handler handler, float x, float y) {

        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT*2);
        bounds.x = 10;
        bounds.y = (int)(height / 1.5f);
        bounds.width = width - 20;
        bounds.height = (int)(height-height/1.5f);
    }
    @Override
    public void tick(){
        next_level();
    }
    @Override
    public void die()
    {

    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.decor_1,(int) (x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()), width, height,null);
    }

    public void next_level()
    {
        //Rectangle temp = new Rectangle((int)this.getX(),(int)this.getY(),700,700);
        Rectangle tree = this.getCollisionBound(10,10);
        Rectangle player = handler.getWorld().getEntityManager().getPlayer().getCollisionBound(0,0);

        if(player.intersects(tree))
        {
            System.out.print("CEVA");
//            State.setState(handler.getGame().getMenuState());
//            handler.getMouseManager().setUiManager(handler.getGame().getMenuState().getUIManager());
//
            handler.getWorld().getEntityManager().getPlayer().setX(200);
            handler.getWorld().getEntityManager().getPlayer().setY(200);

            handler.getWorld().loadWorld("res/worlds/world2.txt");
        }


//        if(temp.intersects(handler.getWorld().getEntityManager().getPlayer().getBounds()))
//        {
//            System.out.print("intersect cu mapa");
//        }
    }
}
