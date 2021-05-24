package dev.tilegame.tiles.DownGate_components;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

public class DownGate_3 extends Tile {
    public DownGate_3( int id) {
        super(Assets.down_gate_3, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
