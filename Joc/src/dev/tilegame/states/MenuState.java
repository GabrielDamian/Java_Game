package dev.tilegame.states;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.gfx.Animation;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.ui.ClickListener;
import dev.tilegame.tiles.ui.UIImageButton;
import dev.tilegame.tiles.ui.UIManager;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MenuState extends State{

    private UIManager uiManager;

    private Animation bg_anim;
    private Animation player_running;
    private Animation flyingEye;
    private Animation crow;
    private Animation purpleWizard;


    public MenuState(Handler handler )
    {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton((int)((int)handler.getGame().getWidth()/2)-30, (int)((int)handler.getGame().getHeight()/2)-90, 48, 19, Assets.btn_Start, new ClickListener() {
            @Override
            public void onClick() {
                //handler.getMouseManager().setUiManager(null);//cand se schimba state-ul, sterge butonul de pe ecran

                State.setState(handler.getGame().getGameState());
                handler.getMouseManager().setUiManager(handler.getGame().getGameState().getUIManager());


                //the play la muzica la scimbarea din menu->game, doar daca booleanul este setat pe true;
                if(Game.isSoundOn())
                {
//                    handler.getGame().get_music_player().stop();
//                    handler.getGame().get_music_player().setClip("/audio/GameState.wav");
//                    handler.getGame().get_music_player().loop_play();
                    handler.getGame().playGameMusic();
                }

            }
        }));
        uiManager.addObject(new UIImageButton((int)((int)handler.getGame().getWidth()/2)-30, (int)((int)handler.getGame().getHeight()/2)-60, 48, 19, Assets.btn_Help, new ClickListener() {
            @Override
            public void onClick() {
                //.getMouseManager().setUiManager(null);//cand se schimba state-ul, sterge butonul de pe ecran
                State.setState(handler.getGame().getHelpState());
                handler.getMouseManager().setUiManager(handler.getGame().getHelpState().getUIManager());
            }
        }));
        uiManager.addObject(new UIImageButton((int)((int)handler.getGame().getWidth()/2)-30, (int)((int)handler.getGame().getHeight()/2)-35, 48, 19, Assets.btn_settings, new ClickListener() {
            @Override
            public void onClick() {
                //handler.getMouseManager().setUiManager(null);//cand se schimba state-ul, sterge butonul de pe ecran
                State.setState(handler.getGame().getSettingsState());
                handler.getMouseManager().setUiManager(handler.getGame().getSettingsState().getUIManager());
            }
        }));
        uiManager.addObject(new UIImageButton((int)((int)handler.getGame().getWidth()/2)-30, (int)((int)handler.getGame().getHeight()/2)-10, 48, 19, Assets.btn_Exit, new ClickListener() {
            @Override
            public void onClick() {
                //handler.getMouseManager().setUiManager(null);//cand se schimba state-ul, sterge butonul de pe ecran
                System.exit(0);
            }
        }));

        //initializam animatia de bg
        //temporar player attack left
        bg_anim = new Animation(100,Assets.bg_anim);
        player_running = new Animation(80, Assets.player_right);
        flyingEye = new Animation(100,Assets.eyeball_run_right);
        crow = new Animation(100,Assets.crow_move_right);
        purpleWizard = new Animation(100,Assets.purpleWizar_move_right);



    }
    @Override
    public void tick() {

        uiManager.tick();
        //verificaNavigare();
        bg_anim.tick();
        player_running.tick();
        flyingEye.tick();
        crow.tick();
        purpleWizard.tick();
    }
 
    @Override
    public void render(Graphics g) {

        int temp_game_width = handler.getGame().getWidth();
        int temp_game_height = handler.getGame().getHeight();
        handler.getGame().getGraphics().drawImage(getCurrent_BG_AnimationFrame(),0,0,null,null);
        handler.getGame().getGraphics().drawImage(getcurrent_player_run_AnimationFrame(),588,490,null,null);
        handler.getGame().getGraphics().drawImage(getCurrentEyeBall_run_AnimationFrame(),400,500,null,null);
        handler.getGame().getGraphics().drawImage(getCurrentCrow_run_AnimationFrame(),340,483,null,null);
        handler.getGame().getGraphics().drawImage(getCurrentPurpleWizard_run_AnimationFrame(),238,435,null,null);

        uiManager.render(g);
    }

//    public void verificaNavigare()
//    {
//        if(handler.getKeyManager().p_help)
//        {
//            State.setState(handler.getGame().getHelpState());
//        }
//        else if(handler.getKeyManager().i_start)
//        {
//
//            State.setState(handler.getGame().getGameState());
//
//        }else if(handler.getKeyManager().u_exit)
//        {
//            System.out.print("Exit game");
//            handler.getGame().getDisplay().getFrame().dispatchEvent(new WindowEvent(handler.getGame().getDisplay().getFrame(), WindowEvent.WINDOW_CLOSING));
//        }
//    }

    public UIManager getUIManager()
    {
        return this.uiManager;
    }

    private BufferedImage getCurrent_BG_AnimationFrame()
    {
        return bg_anim.getCurrentFrame();
    }
    private BufferedImage getcurrent_player_run_AnimationFrame(){return player_running.getCurrentFrame();}
    private BufferedImage getCurrentEyeBall_run_AnimationFrame(){return flyingEye.getCurrentFrame();}
    private BufferedImage getCurrentCrow_run_AnimationFrame(){return crow.getCurrentFrame();}
    private BufferedImage getCurrentPurpleWizard_run_AnimationFrame(){return purpleWizard.getCurrentFrame();}
}
