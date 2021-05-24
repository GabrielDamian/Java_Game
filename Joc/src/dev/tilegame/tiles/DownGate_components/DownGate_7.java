package dev.tilegame.tiles.DownGate_components;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

public class DownGate_7 extends Tile {
    public DownGate_7( int id) {
        super(Assets.down_gate_7, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
