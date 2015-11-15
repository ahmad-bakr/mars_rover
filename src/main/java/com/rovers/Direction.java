package com.rovers;

/**
 * Enum specifies the possible direction
 * labeling the four directions with integers 0, 1, 3 and 3 allows easy direction
 * changes by mapping them to arithmetic operations  
 * @author ahmad.bakr
 *
 */
public enum Direction {

    NORTH("N", 0),
    EAST("E", 1),
    SOUTH("S", 2),
    WEST("W", 3);

    private String direction;
    private int numericPoisition;

    private Direction(String direction, int position) {
        this.direction = direction;
        this.numericPoisition = position;
    }

    public String getDirection() {
        return direction;
    }

    public int getNumericPoisition() {
        return numericPoisition;
    }

    /**
     * Get direction by value
     * @param val value
     * @return direction
     */
    public static Direction getValue(String val) {
        for (Direction e : Direction.values()) {
            if (e.direction.equals(val)) {
                return e;
            }
        }
        return null;// not found
    }

}
