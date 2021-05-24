package dev.tilegame.Worlds;

import dev.tilegame.Handler;
import dev.tilegame.entities.EntityManager;

import dev.tilegame.entities.Gate;
import dev.tilegame.entities.Heart;
import dev.tilegame.entities.creatures.Player;
import dev.tilegame.entities.creatures.bots.Crow;
import dev.tilegame.entities.creatures.bots.FlyingEye;
import dev.tilegame.entities.creatures.bots.PurpleWizard;
import dev.tilegame.tiles.Tile;
import dev.tilegame.utils.Utils;

import javax.sound.midi.SysexMessage;
import java.awt.*;

public class World {
    private Handler handler;
    private int width, height;  //marimea hartii
    private int spawnX, spawnY;  //punctul de spanw pentru player

    private int[][] tiles;  //matrice pentru harta

    //Entitites
    private EntityManager entityManager;


    public World(Handler handler, String path)
    {
        this.handler = handler;
        //entityManager = new EntityManager(handler, new Player(handler, 0,0));

//        entityManager.addEntity(new Heart(handler,100,100));
//        entityManager.addEntity(new Heart(handler,100,200));
//        entityManager.addEntity(new Heart(handler,100,300));

        //entityManager.addEntity(new Gate(handler,100,400));

        //entityManager.addEntity(new Tree(handler, 100,100));
        //entityManager.addEntity(new FlyingEye(handler, 200,200));
//        entityManager.addEntity(new FlyingEye(handler, 230,400,160,9));
//        entityManager.addEntity(new FlyingEye(handler, 200,500,100,1));
//        entityManager.addEntity(new FlyingEye(handler, 190,600,120,2));
//        entityManager.addEntity(new FlyingEye(handler, 250,700,200,3));
        //entityManager.addEntity(new PurpleWizard(handler,200,300,90,1));

//        entityManager.addEntity(new Crow(handler, 200,300,90,1));
//        entityManager.addEntity(new FlyingEye(handler, 200,400,90,1));

        //entityManager.addEntity(new Evil_test(handler,200,200));

        loadWorld(path);

//        entityManager.getPlayer().setX(spawnX);
//        entityManager.getPlayer().setY(spawnY);

    }
    public void tick()
    {
        entityManager.tick(); //tick la toate entitatile
    }
    public void render (Graphics g)
    {
        int xStart = (int) Math.max(0,handler.getGameCamera().getxOffset() / Tile.TILEWIDTH); //marginile dalelor care se vad pe ecran (singurele care ar trebui randate, deoarece doar ele se vad pe ecran)
        int xEnd=(int)Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart =(int) Math.max(0,handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd=(int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

        for(int y=yStart;y<yEnd;y++)
            for(int x =xStart;x<xEnd;x++)
            {
                getTile(x,y).render(g,(int)(x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
                        (int)(y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset())); //x si y sunt unitati de tiles si trebuie transformate in unitati de ecran

            }
        //Entities
        entityManager.render(g);
    }
    public Tile getTile(int x, int y)
    {
        if(x <0 || y < 0 || x>=width || y >= height) //te asigura ca nu ai iesit din mapa
            return Tile.grassTile;

        Tile t = Tile.tiles[tiles[x][y]]; //array din clasa Tile
        if( t == null)
            return Tile.dirtTile;
        return t;
    }
    public void loadWorld(String path) {
        String file = Utils.loadFileAsString(path); //clasa declarata in utils si contine metoda ajutatoare pentru program
        //loadFileAsString incarca continutul din fisierul dat la path

        String[] tokens = file.split("\\s+");    //split la oricat de multe spatii albe

        width = Utils.parseInt(tokens[0]); //marimea hartii
        height = Utils.parseInt(tokens[1]);

        spawnX = Utils.parseInt(tokens[2]); //punctul de spawn pentru player
        spawnY = Utils.parseInt(tokens[3]);
        entityManager = new EntityManager(handler, new Player(handler, spawnX,spawnY));

        tiles = new int[width][height];
        for(int y = 0;y<height;y++)
            for(int x=0;x<width;x++)
            {
                tiles[x][y] = Utils.parseInt(tokens[(x+y * width) + 4 ]); //primele 4 lucruri sunt marimea mapei si pozitia de spawn
            }

        //incarca mobi
        int temp_nr_mobi = Utils.parseInt(tokens[4 + width*height]);
        int date_anterioare = 4+width*height +1;
        System.out.print("Nr mobi:" + temp_nr_mobi);
        for(int i = 0;i<temp_nr_mobi;i++)
        {
            //Format linie mobi:
            //type x y raza_patrulare speed
            float mob_type = Utils.parseInt(tokens[date_anterioare +i*5]); //*5 doarece pe fiecare linie sunt 5 elemente
            float coord_x = Utils.parseInt(tokens[date_anterioare + i*5 + 1]);
            float coord_y = Utils.parseInt(tokens[date_anterioare +i*5 + 2]);
            int raza_patrula = Utils.parseInt(tokens[date_anterioare +i*5 +3]);
            float speed = Utils.parseInt(tokens[date_anterioare +i*5 + 4]);

            //mob types: [1]-flying eye, [2]-crow, [3]-purple wizard
            System.out.println("Inainte de if's: " + mob_type);
            if(mob_type == 1)
            {
                entityManager.addEntity(new FlyingEye(handler,coord_x,coord_y,raza_patrula,speed));
                System.out.print("Spawn eye");
            }
            else if(mob_type == 2)
            {
                entityManager.addEntity(new Crow(handler,coord_x,coord_y,raza_patrula,speed));
                System.out.print("Spawn crow");
            }else if (mob_type == 3)
            {
                entityManager.addEntity(new PurpleWizard(handler,coord_x,coord_y,raza_patrula,speed));
                System.out.print("Spawn purple wizard");
            }
        }
        int nr_hearts = Utils.parseInt(tokens[date_anterioare + temp_nr_mobi*5]);
        int data_before_hearts = date_anterioare + temp_nr_mobi*5 +1; //1+ pentru numarul de hearts

//        int x_temp = Utils.parseInt(tokens[data_before_hearts]);
//        int y_temp = Utils.parseInt(tokens[data_before_hearts+1]);
//        System.out.print("X: " + x_temp + "Y: " + y_temp);


        for(int i=0;i<nr_hearts;i++)
        {
            int x_heart = Utils.parseInt(tokens[data_before_hearts +i*2]);
            int y_heart = Utils.parseInt(tokens[data_before_hearts +i*2 + 1 ]);

            entityManager.addEntity(new Heart(handler, x_heart,y_heart));
        }
        System.out.println("HEARRTS: " + nr_hearts);

        int x_GATE = Utils.parseInt(tokens[data_before_hearts + 2*nr_hearts]);
        int y_GATE = Utils.parseInt(tokens[data_before_hearts + 2*nr_hearts + 1]);
        entityManager.addEntity(new Gate(handler, x_GATE,y_GATE));
    }
    public int getWidth(){
        return width;
    }
    public int getHeight()
    {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
