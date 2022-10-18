package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    Vector2d mock = new Vector2d(2, 2);
    Vector2d mockother = new Vector2d(1,3);


    @Test
    public void equalsTest(){
        assertTrue(mock.equals(new Vector2d(2,2)));
        assertFalse(mock.equals(new Vector2d(5,4)));
    }

    @Test
    public void toStringTest(){
        assertEquals("(2,2)", mock.toString());
    }

    @Test
    public void precedesTest(){

        assertFalse(mock.precedes(new Vector2d(-2,8)));
        assertFalse(new Vector2d(5,3).precedes(mock));
        assertTrue(mock.precedes(new Vector2d(5,2)));
        assertTrue(new Vector2d(2, 1).precedes(mock));
    }

    @Test
    public void followsTest(){
        assertFalse(mock.follows(new Vector2d(5,2)));
        assertTrue(new Vector2d(2,2).follows(mock));
        assertTrue(mock.follows(new Vector2d(1,2)));
        assertFalse(new Vector2d(1, 6).follows(mock));
    }

    @Test
    public void upperRightTest(){
        assertEquals(new Vector2d(2,3), mock.upperRight(mockother));
    }
    @Test
    public void lowerLeftTest(){
        assertEquals(new Vector2d(1,2), mock.lowerLeft((mockother)));
    }
    @Test
    public void addTest(){
        assertEquals(new Vector2d(3,5), mock.add(mockother));
    }
    @Test
    public void subtractTest(){
        assertEquals(new Vector2d(1,-1),mock.subtract(mockother));
    }
    @Test
    public void oppositeTest(){
        assertEquals(new Vector2d(-2,-2),mock.opposite());
    }
}