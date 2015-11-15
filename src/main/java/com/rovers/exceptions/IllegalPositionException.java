package com.rovers.exceptions;

import com.rovers.Point;

/**
 * Illegal position exception
 * @author ahmad.bakr
 *
 */
public class IllegalPositionException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    Point point;
    
    public IllegalPositionException(Point point) {
        this.point = point;
    }

}
