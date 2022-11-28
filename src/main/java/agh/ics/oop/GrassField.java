package agh.ics.oop;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ArrayList;

import static java.lang.Math.*;

//odpowiedz na pytanie 10
//teoretycznie w metodach isOccupied() i objectAt() zamiast iterowac po kolei
//najpierw na zwierzetach a pozniej na trawach moglibysmy stworzyc nowa kolekcje
//typu IMapElement zwierzat i traw razem. mialem sie zastanowic, wiec wydaje mi sie
//ze to moze byc dobry pomysl, ale nie zaimplementuje tego jeszcze teraz.



public class GrassField extends AbstractWorldMap{
    private final int n;
    private Map<Vector2d, Grass> grasses;

    public GrassField(int n){
        this.n = n;
        this.grasses = new HashMap<>();
        for(int i = 0; i < n; i++){
            while (true)
                if (spawnGrass())
                    break;
        }
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!super.canMoveTo(position)){
            return false;
        }
        if (objectAt(position) instanceof Grass){
            while (true)
                if (spawnGrass())
                    break;
            grasses.remove(position);
        }
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        if (super.isOccupied(position)){
            return true;
        }
        for(Vector2d pos: grasses.keySet()){
            if (pos.equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position){
        if (super.objectAt(position) instanceof Animal){
            return super.objectAt(position);
        }
        for(Vector2d pos: grasses.keySet()){
            if (pos.equals(position)){
                return grasses.get(pos);
            }
        }
        return null;
    }

    public Vector2d getLowerLeft(){
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        for(Vector2d pos: animals.keySet()){
            x = min(pos.x, x);
            y = min(pos.y, y);
        }
        for(Vector2d pos: grasses.keySet()){
            x = min(pos.x, x);
            y = min(pos.y, y);
        }
        return new Vector2d(x, y);
    }

    public Vector2d getUpperRight(){
        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        for(Vector2d pos: animals.keySet()){
            x = max(pos.x, x);
            y = max(pos.y, y);
        }
        for(Vector2d pos: grasses.keySet()){
            x = max(pos.x, x);
            y = max(pos.y, y);
        }
        return new Vector2d(x, y);
    }

    public boolean spawnGrass(){
        Random random = new Random();
        Vector2d pos = new Vector2d(random.nextInt((int)sqrt(this.n*10)), random.nextInt((int)sqrt(this.n*10)));
        if (objectAt(pos) == null){
            this.grasses.put(pos, new Grass(pos));
            return true;
        }
        return false;
    }
//    public String toString(){
//        return super.toString();
//    }





}
