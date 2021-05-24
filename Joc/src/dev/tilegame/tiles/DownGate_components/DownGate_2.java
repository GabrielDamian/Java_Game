package dev.tilegame.tiles.DownGate_components;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

public class DownGate_2 extends Tile {
    public DownGate_2( int id) {
        super(Assets.down_gate_2, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
