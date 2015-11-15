package com.rovers;

import com.rovers.exceptions.IllegalCommandException;
import com.rovers.exceptions.IllegalDirectionException;
import com.rovers.exceptions.IllegalPositionException;

public class Rover {

    private Position position;

    /**
     * Constructor
     * @param positionStr initial position string
     * @param maxX max x
     * @param maxY max y
     */
    public Rover(String positionStr, int maxX, int maxY) {
        parsePosition(positionStr, maxX, maxY);
    }

    /**
     * Parse commands sequence 
     * @param commands commands string
     */
    public void parseCommands(String commands) {
        char[] commandsArray = commands.toCharArray();
        for (char command : commandsArray) {
            operateCommand(command);
        }
    }

    /*
     * Operate command function that takes command char
     * and does the appropriate action
     */
    private void operateCommand(char command) {
        switch (command) {
            case 'L':
                position.turnLeft();
                break;
            case 'R':
                position.trunRight();
                break;
            case 'M':
                position.move();
                break;
            default:
                throw new IllegalCommandException(command);
        }
    }

    /**
     * Parse input position on the format of "x y d"
     * where x is the x position
     * y is the y position
     * d is the direction
     * @param positionStr
     * @param maxX max x position
     * @param maxY max y position
     */
    private void parsePosition(String positionStr, int maxX, int maxY) {
        String[] tokens = positionStr.split(" ");
        int xVal = Integer.parseInt(tokens[0]);
        Point x = new Point(xVal, maxX);
        if (x.getLocation() < 0 || x.getLocation() > maxX)
            throw new IllegalPositionException(x);

        int yVal = Integer.parseInt(tokens[1]);
        Point y = new Point(yVal, maxY);
        if (y.getLocation() < 0 || y.getLocation() > maxY)
            throw new IllegalPositionException(y);

        Direction direction = Direction.getValue(tokens[2]);
        if (direction == null)
            throw new IllegalDirectionException();

        this.position = new Position(x, y, direction);
    }

    /**
     * Reposition the rover
     * @param positionStr rover position string
     * @param maxX max x
     * @param maxY max y
     */
    public void reposition(String positionStr, int maxX, int maxY) {
        parsePosition(positionStr, maxX, maxY);
    }

    /**
     * Get current position
     * @return current position
     */
    public Position getPosition() {
        return position;
    }
}
