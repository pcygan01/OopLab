package agh.ics.oop;


import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement{
    private MapDirection direction;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers;

    public Animal(IWorldMap map, Vector2d initialPosition){
        super(initialPosition);
        this.direction = MapDirection.NORTH;
        this.map = map;
        this.observers = new ArrayList<>();
    }

    //konstruktor bezparametrowy nie ma teraz sensu, ponieważ każde zwierzę musi mieć pokazaną mapę na którą sie może poruszać,
    //dodatkowo możemy "zagnieżdżać konstruktory", dzięki czemu konstruktor z 3 argumentami może korzystać z konstruktora z 2 itd.
    //nie zrobiłem tak w tym rozwiązaniu, ponieważ nie byłem o to proszony


    public String toString(){
        return (this.direction.toString());
    }

    public MapDirection getDirection() {
        return direction;
    }



    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    public void positionChanged(Vector2d newPosition){
        for(IPositionChangeObserver observer: observers){
            observer.positionChanged(this.position, newPosition);
        }
    }

    public void move(MoveDirection direction){
        Vector2d newPos = new Vector2d(0,0);
        boolean moved = false;
        switch(direction){
            case FORWARD -> {
                newPos = this.position.add(this.direction.toUnitVector());
                moved = true;
            }
            case BACKWARD -> {
                newPos = this.position.add(this.direction.toUnitVector().opposite());
                moved = true;
            }
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
        }
        if (moved){
            if (this.map.canMoveTo(newPos)){
                positionChanged(newPos);
                this.position = newPos;
            }
        }
    }

}