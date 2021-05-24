package dev.tilegame.tiles.Floor.FloorMov_;

import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

public class FloorMovVerde_6 extends Tile {

    public FloorMovVerde_6( int id) {
        super(Assets.floor_mov_verde_6, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }

}
