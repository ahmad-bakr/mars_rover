package com.rovers.exceptions;

/**
 * Illegal Command Exception
 * @author ahmad.bakr
 *
 */
public class IllegalCommandException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    
    char command;
    
    public IllegalCommandException(char command) {
        this.command = command;
    }

}
