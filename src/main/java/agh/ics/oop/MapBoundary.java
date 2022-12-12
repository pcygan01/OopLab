package agh.ics.oop;

import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    TreeSet<Vector2d> sortedX = new TreeSet<Vector2d>(new MyComparator(true));
    TreeSet<Vector2d> sortedY = new TreeSet<Vector2d>(new MyComparator(false));

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        removeElement(oldPosition);
        addElement(newPosition);
    }

    public void addElement(Vector2d element) {
        sortedX.add(element);
        sortedY.add(element);
    }

    public void removeElement(Vector2d element) {
        sortedX.remove(element);
        sortedY.remove(element);
    }

    public Vector2d getLowerLeft(){
        return new Vector2d(sortedX.first().x, sortedY.first().y);
    }
    public Vector2d getUpperRight(){
        return new Vector2d(sortedX.last().x, sortedY.last().y);
    }
}
