package agh.ics.oop;

import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap{

    protected ArrayList<Animal> animals;


    public AbstractWorldMap(){
        this.animals = new ArrayList<Animal>();
    }

    public boolean canMoveTo(Vector2d position){
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal){
        if (canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        for(Animal a: animals){
            if (a.isAt(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position){
        for(Animal a: animals){
            if (a.isAt(position)){
                return a;
            }
        }
        return null;
    }

    public abstract Vector2d getLowerLeft();
    public abstract Vector2d getUpperRight();


    public String toString(){
        return new MapVisualizer(this).draw(getLowerLeft(), getUpperRight());
    }
}
