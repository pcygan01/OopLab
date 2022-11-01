package agh.ics.oop;


public class Animal {
    private MapDirection direction;
    private Vector2d position;


    public Animal(){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public String toString(){
        return ("position: " + this.position.toString() + ", direction: " + this.direction.toString());
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
            if (newPos.follows(new Vector2d(0,0)) && newPos.precedes(new Vector2d(4,4))){
                this.position = newPos;
            }
        }
    }

}