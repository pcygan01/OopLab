package agh.ics.oop;

import agh.ics.oop.gui.Gui;

import java.awt.*;
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
//        Gui gui = new Gui(this.map., 5, this.animals);
//        gui.run();
        for (Vector2d position: positions){
            Animal animal = new Animal(this.map, position);
            if(this.map.place(animal)){
                this.animals.add(animal);
            }
        }
        for(int i = 0; i < moves.length; i++){
            this.animals.get(i % animals.size()).move(moves[i]);
            //gui.run();
            System.out.println(map);
            //gui.drawAnimals(this.animals);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //System.out.println(i % animals.size() + " " + animals.get(i % animals.size()));
        }
        //gui.run();
    }

    //metoda stworzona aby ulatwic robienie testow, nie jestem pewny czy to dobre wyjscie
    public ArrayList<Animal> getAnimals(){
        return animals;
    }
}
