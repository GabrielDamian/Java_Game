package dev.tilegame.tiles.DownGate_components;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

public class DownGate_6 extends Tile {
    public DownGate_6( int id) {
        super(Assets.down_gate_6, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }

}
