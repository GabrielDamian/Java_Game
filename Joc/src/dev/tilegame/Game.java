package dev.tilegame;

import dev.tilegame.Audio.AudioPlayer;
import dev.tilegame.Audio.AudioPlayerManager;
import dev.tilegame.SQL.SQL;
import dev.tilegame.display.Dispaly;
import dev.tilegame.entities.creatures.Player;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.GameCamera;
import dev.tilegame.gfx.ImageLoader;
import dev.tilegame.gfx.SpriteSheet;
import dev.tilegame.input.KeyManager;
import dev.tilegame.input.MouseManager;
import dev.tilegame.states.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

public class Game implements Runnable{
    //Runnable permite sa rulezi clasa pe un thread separat
    //clasa main pentru joc care mentine tot continutul jocului
    //un thread permite sa rulezi o clasa intr-un "mini-program" separat de programul mare

    private boolean running = false; //spune game loop-lui daca daca este pornit sau nu

    private Dispaly display;
    private int width, height; //salvat width si height local in clasa pentru a le avea la indemana mereu
    public String title;
    public Thread thread; //jocul ruleaza pe un thread separat, nu era neaparat necesar

    private BufferStrategy bs;
    private Graphics g;



    //States - declaram toate state-urile posibile din joc
    private State gameState; //gameState este de tip State pentru a putea retine in el toate tipurile de state-uri
    private State menuState;
    private State helpState;
    private State wonState;
    private State loseState;
    private State settingsState;


    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    //Camera
    private GameCamera gameCamera;
    //Handler //obiect care face provide la date despre game (gettere si settere);
    private Handler handler;

    //Score and lives
    private static int score;
    private static int currentLevel;


    private int level_max = 3;

    //private AudioPlayer audioPlayer_music;
    private AudioPlayerManager gameMusic;

    private AudioPlayer audioPlayer_attack;





    private static boolean soundOn = true;
    private static String path;

    public static int singleton_item=0;

    public Game(String title, int width, int height) throws SQLException {

       //verifica daca baza de date exista, daca nu creeaza si pune niste date default



        //SQL.functieInitializare();

        //daca initializarea da eroare din vari motive, se forteaza insertul de mai joc comentat in SQL la primul run, iar la al doilea baza deja exista
        //SQL.insert(1,0,10,1,3,"res/worlds/");

        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();

        gameMusic = new AudioPlayerManager("/audio/MenuState.wav");


//        audioPlayer_music = new AudioPlayer("/audio/MenuState.wav");
        audioPlayer_attack = new AudioPlayer("/audio/Attack.wav");


        //SQL.functieInitializare();
        //.selectAll initializeaza variabilele statice din clasa SQL
        SQL.selectAll();
        Integer level_sql = SQL.getLevel();
        Integer score_sql = SQL.getScore();
        Integer hearts_sql = SQL.getHearts();
        Integer sound_sql = SQL.getSound();
        Integer speed_sql = SQL.getSpeed();
        String path_sql = SQL.getPath();

        System.out.print("aici:"+sound_sql);

        currentLevel = level_sql;
        score = score_sql;
        if(sound_sql ==1)
        {
            soundOn = true;
//            audioPlayer_music.loop_play();
            gameMusic.playAudioLoop();
        }
        else
        {
            soundOn = false;
        }

       Player.setPlayerHealt(hearts_sql);
       Player.setPlayerSpeed(speed_sql);

       Game.path = path_sql;


    }

