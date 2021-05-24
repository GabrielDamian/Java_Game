package dev.tilegame.tiles;

import dev.tilegame.tiles.DownGate_components.*;
import dev.tilegame.tiles.Floor.BrownFloor_.*;
import dev.tilegame.tiles.Floor.Decorator_.*;
import dev.tilegame.tiles.Floor.FloorMov_.*;
import dev.tilegame.tiles.Floor.WhiteFloor_.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);


    //DownGate
    public static Tile downGate_1 = new DownGate_1(2);
    public static Tile downGate_2 = new DownGate_2(3);
    public static Tile downGate_3 = new DownGate_3(4);
    public static Tile downGate_4 = new DownGate_4(5);
    public static Tile downGate_5 = new DownGate_5(6);
    public static Tile downGate_6 = new DownGate_6(7);
    public static Tile downGate_7 = new DownGate_7(8);
    public static Tile downGate_8 = new DownGate_8(9);

    //Floor Alb
    public static Tile floor_alb_1 = new WhiteFloor_1(10);
    public static Tile floor_alb_2 = new WhiteFloor_2(11);
    public static Tile floor_alb_3 = new WhiteFloor_3(12);
    public static Tile floor_alb_4 = new WhiteFloor_4(13);
    public static Tile floor_alb_5 = new WhiteFloor_5(14);
    public static Tile floor_alb_6 = new WhiteFloor_6(15);
    public static Tile floor_alb_7 = new WhiteFloor_7(16);
    public static Tile floor_alb_8 = new WhiteFloor_8(17);

    //Floor Alb Verde
    public static Tile floor_alb_verde_1 = new WhiteGreenFloor_1(18);
    public static Tile floor_alb_verde_2 = new WhiteGreenFloor_2(19);
    public static Tile floor_alb_verde_3 = new WhiteGreenFloor_3(20);
    public static Tile floor_alb_verde_4 = new WhiteGreenFloor_4(21);
    public static Tile floor_alb_verde_5 = new WhiteGreenFloor_5(22);
    public static Tile floor_alb_verde_6 = new WhiteGreenFloor_6(23);
    public static Tile floor_alb_verde_7 = new WhiteGreenFloor_7(24);
    public static Tile floor_alb_verde_8 = new WhiteGreenFloor_8(25);

    //Floor Brown
    public static Tile floor_brown_1 = new BrownFloor_1(26);
    public static Tile floor_brown_2 = new BrownFloor_2(27);
    public static Tile floor_brown_3 = new BrownFloor_3(28);
    public static Tile floor_brown_4 = new BrownFloor_4(29);
    public static Tile floor_brown_5 = new BrownFloor_5(30);
    public static Tile floor_brown_6 = new BrownFloor_6(31);
    public static Tile floor_brown_7 = new BrownFloor_7(32);
    public static Tile floor_brown_8 = new BrownFloor_8(33);
    //Floor Brown Verde
    public static Tile floor_green_brown_1 = new BrownGreenFloor_1(34);
    public static Tile floor_green_brown_2 = new BrownGreenFloor_2(35);
    public static Tile floor_green_brown_3 = new BrownGreenFloor_3(36);
    public static Tile floor_green_brown_4 = new BrownGreenFloor_4(37);
    public static Tile floor_green_brown_5 = new BrownGreenFloor_5(38);
    public static Tile floor_green_brown_6 = new BrownGreenFloor_6(39);
    public static Tile floor_green_brown_7 = new BrownGreenFloor_7(40);
    public static Tile floor_green_brown_8 = new BrownGreenFloor_8(41);

    //Floor Mov
    public static Tile floor_mov_1 = new FloorMov_1(42);
    public static Tile floor_mov_2 = new FloorMov_2(43);
    public static Tile floor_mov_3 = new FloorMov_3(44);
    public static Tile floor_mov_4 = new FloorMov_4(45);
    public static Tile floor_mov_5 = new FloorMov_5(46);
    public static Tile floor_mov_6 = new FloorMov_6(47);
    public static Tile floor_mov_7 = new FloorMov_7(48);
    public static Tile floor_mov_8 = new FloorMov_8(49);
    public static Tile floor_mov_9 = new FloorMov_9(50);
    public static Tile floor_mov_10 = new FloorMov_10(51);
    public static Tile floor_mov_11 = new FloorMov_11(52);
    public static Tile floor_mov_12 = new FloorMov_12(53);
    public static Tile floor_mov_13 = new FloorMov_13(54);
    public static Tile floor_mov_14 = new FloorMov_14(55);
    public static Tile floor_mov_15 = new FloorMov_15(56);
    public static Tile floor_mov_16 = new FloorMov_16(57);

    //Floor Mov Verde
    public static Tile floor_mov_verde_1 = new FloorMovVerde_1(58);
    public static Tile floor_mov_verde_2 = new FloorMovVerde_2(59);
    public static Tile floor_mov_verde_3 = new FloorMovVerde_3(60);
    public static Tile floor_mov_verde_4 = new FloorMovVerde_4(61);
    public static Tile floor_mov_verde_5 = new FloorMovVerde_5(62);
    public static Tile floor_mov_verde_6 = new FloorMovVerde_6(63);
    public static Tile floor_mov_verde_7 = new FloorMovVerde_7(64);
    public static Tile floor_mov_verde_8 = new FloorMovVerde_8(65);
    public static Tile floor_mov_verde_9 = new FloorMovVerde_8(66);
    public static Tile floor_mov_verde_10 = new FloorMovVerde_9(67);
    public static Tile floor_mov_verde_11 = new FloorMovVerde_10(68);
    public static Tile floor_mov_verde_12 = new FloorMovVerde_11(69);
    public static Tile floor_mov_verde_13 = new FloorMovVerde_12(70);
    public static Tile floor_mov_verde_14 = new FloorMovVerde_13(71);
    public static Tile floor_mov_verde_15 = new FloorMovVerde_14(72);
    public static Tile floor_mov_verde_16 = new FloorMovVerde_15(73);


    //Decoratoare
    public static Tile decor_1 = new Decorator_1(74);
    public static Tile decor_2 = new Decorator_2(75);
    public static Tile decor_3 = new Decorator_3(76);
    public static Tile decor_4 = new Decorator_4(77);
    public static Tile decor_5 = new Decorator_5(78);
    public static Tile decor_6 = new Decorator_6(79);
    public static Tile decor_7 = new Decorator_7(80);
    public static Tile decor_8 = new Decorator_8(81);
    public static Tile decor_9 = new Decorator_9(82);

    //Butoane

    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
    protected BufferedImage texture;
    protected final int id; //id-ul este final deoarece este unic, deci nu poate fi schimbat

    public Tile(BufferedImage texture, int id)
    {
        this.texture = texture;
        this.id = id;

        tiles[id] = this; //la indexul "id", pune un tile de tipul id-ului respectiv
    }

    public void tick()
    {

    }
    public void render(Graphics g, int x, int y)
    {
        g.drawImage(texture,x,y,TILEWIDTH, TILEHEIGHT, null);
    }
    public boolean isSolid() //trebuie suprascrisa in subclase si customizata in functie de necesitati (poate sau nu player-ul sa mearga pe el)
    {
        return false;
    }
    public int getId()
    {
        return id;
    }
}
