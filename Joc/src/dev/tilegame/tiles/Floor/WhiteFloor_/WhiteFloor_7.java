package dev.tilegame.tiles.Floor.WhiteFloor_;

import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

import java.awt.image.BufferedImage;

public class WhiteFloor_7 extends Tile {

    public WhiteFloor_7( int id) {
        super(Assets.floor_alb_7, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
