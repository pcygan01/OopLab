package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");


        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        //System.out.println(((SimulationEngine) engine).getAnimals().get(0));
        //System.out.println(((SimulationEngine) engine).getAnimals().get(1));
        System.out.println("Stop");
    }

}
