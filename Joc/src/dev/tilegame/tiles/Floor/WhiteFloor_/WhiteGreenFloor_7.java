package dev.tilegame.tiles.Floor.WhiteFloor_;

import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

import java.awt.image.BufferedImage;

public class WhiteGreenFloor_7 extends Tile {

    public WhiteGreenFloor_7( int id) {
        super(Assets.floor_alb_verde_7, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
