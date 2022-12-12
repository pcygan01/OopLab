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
    private MapBoundary mapBoundaries;


    public GrassField(int n){
        this.n = n;
        this.mapBoundaries = new MapBoundary();
        this.grasses = new HashMap<>();
        for(int i = 0; i < n; i++){
            while (true)
                if (spawnGrass())
                    break;
        }
    }

    @Override
    public boolean place(Animal animal){
        if (super.place(animal)){
            mapBoundaries.addElement(animal.getPosition());
            return true;
        }
        return false; //nie musimy jeszcze raz tego samego wyjatku pisac
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
            mapBoundaries.removeElement(position);
            //usuwam pozycje trawy zeby zaraz dodac pozycje zwierze
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

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        super.positionChanged(oldPosition, newPosition);
        mapBoundaries.positionChanged(oldPosition, newPosition);
    }

    public Vector2d getLowerLeft(){
        return mapBoundaries.getLowerLeft();
    }

    public Vector2d getUpperRight(){
        return mapBoundaries.getUpperRight();
    }

    public boolean spawnGrass(){
        Random random = new Random();
        Vector2d pos = new Vector2d(random.nextInt((int)sqrt(this.n*10)), random.nextInt((int)sqrt(this.n*10)));
        if (objectAt(pos) == null){
            this.grasses.put(pos, new Grass(pos));
            mapBoundaries.addElement(pos);
            return true;
        }
        return false;
    }
//    public String toString(){
//        return super.toString();
//    }





}
