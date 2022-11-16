package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {


    GrassField map = new GrassField(10);
    Animal a1 = new Animal(map, new Vector2d(4,7));
    //map.place(a1);
    Animal a2 = new Animal(map, new Vector2d(8,2));
    //map.place(a2);

    @BeforeEach
    void setUp(){
        //RectangularMap map = new RectangularMap(10, 10);
        //Animal a1 = new Animal(map, new Vector2d(4,7));
        map.place(a1);
        //Animal a2 = new Animal(map, new Vector2d(8,2));
        map.place(a2);
    }

    @Test
    void canMoveToTest(){
        assertTrue(map.canMoveTo(new Vector2d(3,7)));
        assertTrue(map.canMoveTo(new Vector2d(0,0)));
        assertTrue(map.canMoveTo(new Vector2d(10,10)));
        assertFalse(map.canMoveTo(new Vector2d(4,7)));
        assertFalse(map.canMoveTo(new Vector2d(8,2)));
        assertTrue(map.canMoveTo(new Vector2d(-4,4)));
    }

    @Test
    void placeTest(){
        assertTrue(map.place(new Animal(map, new Vector2d(5,8))));
        assertFalse(map.place(new Animal(map, new Vector2d(5,8))));
        assertFalse(map.place(new Animal(map, new Vector2d(8,2))));
        assertTrue(map.place(new Animal(map, new Vector2d(-2,9))));
    }

    @Test
    void isOccupiedTest(){
        assertTrue(map.isOccupied(new Vector2d(8,2)));
        assertTrue(map.isOccupied(new Vector2d(4,7)));
        assertFalse(map.isOccupied(new Vector2d(5,8)));
        assertFalse(map.isOccupied(new Vector2d(6,15)));
    }

    @Test
    void objectAtTest(){
        assertEquals(a1, map.objectAt(new Vector2d(4,7)));
        assertEquals(a2, map.objectAt(new Vector2d(8,2)));
        assertTrue((map.objectAt(new Vector2d(1, 1)) == null || map.objectAt(new Vector2d(1, 1)) instanceof Grass));

    }
}