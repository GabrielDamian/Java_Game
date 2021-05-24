package dev.tilegame.tiles.Floor.BrownFloor_;

import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

import java.awt.image.BufferedImage;

public class BrownGreenFloor_7 extends Tile {

    public BrownGreenFloor_7( int id) {
        super(Assets.floor_brown_verde_7, id);
    }
    public boolean isSolid() {
        return true;
    }
}
