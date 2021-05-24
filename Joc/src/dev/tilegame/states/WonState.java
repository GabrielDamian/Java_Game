package dev.tilegame.states;

import dev.tilegame.Handler;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.ui.ClickListener;
import dev.tilegame.tiles.ui.UIImageButton;
import dev.tilegame.tiles.ui.UIManager;

import java.awt.*;

public class WonState extends State{
    private UIManager uiManager;

    public WonState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton((int)((int)handler.getGame().getWidth()/2)-30, (int)((int)handler.getGame().getHeight()/2)+120, 48, 19, Assets.btn_Back, new ClickListener() {
            @Override
            public void onClick() {
                //handler.getMouseManager().setUiManager(null);//cand se schimba state-ul, sterge butonul de pe ecran
                System.out.println("Ceva");
                State.setState(handler.getGame().getMenuState());
                handler.getMouseManager().setUiManager(handler.getGame().getMenuState().getUIManager());

                handler.getGame().setLevel(1);
                handler.getGame().setScore(0);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        handler.getGame().getGraphics().drawImage(Assets.wonState,0,0,null,null);
        uiManager.render(g);
        g.setColor(Color.red);
        g.drawString(Integer.toString(handler.getGame().getScore()),387,433);

    }
    public UIManager getUIManager()
    {
        return this.uiManager;
    }

}
