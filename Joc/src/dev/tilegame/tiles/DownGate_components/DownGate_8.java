package dev.tilegame.tiles.DownGate_components;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

public class DownGate_8 extends Tile {
    public DownGate_8( int id) {
        super(Assets.down_gate_8, id);
    }
    @Override
    public boolean isSolid() {
        return true;
}}
