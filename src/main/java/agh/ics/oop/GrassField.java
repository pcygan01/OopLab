package agh.ics.oop;
import java.util.Random;
import java.util.ArrayList;

import static java.lang.Math.sqrt;

public class GrassField implements IWorldMap{
    private int n;
    private ArrayList<Animal> animals;
    private ArrayList<Grass> grasses;

    public GrassField(int n){
        this.n = n;
        Random random = new Random();
        for(int i = 0; i < n; i++){
            Vector2d pos = new Vector2d(random.nextInt((int)sqrt(n*10)), random.nextInt((int)sqrt(n*10)));

        }
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        return !isOccupied(position);
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
        return false;
    }




}
