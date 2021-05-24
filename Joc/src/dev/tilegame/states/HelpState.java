package dev.tilegame.states;


import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.ui.ClickListener;
import dev.tilegame.tiles.ui.UIImageButton;
import dev.tilegame.tiles.ui.UIManager;

import java.awt.*;

public class HelpState extends State{

    private UIManager uiManager;
    public HelpState(Handler handler )
    {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);



        uiManager.addObject(new UIImageButton(20, 20, 48, 19, Assets.btn_Back, new ClickListener() {
            @Override
            public void onClick() {
                //handler.getMouseManager().setUiManager(null);//cand se schimba state-ul, sterge butonul de pe ecran

                State.setState(handler.getGame().getMenuState());
                handler.getMouseManager().setUiManager(handler.getGame().getMenuState().getUIManager());
            }
        }));

    }
    @Override
    public void tick() {

        uiManager.tick();
        verificaMenu();
    }

    @Override
    public void render(Graphics g) {


        g.drawImage(Assets.HelpState,0,0,null);
        uiManager.render(g);
    }

    public void verificaMenu() //verifica daca butonu de esc s-a apasat
    {
        if(handler.getKeyManager().o_menu)
        {
            State.setState(handler.getGame().getMenuState());
        }
    }

    public UIManager getUIManager()
    {
        return this.uiManager;
    }
}
