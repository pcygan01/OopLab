package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    public void directionTest(){
        IWorldMap map = new GrassField(10);
        Animal dog = new Animal(map, new Vector2d(2,2));
        assertEquals(MapDirection.NORTH, dog.getDirection());
        for (int i = 0; i < 15; i++){
            dog.move(MoveDirection.LEFT);
        }
        assertEquals(MapDirection.EAST, dog.getDirection());
        dog.move(MoveDirection.RIGHT);
        dog.move(MoveDirection.RIGHT);
        dog.move(MoveDirection.LEFT);
        assertEquals(MapDirection.SOUTH, dog.getDirection());
    }


    @Test
    public void positionTest(){
        IWorldMap map = new GrassField(10);
        Animal dog = new Animal(map, new Vector2d(2,2));
        assertEquals(new Vector2d(2,2), dog.getPosition());
        dog.move(MoveDirection.FORWARD);
        dog.move(MoveDirection.FORWARD);
        dog.move(MoveDirection.RIGHT);
        dog.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(3, 4), dog.getPosition());
        dog.move(MoveDirection.LEFT);
        System.out.println(dog.toString());

        dog.move(MoveDirection.BACKWARD);
        dog.move(MoveDirection.BACKWARD);
        dog.move(MoveDirection.BACKWARD);
        System.out.println(dog.toString());

        dog.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(3,0), dog.getPosition());

    }

    @Test
    public void borderTest(){
        IWorldMap map = new RectangularMap(5,5);
        Animal cat = new Animal(map, new Vector2d(2,2));
        for (int i = 0; i < 10; i++){
            cat.move(MoveDirection.FORWARD);
        }
        assertEquals(new Vector2d(2,4), cat.getPosition()); //top border
        cat.move(MoveDirection.LEFT);
        for (int i = 0; i < 10; i++){
            cat.move(MoveDirection.FORWARD);
        }
        assertEquals(new Vector2d(0,4), cat.getPosition()); //left border
        cat.move(MoveDirection.LEFT);
        for (int i = 0; i < 10; i++){
            cat.move(MoveDirection.FORWARD);
        }
        assertEquals(new Vector2d(0,0), cat.getPosition()); //bottom border
        cat.move(MoveDirection.LEFT);
        for (int i = 0; i < 10; i++){
            cat.move(MoveDirection.FORWARD);
        }
        assertEquals(new Vector2d(4,0), cat.getPosition()); //right border

    }

    @Test
    public void parserTest(){
        OptionsParser parser = new OptionsParser();
        String[] args1 = {"f", "backward", "right", "r", "back", "nothing", "b", "left"};
        MoveDirection[] output1 = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT,
                MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT};
        try{
            assertArrayEquals(output1, parser.parse(args1));
            Assertions.fail("there should be an exception");
        }
        catch(IllegalArgumentException ex){
            Assertions.assertTrue(true, "an exception was caught");
        }

        String[] args2 = {"1", "2", "3", "4", "4", "b"};
        MoveDirection[] output2 = {MoveDirection.BACKWARD};
        try{
            assertArrayEquals(output2, parser.parse(args2));
            Assertions.fail("there should be an exception");
        }
        catch(IllegalArgumentException ex){
            Assertions.assertTrue(true, "an exception was caught");
        }

        String[] args3 = {"f", "r", "b", "l", "forward", "right", "backward", "left"};
        MoveDirection[] output3 = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD,
                MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD,
                MoveDirection.LEFT};
        assertArrayEquals(output3, parser.parse(args3));

    }
}
