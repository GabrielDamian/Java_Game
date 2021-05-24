package dev.tilegame.tiles.Floor.FloorMov_;

import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

import java.awt.image.BufferedImage;

public class FloorMov_3 extends Tile {

    public FloorMov_3( int id) {
        super(Assets.floor_mov_3, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
