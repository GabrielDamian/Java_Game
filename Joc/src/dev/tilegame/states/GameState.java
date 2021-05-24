package dev.tilegame.states;

import com.sun.javafx.image.IntPixelGetter;
import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.Worlds.World;
import dev.tilegame.entities.creatures.Player;
import dev.tilegame.entities.statics.Tree;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

import java.awt.*;

public class GameState extends State{   //state-ul in care se joaca

    private Player player;
    private World world;

    public GameState(Handler handler)
    {
        super(handler);
        int current_level = handler.getGame().getLevel();
        String current_level_str =  Integer.toString(current_level);
        world = new World(handler,"res/worlds/world"+current_level_str +".txt");
        handler.setWorld(world); //similar cu un dispatch care updateaza un camp in store (REACT), store-ul fiind clasa handler
        //player = new Player(handler,100,100);//x si y ii spune de unde sa inceapa


    }
    @Override
    public void tick() {
        world.tick();
        verificaNavigare();
    }

    @Override
    public void render(Graphics g) { //cum se "desezeana" Game-state-ul (actiunea in sine)
        world.render(g);

        //render score, lives, current level
        g.drawImage(Assets.tabela,225,630,null);
        g.drawString(Integer.toString(handler.getWorld().getEntityManager().getPlayer().getLives()),320,675);
        g.drawString(Integer.toString(handler.getGame().getScore()),500,675);

    }

    public void verificaNavigare()
    {
        if(handler.getKeyManager().esc)
        {
            State.setState(handler.getGame().getMenuState());
            handler.getMouseManager().setUiManager(handler.getGame().getMenuState().getUIManager());

            if(Game.isSoundOn())
            {
                handler.getGame().playMenuMusic();
            }
        }

    }

}
