package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationEngineTest {

    @Test
    void SimulationEngineTest1(){
        String[] args1 = {"f", "b", "r", "b", "r", "b"};
        MoveDirection[] directions1 = new OptionsParser().parse(args1);
        RectangularMap map1 = new RectangularMap(15, 6);
        Vector2d[] positions1 = { new Vector2d(4,1), new Vector2d(3,4) };
        IEngine engine1 = new SimulationEngine(directions1, map1, positions1);
        engine1.run();
        assertEquals(((SimulationEngine) engine1).getAnimals().get(0).getDirection(), MapDirection.SOUTH);
        assertEquals(((SimulationEngine) engine1).getAnimals().get(0).getPosition(), new Vector2d(4,2));
        assertEquals(((SimulationEngine) engine1).getAnimals().get(1).getDirection(), MapDirection.NORTH);
        assertEquals(((SimulationEngine) engine1).getAnimals().get(1).getPosition(), new Vector2d(3,1));

    }

    @Test
    void SimulationEngineTest2(){
        String[] args2 = {"f", "l", "f", "l", "r", "f", "b", "b", "b"};
        MoveDirection[] directions2 = new OptionsParser().parse(args2);
        RectangularMap map2 = new RectangularMap(3, 3);
        Vector2d[] positions2 = { new Vector2d(1,2), new Vector2d(0,7), new Vector2d(-1,0) }; //2 invalid positions
        IEngine engine2 = new SimulationEngine(directions2, map2, positions2);
        engine2.run();
        assertEquals(((SimulationEngine) engine2).getAnimals().get(0).getDirection(), MapDirection.WEST);
        assertEquals(((SimulationEngine) engine2).getAnimals().get(0).getPosition(), new Vector2d(2,2));

    }
}