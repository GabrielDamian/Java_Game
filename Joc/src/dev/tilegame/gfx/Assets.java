package dev.tilegame.gfx;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Assets {
    //clasa care o sa retina toate asseturile, "taiate" din sheet-ul general

    private static final int width = 16, height = 16; //cat de mari sunt "dalele" din sheetul general
    public static BufferedImage dirt, grass;

    //Gate_1
    public static BufferedImage down_gate_1,down_gate_2,down_gate_3,down_gate_4,down_gate_5,down_gate_6,down_gate_7,down_gate_8;


    //Floor_alb
    public static BufferedImage floor_alb_1, floor_alb_2,floor_alb_3,floor_alb_4, floor_alb_5, floor_alb_6, floor_alb_7, floor_alb_8;
    //Floor_alb_verde_
    public static BufferedImage floor_alb_verde_1,floor_alb_verde_2,floor_alb_verde_3,floor_alb_verde_4,floor_alb_verde_5,floor_alb_verde_6,floor_alb_verde_7,floor_alb_verde_8;

    //Floor brown
    public static BufferedImage floor_brown_1, floor_brown_2, floor_brown_3, floor_brown_4, floor_brown_5, floor_brown_6, floor_brown_7, floor_brown_8;
    //Floor brown_verde
    public static BufferedImage floor_brown_verde_1,floor_brown_verde_2,floor_brown_verde_3,floor_brown_verde_4,floor_brown_verde_5,floor_brown_verde_6,floor_brown_verde_7,floor_brown_verde_8;

    //Floor mov
    public static BufferedImage floor_mov_1,floor_mov_2,floor_mov_3,floor_mov_4,floor_mov_5,floor_mov_6,floor_mov_7,floor_mov_8,floor_mov_9,floor_mov_10,
            floor_mov_11,floor_mov_12,floor_mov_13,floor_mov_14,floor_mov_15,floor_mov_16;

    public static BufferedImage floor_mov_verde_1,floor_mov_verde_2,floor_mov_verde_3,floor_mov_verde_4,floor_mov_verde_5,floor_mov_verde_6,floor_mov_verde_7,floor_mov_verde_8,
            floor_mov_verde_9,floor_mov_verde_10,floor_mov_verde_11,floor_mov_verde_12,floor_mov_verde_13,floor_mov_verde_14,floor_mov_verde_15,floor_mov_verde_16;
    //Floor mov_verde_

    public static BufferedImage decor_1,decor_2,decor_3,decor_4,decor_5,decor_6,decor_7,decor_8,decor_9;

    public static BufferedImage[] player_stop,player_down, player_up, player_right, player_left;

    //Butoane meniu
    public static BufferedImage[] btn_Start;
    public static BufferedImage[] btn_Help;
    public static BufferedImage[] btn_Exit;
    public static BufferedImage[] btn_Back;
    public static BufferedImage[] btn_settings;

    //Attack player_down
    public static BufferedImage[] player_attack_down;
    //Attack player_left

    public static BufferedImage[] player_attack_left;
    //Attack right
    public static BufferedImage[] player_attack_right;
    //Attack up
    public static BufferedImage[] player_attack_up;


    //Bg gif
    public static BufferedImage[] bg_anim;

    //Creatures
    //Eye ball

    public static BufferedImage[] eyeball_stop_right;
    public static BufferedImage[] eyeball_stop_left;

    public static BufferedImage[] eyeball_run_right;
    public static BufferedImage[] eyeball_run_left;

    public static BufferedImage[] eyeball_attack_right;
    public static BufferedImage[] eyeball_attack_left;
    public static BufferedImage[] eyeball_die;

    public static BufferedImage[] take_damage;

    public static BufferedImage[] crow_move_right;
    public static BufferedImage[] crow_move_left;
    public static BufferedImage[] crow_attack_right;
    public static BufferedImage[] crow_attack_left;

    public static BufferedImage[] purpleWizar_move_right;
    public static BufferedImage[] purpleWizar_move_left;
    public static BufferedImage[] purpleWizard_attack_right;
    public static BufferedImage[] purpleWizard_attack_left;


    public static BufferedImage tabela;

    public static BufferedImage[] heart;

    public static BufferedImage wonState;
    public static BufferedImage loseState;

    public static BufferedImage HelpState;
    public static BufferedImage settingsState;

    public static BufferedImage[] switchImage;
    public static BufferedImage[] difficulty_1;
    public static BufferedImage[] difficulty_2;
    public static BufferedImage[] difficulty_3;

    public static BufferedImage[] btn_reset;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/texture/sheet.png"));

        //player = sheet.crop(0,2*height,2*height,2*width); //coordonate pe sprite-sheetul general
        player_stop = new BufferedImage[4]; //gif alcatuit din 4 framer-uri
        player_stop[0] = sheet.crop(0, height * 2, 2 * width, 2 * height);
        player_stop[1] = sheet.crop(width * 2, height * 2, 2 * width, 2 * height);
        player_stop[2] = sheet.crop(width * 2 * 2, height * 2, 2 * width, 2 * height);
        player_stop[3] = sheet.crop(width * 3 * 2, height * 2, 2 * width, 2 * height);

        player_down = new BufferedImage[4]; //gif alcatuit din 4 framer-uri
        player_down[0] = sheet.crop(0, height * 10, 2 * width, 2 * height);
        player_down[1] = sheet.crop(width * 1 * 2, height * 10, 2 * width, 2 * height);
        player_down[2] = sheet.crop(width * 2 * 2, height * 10, 2 * width, 2 * height);
        player_down[3] = sheet.crop(width * 3 * 2, height * 10, 2 * width, 2 * height);

        player_up = new BufferedImage[4]; //gif alcatuit din 4 framer-uri
        player_up[0] = sheet.crop(0, height * 4, 2 * width, 2 * height);
        player_up[1] = sheet.crop(width * 1 * 2, height * 4, 2 * width, 2 * height);
        player_up[2] = sheet.crop(width * 2 * 2, height * 4, 2 * width, 2 * height);
        player_up[3] = sheet.crop(width * 3 * 2, height * 4, 2 * width, 2 * height);

        player_right = new BufferedImage[4]; //gif alcatuit din 4 framer-uri
        player_right[0] = sheet.crop(0, height * 6, 2 * width, 2 * height);
        player_right[1] = sheet.crop(width * 1 * 2, height * 6, 2 * width, 2 * height);
        player_right[2] = sheet.crop(width * 2 * 2, height * 6, 2 * width, 2 * height);
        player_right[3] = sheet.crop(width * 3 * 2, height * 6, 2 * width, 2 * height);

        player_left = new BufferedImage[4]; //gif alcatuit din 4 framer-uri
        player_left[0] = sheet.crop(0, height * 8, 2 * width, 2 * height);
        player_left[1] = sheet.crop(width * 1 * 2, height * 8, 2 * width, 2 * height);
        player_left[2] = sheet.crop(width * 2 * 2, height * 8, 2 * width, 2 * height);
        player_left[3] = sheet.crop(width * 3 * 2, height * 8, 2 * width, 2 * height);

        //down_gate
        down_gate_1 = sheet.crop(8 * width, 0, width, height);
        down_gate_2 = sheet.crop(9 * width, 0, width, height);
        down_gate_3 = sheet.crop(10 * width, 0, width, height);
        down_gate_4 = sheet.crop(11 * width, 0, width, height);
        down_gate_5 = sheet.crop(8 * width, height, width, height);
        down_gate_6 = sheet.crop(9 * width, height, width, height);
        down_gate_7 = sheet.crop(10 * width, height, width, height);
        down_gate_8 = sheet.crop(11 * width, height, width, height);

        //Base tiles //logica aferenta in pentru a nu iesi din mapa pentru aceste doua  tiles
        dirt = sheet.crop(0, 0, width, height);
        grass = sheet.crop(4 * width, 0, width, height);

        floor_alb_1 = sheet.crop(0, 0, width, height);
        floor_alb_2 = sheet.crop(1 * width, 0, width, height);
        floor_alb_3 = sheet.crop(2 * width, 0, width, height);
        floor_alb_4 = sheet.crop(3 * width, 0, width, height);
        floor_alb_5 = sheet.crop(0 * width, height, width, height);
        floor_alb_6 = sheet.crop(1 * width, height, width, height);
        floor_alb_7 = sheet.crop(2 * width, height, width, height);
        floor_alb_8 = sheet.crop(3 * width, height, width, height);

        floor_brown_1 = sheet.crop(4 * width, 0, width, height);
        floor_brown_2 = sheet.crop(5 * width, 0, width, height);
        floor_brown_3 = sheet.crop(6 * width, 0, width, height);
        floor_brown_4 = sheet.crop(7 * width, 0, width, height);
        floor_brown_5 = sheet.crop(4 * width, height, width, height);
        floor_brown_6 = sheet.crop(5 * width, height, width, height);
        floor_brown_7 = sheet.crop(6 * width, height, width, height);
        floor_brown_8 = sheet.crop(7 * width, height, width, height);

        floor_alb_verde_1 = sheet.crop(12 * width, 0, width, height);
        floor_alb_verde_2 = sheet.crop(13 * width, 0, width, height);
        floor_alb_verde_3 = sheet.crop(14 * width, 0, width, height);
        floor_alb_verde_4 = sheet.crop(15 * width, 0, width, height);
        floor_alb_verde_5 = sheet.crop(12 * width, height, width, height);
        floor_alb_verde_6 = sheet.crop(13 * width, height, width, height);
        floor_alb_verde_7 = sheet.crop(14 * width, height, width, height);
        floor_alb_verde_8 = sheet.crop(15 * width, height, width, height);

        floor_brown_verde_1 = sheet.crop(16*width,0,width,height);
        floor_brown_verde_2 = sheet.crop(17*width,0,width,height);
        floor_brown_verde_3 = sheet.crop(18*width,0,width,height);
        floor_brown_verde_4 = sheet.crop(19*width,0,width,height);
        floor_brown_verde_5 = sheet.crop(16*width,height,width,height);
        floor_brown_verde_6 = sheet.crop(17*width,height,width,height);
        floor_brown_verde_7 = sheet.crop(18*width,height,width,height);
        floor_brown_verde_8 = sheet.crop(19*width,height,width,height);

        floor_mov_1 = sheet.crop(0*width,12*height,height,width);
        floor_mov_2 = sheet.crop(1*width,12*height,height,width);
        floor_mov_3 = sheet.crop(2*width,12*height,height,width);
        floor_mov_4 = sheet.crop(3*width,12*height,height,width);
        floor_mov_5 = sheet.crop(4*width,12*height,height,width);
        floor_mov_6 = sheet.crop(5*width,12*height,height,width);
        floor_mov_7 = sheet.crop(6*width,12*height,height,width);
        floor_mov_8 = sheet.crop(7*width,12*height,height,width);
        floor_mov_9 = sheet.crop(8*width,12*height,height,width);

        floor_mov_10 = sheet.crop(0*width,13*height,height,width);
        floor_mov_11 = sheet.crop(1*width,13*height,height,width);
        floor_mov_12 = sheet.crop(2*width,13*height,height,width);
        floor_mov_13 = sheet.crop(3*width,13*height,height,width);
        floor_mov_14 = sheet.crop(4*width,13*height,height,width);
        floor_mov_15 = sheet.crop(5*width,13*height,height,width);
        floor_mov_16 = sheet.crop(6*width,13*height,height,width);

        //Floor_mov_verde
        floor_mov_verde_1 = sheet.crop(9*width,12*height,height,width);
        floor_mov_verde_2 = sheet.crop(10*width,12*height,height,width);
        floor_mov_verde_3 = sheet.crop(11*width,12*height,height,width);
        floor_mov_verde_4 = sheet.crop(12*width,12*height,height,width);
        floor_mov_verde_5 = sheet.crop(13*width,12*height,height,width);
        floor_mov_verde_6 = sheet.crop(14*width,12*height,height,width);
        floor_mov_verde_7 = sheet.crop(15*width,12*height,height,width);
        floor_mov_verde_8 = sheet.crop(16*width,12*height,height,width);
        floor_mov_verde_9 = sheet.crop(17*width,12*height,height,width);
        floor_mov_verde_10 = sheet.crop(9*width,13*height,height,width);
        floor_mov_verde_11 = sheet.crop(10*width,13*height,height,width);
        floor_mov_verde_12 = sheet.crop(11*width,13*height,height,width);
        floor_mov_verde_13 = sheet.crop(12*width,13*height,height,width);
        floor_mov_verde_14 = sheet.crop(13*width,13*height,height,width);
        floor_mov_verde_15 = sheet.crop(14*width,13*height,height,width);
        floor_mov_verde_16 = sheet.crop(15*width,13*height,height,width);

        //decorative
        decor_1 = sheet.crop(0*width,14*width,width,height);
        decor_2 = sheet.crop(1*width,14*width,width,height);
        decor_3 = sheet.crop(2*width,14*width,width,height);
        decor_4 = sheet.crop(3*width,14*width,width,height);
        decor_5 = sheet.crop(4*width,14*width,width,height);
        decor_6 = sheet.crop(1*width,15*width,width,height);
        decor_7 = sheet.crop(2*width,15*width,width,height);
        decor_8 = sheet.crop(3*width,15*width,width,height);
        decor_9 = sheet.crop(4*width,15*width,width,height);

        //Butoane
        btn_Start = new BufferedImage[2];
        btn_Start[0] = sheet.crop(0,256,47,19);
        btn_Start[1] = sheet.crop(0,275,47,19);

        btn_Help = new BufferedImage[2];
        btn_Help[0] = sheet.crop(0,294,47,19);
        btn_Help[1] = sheet.crop(0,313,47,19);

        btn_Exit = new BufferedImage[2];
        btn_Exit[0] = sheet.crop(0,332,47,19);
        btn_Exit[1] = sheet.crop(0,351,47,19);

        btn_Back = new BufferedImage[2];
        btn_Back[0] = sheet.crop(0,370,47,19);
        btn_Back[1] = sheet.crop(0,389,47,19);

        btn_settings = new BufferedImage[2];
        btn_settings[0] = sheet.crop(47,256,47,19);
        btn_settings[1] = sheet.crop(47,275,47,19);


        player_attack_down = new BufferedImage[3];
        player_attack_down[0] = sheet.crop(0,472,32,39);
        player_attack_down[1] = sheet.crop(33,472,29,38);
        player_attack_down[2] = sheet.crop(63,472,26,35);

        player_attack_left = new BufferedImage[3];
        player_attack_left[0] = sheet.crop(0,515, 44,33);
        player_attack_left[1] = sheet.crop(47,515, 40,34);
        player_attack_left[2] = sheet.crop(87,515, 34,32);

        player_attack_right = new BufferedImage[3];
        player_attack_right[0] = sheet.crop(0,549,33,31);
        player_attack_right[1] = sheet.crop(37,549,38,35);
        player_attack_right[2] = sheet.crop(76,549,45,35);

        player_attack_up = new BufferedImage[3];
        player_attack_up[0] = sheet.crop(0,585,32,42);
        player_attack_up[1] = sheet.crop(37,585,32,44);
        player_attack_up[2] = sheet.crop(79,585,30,40);


        bg_anim = new BufferedImage[4];
        bg_anim[0] = sheet.crop(0,800,700,700);
        bg_anim[1] = sheet.crop(708,800,700,700);
        bg_anim[2] = sheet.crop(1425,800,700,700);
        bg_anim[3] = sheet.crop(2129,800,700,700);


        eyeball_stop_right = new BufferedImage[4];
        eyeball_stop_right[0] = sheet.crop(7,631,23,29);
        eyeball_stop_right[1] = sheet.crop(39,633,23,30);
        eyeball_stop_right[2] = sheet.crop(71,635,23,27);
        eyeball_stop_right[3] = sheet.crop(102,633,23,29);

        eyeball_stop_left = new BufferedImage[4];
        eyeball_stop_left[0] = sheet.crop(126,630,20,30);
        eyeball_stop_left[1] = sheet.crop(158,630,20,30);
        eyeball_stop_left[2] = sheet.crop(190,630,20,30);
        eyeball_stop_left[3] = sheet.crop(222,630,20,30);

        eyeball_run_right = new BufferedImage[4];
        eyeball_run_right[0] = sheet.crop(0,661,30,30);
        eyeball_run_right[1] = sheet.crop(35,661,30,30);
        eyeball_run_right[2] = sheet.crop(65,661,30,30);
        eyeball_run_right[3] = sheet.crop(95,661,30,30);

        eyeball_run_left = new BufferedImage[4];
        eyeball_run_left[0] = sheet.crop(125,661,30,30);
        eyeball_run_left[1] = sheet.crop(154,661,30,30);
        eyeball_run_left[2] = sheet.crop(189,661,30,30);
        eyeball_run_left[3] = sheet.crop(222,661,30,30);

        eyeball_attack_right = new BufferedImage[4];
        eyeball_attack_right[0] = sheet.crop(0,693,26,30);
        eyeball_attack_right[1] = sheet.crop(27,693,30,30);
        eyeball_attack_right[2] = sheet.crop(70,693,26,30);
        eyeball_attack_right[3] = sheet.crop(100,693,26,30);

        eyeball_attack_left = new BufferedImage[4];
        eyeball_attack_left[0] = sheet.crop(123,694,24,28);
        eyeball_attack_left[1] = sheet.crop(146,694,24,28);
        eyeball_attack_left[2] = sheet.crop(185,694,24,28);
        eyeball_attack_left[3] = sheet.crop(223,694,24,28);

        eyeball_die = new BufferedImage[4];
        eyeball_die[0] = sheet.crop(0,759,25,25);
        eyeball_die[1] = sheet.crop(32,759,25,25);
        eyeball_die[2] = sheet.crop(62,759,30,30);
        eyeball_die[3] = sheet.crop(93,759,30,30);

        take_damage = new BufferedImage[7];
        take_damage[0] = sheet.crop(0,1500,25,26);
        take_damage[1] = sheet.crop(25,1500,25,26);
        take_damage[2] = sheet.crop(50,1500,25,26);
        take_damage[3] = sheet.crop(75,1500,25,26);
        take_damage[4] = sheet.crop(100,1500,25,26);
        take_damage[5] = sheet.crop(125,1500,25,26);
        take_damage[6] = sheet.crop(150,1500,25,26);

        crow_move_right = new BufferedImage[4];
        crow_move_right[0] = sheet.crop(0,1528,47,42);
        crow_move_right[1] = sheet.crop(47,1528,47,42);
        crow_move_right[2] = sheet.crop(94,1528,47,42);
        crow_move_right[3] = sheet.crop(141,1528,47,42);

        crow_move_left = new BufferedImage[4];
        crow_move_left[0] = sheet.crop(192,1528,47,42);
        crow_move_left[1] = sheet.crop(239,1528,47,42);
        crow_move_left[2] = sheet.crop(286,1528,47,42);
        crow_move_left[3] = sheet.crop(333,1528,47,42);

        crow_attack_right = new BufferedImage[4];
        crow_attack_right[0] = sheet.crop(0,1571,52,59);
        crow_attack_right[1] = sheet.crop(52,1571,52,59);
        crow_attack_right[2] = sheet.crop(104,1571,52,59);
        crow_attack_right[3] = sheet.crop(156,1571,52,59);

        crow_attack_left = new BufferedImage[4];
        crow_attack_left[0] = sheet.crop(212,1571,52,59);
        crow_attack_left[1] = sheet.crop(264,1571,52,59);
        crow_attack_left[2] = sheet.crop(316,1571,52,59);
        crow_attack_left[3] = sheet.crop(368,1571,52,59);

        purpleWizard_attack_right = new BufferedImage[4];
        purpleWizard_attack_right[0] = sheet.crop(0,1634,127,141);
        purpleWizard_attack_right[1] = sheet.crop(127,1634,127,141);
        purpleWizard_attack_right[2] = sheet.crop(254,1634,127,141);
        purpleWizard_attack_right[3] = sheet.crop(381,1634,127,141);

        purpleWizard_attack_left = new BufferedImage[4];
        purpleWizard_attack_left[0] = sheet.crop(512,1634,127,141);
        purpleWizard_attack_left[1] = sheet.crop(639,1634,127,141);
        purpleWizard_attack_left[2] = sheet.crop(766,1634,127,141);
        purpleWizard_attack_left[3] = sheet.crop(893,1634,127,141);

        purpleWizar_move_right = new BufferedImage[4];
        purpleWizar_move_right[0] = sheet.crop(0,1829,80,92);
        purpleWizar_move_right[1] = sheet.crop(128,1829,80,92);
        purpleWizar_move_right[2] = sheet.crop(260,1829,80,92);
        purpleWizar_move_right[3] = sheet.crop(285,1829,80,92);

        purpleWizar_move_left = new BufferedImage[4];
        purpleWizar_move_left[0] = sheet.crop(560,1829,80,92);
        purpleWizar_move_left[1] = sheet.crop(689,1829,80,92);
        purpleWizar_move_left[2] = sheet.crop(818,1829,80,92);
        purpleWizar_move_left[3] = sheet.crop(944,1829,80,92);

        tabela = sheet.crop(0,1937,347,88);

        heart = new BufferedImage[7];
        heart[0] = sheet.crop(0,2034,22,23);
        heart[1] = sheet.crop(22,2034,22,23);
        heart[2] = sheet.crop(44,2034,22,23);
        heart[3] = sheet.crop(66,2034,22,23);
        heart[4] = sheet.crop(88,2034,22,23);
        heart[5] = sheet.crop(110,2034,22,23);
        heart[6] = sheet.crop(132,2034,22,23);

        wonState = sheet.crop(0,2088,700,700);
        loseState = sheet.crop(702,2088,700,700);

        HelpState = sheet.crop(1405,2088,700,700);

        switchImage = new BufferedImage[2];
        switchImage[0] = sheet.crop(47,294,26,26);
        switchImage[1] = sheet.crop(73,294,26,26);

        difficulty_1 = new BufferedImage[2];
        difficulty_1[0] = sheet.crop(49,324,28,29);
        difficulty_1[1] = sheet.crop(113,324,28,29);

        difficulty_2 = new BufferedImage[2];
        difficulty_2[0] = sheet.crop(50,355,27,28);
        difficulty_2[1] = sheet.crop(114,355,27,28);

        difficulty_3 = new BufferedImage[2];
        difficulty_3[0] = sheet.crop(80,326,28,28);
        difficulty_3[1] = sheet.crop(144,326,28,28);

        settingsState = sheet.crop(2111,2088,700,700);

        btn_reset = new BufferedImage[2];
        btn_reset[0] = sheet.crop(95,256,47,19);
        btn_reset[1] = sheet.crop(95,275,47,19);
    }
}
