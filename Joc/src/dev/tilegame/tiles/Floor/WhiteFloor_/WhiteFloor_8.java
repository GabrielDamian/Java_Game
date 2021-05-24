package dev.tilegame.tiles.Floor.WhiteFloor_;

import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

import java.awt.image.BufferedImage;

public class WhiteFloor_8 extends Tile {

    public WhiteFloor_8( int id) {
        super(Assets.floor_alb_8, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
