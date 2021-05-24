package dev.tilegame.tiles.DownGate_components;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

public class DownGate_4 extends Tile {
    public DownGate_4( int id) {
        super(Assets.down_gate_4, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
