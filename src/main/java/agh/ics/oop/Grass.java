package agh.ics.oop;

public class Grass{
    Vector2d pos;
    public Grass(Vector2d pos){
        this.pos = pos;
    }

    public Vector2d getPosition(){
        return this.pos;
    }

    public String toString(){
        return "*";
    }
}
