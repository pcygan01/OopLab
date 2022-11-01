package agh.ics.oop;


public class Animal {
    private MapDirection direction;
    private Vector2d position;
    private IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.direction = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
    }
    public Animal(IWorldMap map){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
        this.map = map;
    }
    public Animal(){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public String toString(){
        return (this.position.toString() + " " + this.direction.toString());
    }

    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getPosition() {
        return position;
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
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
            if (map.canMoveTo(newPos)){
                this.position = newPos;
            }
        }
    }

}