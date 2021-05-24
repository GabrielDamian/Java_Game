package dev.tilegame.tiles.Floor.FloorMov_;

import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

public class FloorMovVerde_2 extends Tile {

    public FloorMovVerde_2( int id) {
        super(Assets.floor_mov_verde_2, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
