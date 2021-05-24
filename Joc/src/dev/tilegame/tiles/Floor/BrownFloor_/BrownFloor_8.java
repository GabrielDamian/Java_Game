package dev.tilegame.tiles.Floor.BrownFloor_;

import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

import java.awt.image.BufferedImage;

public class BrownFloor_8 extends Tile {

    public BrownFloor_8( int id) {
        super(Assets.floor_brown_8, id);
    }
    public boolean isSolid() {
        return true;
    }
}
