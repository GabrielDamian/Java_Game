package dev.tilegame.tiles.Floor.FloorMov_;

import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

public class FloorMovVerde_8 extends Tile {

    public FloorMovVerde_8( int id) {
        super(Assets.floor_mov_verde_8, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
