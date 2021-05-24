package dev.tilegame.tiles.Floor.FloorMov_;

import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

public class FloorMovVerde_15 extends Tile {

    public FloorMovVerde_15( int id) {
        super(Assets.floor_mov_verde_15, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
