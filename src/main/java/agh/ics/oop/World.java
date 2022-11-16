package agh.ics.oop;

import agh.ics.oop.gui.Gui;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");


        MoveDirection[] directions = new OptionsParser().parse(args);
        //IWorldMap map = new RectangularMap(10, 5);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        System.out.println("Stop");

//f b r l f f r r f f f f f f f f

    }

}
