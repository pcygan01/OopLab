package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    protected Map<Vector2d, Animal> animals;


    public AbstractWorldMap(){
        this.animals = new HashMap<>();
    }

    public boolean canMoveTo(Vector2d position){
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal){
        Vector2d pos = animal.getPosition();
        if (canMoveTo(pos)){
            animals.put(pos, animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        if(animals.containsKey(position)){
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position){
        for(Vector2d pos: animals.keySet()){
            if (pos.equals(position)){
                return animals.get(pos);
            }
        }
        return null;
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal a = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, a);
    }
    public abstract Vector2d getLowerLeft();
    public abstract Vector2d getUpperRight();


    public String toString(){
        return new MapVisualizer(this).draw(getLowerLeft(), getUpperRight());
    }
}