    private void init()
    {
        display = new Dispaly(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);

        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        //cod de test
        //display.getCanvas().addKeyListener(keyManager);

//        // PROBLEMA INPUT MORT MOUSE
//        display.getFrame().requestFocusInWindow();
//        display.getFrame().setFocusable(true);


        Assets.init();

        handler = new Handler(this);
        gameCamera = new GameCamera(handler,0,0);

        //initializam toate state-urile, apoi setam currentSTate din clasa abstracta cu state-ul dorit

        menuState = new MenuState(handler);
        gameState = new GameState(handler); //gameStaet este de tip State (parinte abstract), deci GameState poate sta intr-o zona de tip State
        helpState = new HelpState(handler);
        wonState = new WonState(handler);
        loseState = new LoseState(handler);
        settingsState = new SettingsState(handler);



        State.setState(menuState); //jocul pleaca din state-ul setat aici
        handler.getMouseManager().setUiManager(handler.getGame().getMenuState().getUIManager());
        State.setHandler(handler);


        //Initializare date din sql la pornire joc


//        handler.getWorld().getEntityManager().getPlayer().setLives(hearts_sql);
    }
    private void tick()
    {
//        if(display.getFrame().isVisible())
//            display.getFrame().requestFocusInWindow();
        keyManager.tick();
        if(State.getState() != null) //daca un state in joc
        {
            State.getState().tick(); //ruleaza tick-ul din tipul state-ului pe care suntem setati (metoda in child mostenit din abstract State)
        }


    }
    private void render() //deseneaza pe ecran
    {
        bs = display.getCanvas().getBufferStrategy(); //bufferStrategy randeaza in avans imagini pentru a evita lag-ul
        if(bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics(); // Grapichs g ne permite sa desenam lucruri pe ecran
        //Clear the screen
        g.clearRect(0,0,width,height); //curata tot ecranul pentru fiecare render
        //Start Drawing

        if(State.getState() != null) //daca un state in joc
        {
            State.getState().render(g); //ruleaza renderul din tipul state-ului pe care suntem setati (metoda in child mostenit din abstract State)
            //aici g-ul pasat lui state ii spune pe ce "canvas" sa deseneze
        }
        //End drawing
        bs.show(); //metoda pentru bufferStrategy
        g.dispose(); //metoda pentru bufferStrategy



    }
    @Override
    public void run() { //metoda specifica clasei Runnable pentru a creata un thread separat

        init();

        int fps = 60; //de cate ori vrem sa facem call la tick si render pe secunda
        double timePerTick = 1000000000/fps; //sunt 10^9 nano secunde intr-o secunda
        double delta = 0; //cat trebuie sa treaca pana cand facem call al tick si render din nou
        long now; //current time de fiecare data cand intram in loop
        long lastTime = System.nanoTime(); //se face switch cu nou in loop
        long timer = 0; //numara fiecare secunda
        int ticks = 0; //numara numarul de frame-uri pe secunda

        while(running) //game loop
        {
            //now,lasTime si delta limiteaza cat de repede sa fie randat jocul, a.i sa ruleze la aceeasi viteza pe orice computer
            now = System.nanoTime(); //now - timpul curent in nano secunde
            delta += (now-lastTime)/timePerTick;
            timer += now - lastTime;
            lastTime = now;
            //delta o sa spuna cand trebuie si cand nu trebuie apelate tick() si render()


            if(delta >=1)
            {
                tick();
                render();
                ticks++;
                delta--;
            }
            if(timer >= 1000000000) //inseamna ca a trecut o secunda
            {
                System.out.println("Tick and Frames:" + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }


    public synchronized void start() //syncronized este specfic unei metoda care lucreaza cu un thread direct
            //similar cu async din js, care putea sa astepte Promise pana acesta devenea completata
    {
        if(running) //daca jocul este deja pornit, nu face nimin din metoda asta si iesi prin return si nu main executa nimic din metoda
        {
            return;
        }
        running = true; //porneste jocul
        thread = new Thread(this); //Constructorul Thread primeste ca parametru ce clasa vrei sa se ruleze pe threadul respectiv
        thread.start(); //thread.start face call la run method de mai sus
    }
    public synchronized void stop()
    {
        if(!running) //daca jocul ese deja oprit, iesi din metoda prin return
        {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //GETTERS AND SETTERS
    public KeyManager getKeyManager(){ return keyManager; }
    public MouseManager getMouseManager(){ return mouseManager; }
    public GameCamera getGameCamera() {return gameCamera;}
    public int getWidth(){
        return width;
    }
    public int getHeight()
    {
        return height;
    }

    public Dispaly getDisplay()
    {
        return this.display;
    }

    public State getGameState() {
        return gameState;
    }

    public State getMenuState() {
        return menuState;
    }

    public State getWonState(){ return wonState;}
    public State getSettingsState(){ return settingsState;}

    public State getHelpState() {
        return helpState;
    }

    public State getLoseState() {
        return loseState;
    }

    public Graphics getGraphics(){return g;}

    //SETTER & GETTER score, lives, current_level
    public void setScore(int new_score)
    {
        this.score = new_score;
    }
    public int getScore()
    {
        return this.score;
    }
    public void setLevel(int new_level)
    {
        this.currentLevel = new_level;
    }


    public int getLevel()
    {
        return this.currentLevel;
    }

    public int getLevel_max() {
        return level_max;
    }

    public void setLevel_max(int level_max) {
        this.level_max = level_max;
    }



    public AudioPlayer get_attack_player()
    {
        return this.audioPlayer_attack;
    }

    public static void setSoundOn(boolean soundOn) {
        Game.soundOn = soundOn;
    }

    public static boolean isSoundOn() {
        return soundOn;
    }

    public void playMenuMusic()
    {
//        audioPlayer_music.stop();
//        audioPlayer_music.setClip("/audio/MenuState.wav");
//        audioPlayer_music.loop_play();
        gameMusic.playNewAudio("/audio/MenuState.wav");

    }
    public void playGameMusic()
    {
//        audioPlayer_music.stop();
//        audioPlayer_music.setClip("/audio/GameState.wav");
//        audioPlayer_music.loop_play();

        gameMusic.playNewAudio("/audio/GameState.wav");


    }

    public void stopPlayingMusic(){
        //audioPlayer_music.stop();
        gameMusic.stopAudio();

    }

    public static String getPath(){ return path;};

    public static Game singletonLauncher(String title, int width, int height) throws SQLException {
        if(Game.singleton_item ==1)
        {
            System.out.print("Exista deja o instanta a jocului, nu se poate instantia alta");
            return null;
        }
        else
        {
            return new Game(title,width,height);
        }
    }
}
