package dev.tilegame.tiles.Floor.FloorMov_;

import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

import java.awt.image.BufferedImage;

public class FloorMov_16 extends Tile {

    public FloorMov_16( int id) {
        super(Assets.floor_mov_16, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
