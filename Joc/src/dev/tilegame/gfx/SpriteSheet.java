package dev.tilegame.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet { //clasa care preia sheet-ul intreg si il sectioneaza in imagini potrivite

    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet)
    {
        this.sheet = sheet;
    }

    public BufferedImage crop(int x, int y, int width, int height)
    {
        return sheet.getSubimage(x,y,width,height); //intoarce imaginea(sheetul mare) taiat - doar o bucata specifica
    }

}
