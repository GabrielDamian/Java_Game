package dev.tilegame.tiles.DownGate_components;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

public class DownGate_1 extends Tile {
    public DownGate_1( int id) {
        super(Assets.down_gate_1, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
