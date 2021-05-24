package dev.tilegame.entities;

import dev.tilegame.Handler;
import dev.tilegame.entities.creatures.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class EntityManager {
    //retine toate entitatile si le updateaza
    private Handler handler;
    private Player player;

    private ArrayList<Entity> entities;
    private Comparator<Entity> renderSorter = new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if(a.getY() +a.getHeight() < b.getY() + b.getHeight()) //a.getY este varful de sus al player-ului, iar +a.getHeight() reprezinta ianltimea lui
                return -1; //a ar trebui sa fie randat inaintea lui b
            return 1;
        }
    };

    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<>();
        addEntity(player);
    }

    public void tick(){
        for(int i=0;i<entities.size();i++)
        {
            Entity e = entities.get(i);
            e.tick();
            if(!e.isActive())
            {
                entities.remove(e);
            }
        }
        entities.sort(renderSorter); //sorteaza elementele in functie de renderSorter care spune ordinea de randare pe ecran

    }

    public void delete_all_creatures()
    {
        for(int i=0;i<entities.size();i++)
        {
            Entity e = entities.get(i);
            if(e.can_be_removed())
            {
                entities.remove(e);
            }
        }
        entities.sort(renderSorter); //sorteaza elementele in functie de renderSorter care spune ordinea de randare pe ecran
    }

    public void render(Graphics g){
        for(Entity e: entities) //pentru e in entitites
        {
            e.render(g);
        }
    }
    public void addEntity(Entity e){
        entities.add(e);
    }

    public Handler getHandler() {
        return handler;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Entity> getEnitites() {
        return entities;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setEnitites(ArrayList<Entity> enitites) {
        this.entities = enitites;
    }
}
