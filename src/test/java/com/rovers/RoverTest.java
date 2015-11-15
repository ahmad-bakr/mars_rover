package com.rovers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rovers.exceptions.IllegalCommandException;
import com.rovers.exceptions.IllegalDirectionException;
import com.rovers.exceptions.IllegalPositionException;

/**
 * Rover Test
 * @author ahmad.bakr
 *
 */
public class RoverTest {

    private Rover rover;
    private static int X = 1;
    private static int Y = 2;
    private static int MAX_X = 5;
    private static int MAX_Y = 4;
    private static String DIR = "N";
    
    
    @Before
    public void init(){
        String input = X + " " + Y + " " + DIR;
        rover = new Rover(input, MAX_X, MAX_Y);
    }
    
    // --- Input validity tests

    @Test
    public void roverInstanceShouldParseInput(){
        assertEquals(rover.getPosition().getX().getLocation(), X);
        assertEquals(rover.getPosition().getX().getMaxLocation(), MAX_X);

        assertEquals(rover.getPosition().getY().getLocation(), Y);
        assertEquals(rover.getPosition().getY().getMaxLocation(), MAX_Y);

        assertEquals(Direction.getValue(DIR), rover.getPosition().getDirection());
    }
    
    // --- Rover test for commands
    
    @Test
    public void roverShouldParseCommands1(){
        rover.reposition("1 2 N", 5, 5);
        rover.parseCommands("LMLMLMLMM");
        assertEquals("1 3 N", rover.getPosition().toString());
    }
    
    @Test
    public void roverShouldParseCommands2(){
        rover.reposition("3 3 E", 5, 5);
        rover.parseCommands("MMRMMRMRRM");
        assertEquals("5 1 E", rover.getPosition().toString());
    }
    
    // --- Illegal input tests
    
    @Test (expected = IllegalPositionException.class)
    public void roverShouldThrowIllegalPositionExceptionWhenInputXLessThanZero(){
        rover.reposition("-1 3 E", 5, 5);
    }

    @Test (expected = IllegalPositionException.class)
    public void roverShouldThrowIllegalPositionExceptionWhenInputYLessThanZero(){
        rover.reposition("2 -1 E", 5, 5);
    }

    @Test (expected = IllegalPositionException.class)
    public void roverShouldThrowIllegalPositionExceptionWhenInputXLargerThanMaxX(){
        rover.reposition("7 2 E", 5, 5);
    }

    @Test (expected = IllegalPositionException.class)
    public void roverShouldThrowIllegalPositionExceptionWhenInputYLargerThanMaxY(){
        rover.reposition("2 7 E", 5, 5);
    }
    
    @Test(expected = IllegalDirectionException.class)
    public void roverShouldThrowIllegalDirectionExceptionWhenInputInvalidDirection(){
        rover.reposition("2 3 A", 5, 5);
    }

    // --- Illegal command test
    
    @Test (expected = IllegalCommandException.class)
    public void roverShouldThrowExceptionWhenParseIllegalInput(){
        rover.parseCommands("RLBA");
    }
    
    

}
