package dev.tilegame.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {
    //incarca imagini in program

    public static BufferedImage loadImage(String path) //path este locatia imaginii
    {
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1); //daca nu ai reusit sa incarci imaginea, iesi din joc, incheie programul
        }
        return null;
    }
}
