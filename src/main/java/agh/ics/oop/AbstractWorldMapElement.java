package agh.ics.oop;

import java.util.List;

public abstract class AbstractWorldMapElement implements IMapElement{

    protected Vector2d position;
    public AbstractWorldMapElement(Vector2d position){
        this.position = position;
    }

    public Vector2d getPosition() {
        return position;
    }

    public abstract String toString();
}
