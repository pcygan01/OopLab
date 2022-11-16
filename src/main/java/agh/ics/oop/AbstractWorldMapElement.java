package agh.ics.oop;

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
