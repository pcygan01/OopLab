package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private MoveDirection[] moves;
    private IWorldMap map;
    private Vector2d[] positions;
    private ArrayList<Animal> animals;


    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions){
        this.moves = moves;
        this.map = map;
        this.positions = positions;
        this.animals = new ArrayList<>();

    }

    public void run(){
        for (Vector2d position: positions){
            Animal animal = new Animal(this.map, position);
            if(this.map.place(animal)){
                this.animals.add(animal);
            }
        }
        for(int i = 0; i < moves.length; i++){
            this.animals.get(i % animals.size()).move(moves[i]);
            //System.out.println(i % animals.size() + " " + animals.get(i % animals.size()));
        }
    }

    //metoda stworzona aby ulatwic robienie testow, nie jestem pewny czy to dobre wyjscie
    public ArrayList<Animal> getAnimals(){
        return animals;
    }
}
