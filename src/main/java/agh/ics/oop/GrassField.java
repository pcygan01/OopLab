package agh.ics.oop;
import java.util.Random;
import java.util.ArrayList;

import static java.lang.Math.*;

public class GrassField implements IWorldMap{
    private final int n;
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private ArrayList<Grass> grasses = new ArrayList<Grass>();

    public GrassField(int n){
        this.n = n;
        Random random = new Random();
        for(int i = 0; i < n; i++){
            Vector2d pos = new Vector2d(random.nextInt((int)sqrt(this.n*10)), random.nextInt((int)sqrt(this.n*10)));
            if (objectAt(pos) == null){
                this.grasses.add(new Grass(pos));
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position){

        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal){
        if (canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        for(Animal a: animals){
            if (a.isAt(position)){
                return true;
            }
        }
        for(Grass a: grasses){
            if (a.getPosition().equals(position)){
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
        for(Grass a: grasses){
            if (a.getPosition().equals(position)){
                return a;
            }
        }
        return null;
    }

    public Vector2d getLowerLeft(){
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        for(Animal a: animals){
            x = min(a.getPosition().x, x);
            y = min(a.getPosition().y, y);
        }
        for(Grass a: grasses){
            x = min(a.getPosition().x, x);
            y = min(a.getPosition().y, y);
        }
        return new Vector2d(x, y);
    }

    public Vector2d getUpperRight(){
        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        for(Animal a: animals){
            x = max(a.getPosition().x, x);
            y = max(a.getPosition().y, y);
        }
        for(Grass a: grasses){
            x = max(a.getPosition().x, x);
            y = max(a.getPosition().y, y);
        }
        return new Vector2d(x, y);
    }
    public String toString(){
        return new MapVisualizer(this).draw(getLowerLeft(), getUpperRight());
    }





}
