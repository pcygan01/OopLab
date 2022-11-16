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



    public abstract Vector2d getLowerLeft();
    public abstract Vector2d getUpperRight();


    public String toString(){
        return new MapVisualizer(this).draw(getLowerLeft(), getUpperRight());
    }
}
