package com.rovers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rovers.exceptions.IllegalPositionException;

/**
 * Position test class
 * @author ahmad.bakr
 *
 */
public class PositionTest {

    private Position position;
    private Point pointX;
    private Point pointY;
    private Direction direction;
    
    @Before
    public void init(){
        pointX = new Point(2, 4);
        pointY = new Point(2, 3);
        direction = Direction.NORTH;
        position = new Position(pointX, pointY, direction);
        
    }
    
    // ---- Position setters
    
    @Test
    public void positionInstanceShouldGetXPPoint(){
        assertEquals(pointX.getLocation(), position.getX().getLocation());
        assertEquals(pointX.getMaxLocation(), position.getX().getMaxLocation());
    }
    
    @Test
    public void positionInstanceShouldGetYPoint(){
        assertEquals(pointY.getLocation(), position.getY().getLocation());
        assertEquals(pointY.getMaxLocation(), position.getY().getMaxLocation());
    }
    
    @Test
    public void positionInstanceShouldGetDirection(){
        assertEquals(Direction.NORTH.getDirection(), position.getDirection().getDirection());
        assertEquals(Direction.NORTH.getNumericPoisition(), position.getDirection().getNumericPoisition());
    }
    
    // --- Movement tests: Tests when direction is set NORTH
    
    @Test
    public void givenDirectionNorthDirectionShouldBeWestWhenTurnLeft(){
        position.setDirection(Direction.NORTH);
        position.turnLeft();
        assertEquals(Direction.WEST, position.getDirection());
    }
   
    @Test
    public void givenDirectionNorthDirectionShouldBeEastWhenTurnRight(){
        position.setDirection(Direction.NORTH);
        position.trunRight();
        assertEquals(Direction.EAST, position.getDirection());
    }
    
    @Test
    public void givenDirectionNorthPointYShouldIncreaseByOneWhenMoveAndDirectionIsNorth(){
        position.setDirection(Direction.NORTH);
        int oldx = position.getX().getLocation();
        int oldy = position.getY().getLocation();
        position.move();
        assertEquals(oldx, position.getX().getLocation());
        assertEquals(oldy + 1, position.getY().getLocation());
    }
    
    // --- Movement tests: Tests when direction is set EAST
    
    @Test
    public void givenDirectionEastDirectionShouldBeNorthWhenTurnLeft(){
        position.setDirection(Direction.EAST);
        position.turnLeft();
        assertEquals(Direction.NORTH, position.getDirection());
    }
    
    @Test
    public void givenDirectionEastDirectionShouldBeSouthWhenTurnRight(){
        position.setDirection(Direction.EAST);
        position.trunRight();
        assertEquals(Direction.SOUTH, position.getDirection());
    }
    
    @Test
    public void givenDirectionEastPointXShouldIncreaseByOneWhenMove(){
        position.setDirection(Direction.EAST);
        int oldx = position.getX().getLocation();
        int oldy = position.getY().getLocation();
        position.move();
        assertEquals(oldx + 1, position.getX().getLocation());
        assertEquals(oldy, position.getY().getLocation());
    }

    // --- Movement tests: Tests when direction is set SOUTH
    
    @Test
    public void givenDirectionSouthDirectionShouldBeEastWhenTurnLeft(){
        position.setDirection(Direction.SOUTH);
        position.turnLeft();
        assertEquals(Direction.EAST, position.getDirection());
    }

    @Test
    public void givenDirectionSouthDirectionShouldBeWestWhenTurnRight(){
        position.setDirection(Direction.SOUTH);
        position.trunRight();
        assertEquals(Direction.WEST, position.getDirection());
    }

    @Test
    public void givenDirectionSouthPointYShouldDecreaseByOneWhenMove(){
        position.setDirection(Direction.SOUTH);
        int oldx = position.getX().getLocation();
        int oldy = position.getY().getLocation();
        position.move();
        assertEquals(oldx, position.getX().getLocation());
        assertEquals(oldy - 1, position.getY().getLocation());
    }
    
    // --- Movement tests: Tests when direction is set WEST

    @Test
    public void givenDirectionWestDirectionShouldBeSouthWhenTurnLeft(){
        position.setDirection(Direction.WEST);
        position.turnLeft();
        assertEquals(Direction.SOUTH, position.getDirection());
    }

    @Test
    public void givenDirectionWestDirectionShouldBeNorthWhenTurnRight(){
        position.setDirection(Direction.WEST);
        position.trunRight();
        assertEquals(Direction.NORTH, position.getDirection());
    }

    @Test
    public void givenDirectionWestPointXShouldDecreaseByOneWhenMove(){
        position.setDirection(Direction.WEST);
        int oldx = position.getX().getLocation();
        int oldy = position.getY().getLocation();
        position.move();
        assertEquals(oldx - 1, position.getX().getLocation());
        assertEquals(oldy , position.getY().getLocation());
    }
    
    // --- Illegal tests: Tests when movement is not allowed
    
    @Test(expected =  IllegalPositionException.class)
    public void shouldThrowIllegalPositionExceptionWhenPointXLessThanZero(){
        position.setDirection(Direction.WEST);
        int currentX = pointX.getLocation();
        try {
            for(int i = currentX; i > 0; i--){
                position.move();
            }
        } catch (Exception e) {
            assertTrue(false);
        }
        position.move();
    }

    @Test(expected =  IllegalPositionException.class)
    public void shouldThrowIllegalPositionExceptionWhenPointXLargerThanMaxXLocation(){
        position.setDirection(Direction.EAST);
        int currentX = pointX.getLocation();
        int maxLocation = pointX.getMaxLocation();
        try {
            for(int i = currentX; i < maxLocation; i++){
                position.move();
            }
        } catch (Exception e) {
            assertTrue(false);
        }
        position.move();
    }

    @Test(expected =  IllegalPositionException.class)
    public void shouldThrowIllegalPositionExceptionWhenPointYLessThanZero(){
        position.setDirection(Direction.SOUTH);
        int currentY = pointY.getLocation();
        try {
            for(int i = currentY; i > 0; i--){
                position.move();
            }
        } catch (Exception e) {
            assertTrue(false);
        }
        position.move();
    }

    @Test(expected =  IllegalPositionException.class)
    public void shouldThrowIllegalPositionExceptionWhenPointYLargerThanMaxYLocation(){
        position.setDirection(Direction.NORTH);
        int currentY = pointY.getLocation();
        int maxLocation = pointY.getMaxLocation();
        try {
            for(int i = currentY; i < maxLocation; i++){
                position.move();
            }
        } catch (Exception e) {
            assertTrue(false);
        }
        position.move();
    }


}
