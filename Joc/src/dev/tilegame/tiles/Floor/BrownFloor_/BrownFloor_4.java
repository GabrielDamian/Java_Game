package dev.tilegame.tiles.Floor.BrownFloor_;

import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

import java.awt.image.BufferedImage;

public class BrownFloor_4 extends Tile {

    public BrownFloor_4( int id) {
        super(Assets.floor_brown_4, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }

}
