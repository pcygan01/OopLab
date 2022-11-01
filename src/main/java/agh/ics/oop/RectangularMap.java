package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap{

    private final int width;
    private final int height;
    private ArrayList<Animal> animals;

    private final Vector2d lowerLeft;
    private final Vector2d upperRight;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.animals = new ArrayList<>();
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width-1, height-1);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        if (position.follows(this.lowerLeft) && position.precedes(this.upperRight) && !isOccupied(position)){
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal){
        if(canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
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

    public String toString(){
        return new MapVisualizer(this).draw(this.lowerLeft, this.upperRight);
    }
}
