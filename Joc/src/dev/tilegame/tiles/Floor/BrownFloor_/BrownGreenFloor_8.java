package dev.tilegame.tiles.Floor.BrownFloor_;

import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

import java.awt.image.BufferedImage;

public class BrownGreenFloor_8 extends Tile {

    public BrownGreenFloor_8( int id) {
        super(Assets.floor_brown_verde_8, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
