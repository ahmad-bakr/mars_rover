package com.rovers;

import com.rovers.exceptions.IllegalPositionException;

/**
 * Point Class specifies one coordinates of the rover
 * @author ahmad.bakr
 *
 */
public class Point {

    private int location;
    private int maxLocation;

    public Point(int location, int maxLocation) {
        this.location = location;
        this.maxLocation = maxLocation;
    }

    /**
     * Move forward
     */
    public void moveForward() {
        if (location + 1 > maxLocation)
            throw new IllegalPositionException(this);
        this.location += 1;
    }

    /**
     * move backward
     */
    public void moveBackward() {
        if (location - 1 < 0)
            throw new IllegalPositionException(this);
        this.location -= 1;
    }

    /**
     * Get current location
     * @return current location
     */
    public int getLocation() {
        return location;
    }

    /**
     * Set current location
     * @param location current location
     */
    public void setLocation(int location) {
        this.location = location;
    }

    /**
     * Get max possible location
     * @return max location
     */
    public int getMaxLocation() {
        return maxLocation;
    }

    /**
     * Set max possible location
     * @param maxLocation max location
     */
    public void setMaxLocation(int maxLocation) {
        this.maxLocation = maxLocation;
    }

}
