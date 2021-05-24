package dev.tilegame.tiles.Floor.FloorMov_;

import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

public class FloorMovVerde_7 extends Tile {

    public FloorMovVerde_7( int id) {
        super(Assets.floor_mov_verde_7, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }

}
