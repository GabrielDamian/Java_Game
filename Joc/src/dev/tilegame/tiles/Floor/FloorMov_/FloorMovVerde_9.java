package dev.tilegame.tiles.Floor.FloorMov_;

import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

public class FloorMovVerde_9 extends Tile {

    public FloorMovVerde_9( int id) {
        super(Assets.floor_mov_verde_9, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
