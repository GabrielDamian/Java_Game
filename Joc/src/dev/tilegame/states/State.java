package dev.tilegame.states;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.tiles.ui.UIManager;

import java.awt.*;

public abstract class State { //clasa asbstracta, deoarece toate state-urile(mai menu, settings, game) deriva din aceasta clasa(au elemente comune)
    //States manager//controleaza toate clasele derivate din abs State
    //Este abstract deoarece vrem sa fie controlat de oriunde in joc

    private UIManager uiManager_;
    private static State currentState = null;
    private static Handler handler_temp;

    public static void setHandler(Handler new_hand)
    {
        handler_temp = new_hand;
    }
    public static void setState(State state)    //setter
    {

        currentState = state;

    }
    public static State getState()   //getter
    {
        return currentState;
    }
    //CLASS
    protected Handler handler;

    public State(Handler handler)
    {
        this.handler = handler;
    }

    //State abstract class //este separat de state manager
    public abstract void tick();
    public abstract void render(Graphics g); //state-ul trebuie sa fie capabil sa se auto-deseneze pe ecran direct


    public UIManager getUIManager() {
        return uiManager_;
    }
}
