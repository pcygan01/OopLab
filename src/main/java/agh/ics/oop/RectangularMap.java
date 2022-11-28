package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap{


    private final Vector2d lowerLeft;
    private final Vector2d upperRight;

    public RectangularMap(int width, int height){
        super();
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width-1, height-1);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        if (position.follows(this.lowerLeft) && position.precedes(this.upperRight) && super.canMoveTo(position)){
            return true;
        }
        return false;
    }
    public Vector2d getLowerLeft(){
        return this.lowerLeft;
    }

    public Vector2d getUpperRight(){
        return this.upperRight;
    }

}
