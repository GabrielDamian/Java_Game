package dev.tilegame.states;

import dev.tilegame.Audio.AudioPlayer;
import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.SQL.SQL;
import dev.tilegame.entities.creatures.Player;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.ui.ClickListener;
import dev.tilegame.tiles.ui.UIImageButton;
import dev.tilegame.tiles.ui.UIManager;

import java.awt.*;

public class SettingsState extends State{

    private UIManager uiManager;
    public SettingsState(Handler handler) {
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

        uiManager.addObject(new UIImageButton(450, 60, 48, 19, Assets.btn_reset, new ClickListener() {
            @Override
            public void onClick() {
                //handler.getMouseManager().setUiManager(null);//cand se schimba state-ul, sterge butonul de pe ecran

                //reseteaza baza de date inainte de inchidere joc
                //la urmatorul restart, jocul o sa inceapa cu datele default
                SQL.setSound(1);
                SQL.setLevel(1);
                SQL.setScore(0);
                SQL.setSpeed(3);
                SQL.setHearts(10);
                SQL.setPath("res/worlds/");
                SQL.update();
                System.exit(0);
            }
        }));

        uiManager.addObject(new UIImageButton(350, 220, 48, 19, Assets.switchImage, new ClickListener() {
            @Override
            public void onClick() {
                //handler.getMouseManager().setUiManager(null);//cand se schimba state-ul, sterge butonul de pe ecran

                boolean current_sound_state = Game.isSoundOn();

                Game.setSoundOn(!current_sound_state);

                //!temp data este starea urmatoare
                if (Game.isSoundOn() == false) {
                    handler.getGame().stopPlayingMusic();
                    SQL.setSound(0);
                    SQL.update();
                } else {
                    handler.getGame().playMenuMusic();
                    SQL.setSound(1);
                    SQL.update();
                }
            }


        }));

        uiManager.addObject(new UIImageButton(200, 480, 48, 19, Assets.difficulty_1, new ClickListener() {
            @Override
            public void onClick() {
                //handler.getMouseManager().setUiManager(null);//cand se schimba state-ul, sterge butonul de pe ecran

                handler.getWorld().getEntityManager().getPlayer().setSpeed(3);
                Player.setPlayerSpeed(3.0f);
                SQL.setSpeed(3);
                SQL.update();
            }
        }));
        uiManager.addObject(new UIImageButton(300, 480, 48, 19, Assets.difficulty_2, new ClickListener() {
            @Override
            public void onClick() {
                //handler.getMouseManager().setUiManager(null);//cand se schimba state-ul, sterge butonul de pe ecran

                handler.getWorld().getEntityManager().getPlayer().setSpeed(2);
                Player.setPlayerSpeed(2.0f);
                SQL.setSpeed(2);
                SQL.update();

            }
        }));
        uiManager.addObject(new UIImageButton(400, 480, 48, 19, Assets.difficulty_3, new ClickListener() {
            @Override
            public void onClick() {
                //handler.getMouseManager().setUiManager(null);//cand se schimba state-ul, sterge butonul de pe ecran

                handler.getWorld().getEntityManager().getPlayer().setSpeed(1);
                Player.setPlayerSpeed(1.0f);
                SQL.setSpeed(1);
                SQL.update();
            }
        }));



    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.settingsState,0,0,null);
        uiManager.render(g);
        g.setColor(Color.red);
        g.drawString(Boolean.toString(Game.isSoundOn()),400,235);
        g.drawString(Float.toString(Player.getPlayerSpeed()),480,440);

    }
    public UIManager getUIManager()
    {
        return this.uiManager;
    }
}
