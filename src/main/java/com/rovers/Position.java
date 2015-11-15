package com.rovers;

/**
 * Position class
 * @author ahmad.bakr
 *
 */
public class Position {

    private Point x;
    private Point y;
    private Direction direction;

    /**
     * Construction
     * @param x position x
     * @param y position y
     * @param direction direction
     */
    public Position(Point x, Point y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    /**
     * A method that controls the movement of the rover
     * Base on the the current direction;
     */
    public void move() {
        switch (direction) {
            case NORTH:
                    y.moveForward();
                break;
            case SOUTH:
                    y.moveBackward();
                break;
            case EAST:
                    x.moveForward();
                break;
            case WEST:
                    x.moveBackward();
                break;
        }
    }

    /**
     * Turn left
     * Changes the direction in an anti clockwise manner
     */
    public void turnLeft() {
        changeDirection(-1);
    }
    
    /**
     * Turn right
     * Changes the direction a clockwise manner
     */
    public void trunRight(){
        changeDirection(+1);
    }

    /**
     * Change direction methods makes use of labeling the direction by numbers
     * (N:0 E:1 S:2 W:3) and change the direction by direction shift 
     * @param positionShift
     */
    private void changeDirection(int positionShift){
        int directionsCount = Direction.values().length;
        int newPosition = (directionsCount + direction.getNumericPoisition() + positionShift) % directionsCount;
        this.direction = Direction.values()[newPosition];
    }
    
    
    /**
     * Get point x
     * @return point x
     */
    public Point getX() {
        return x;
    }

    /**
     * Set point x
     * @param point point x
     */
    public void setX(Point x) {
        this.x = x;
    }

    /**
     * Get point Y
     * @return point Y
     */
    public Point getY() {
        return y;
    }

    /**
     * Set point Y
     * @param y point Y
     */
    public void setY(Point y) {
        this.y = y;
    }

    /**
     * Get direction
     * @return direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Set direction
     * @param head direction
     */
    public void setDirection(Direction head) {
        this.direction = head;
    }
    
    @Override
    public String toString() {
        return x.getLocation() + " " + y.getLocation() + " " + direction.getDirection();
    }

}
