package dev.tilegame.tiles.DownGate_components;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

public class DownGate_5 extends Tile {
    public DownGate_5( int id) {
        super(Assets.down_gate_5, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
