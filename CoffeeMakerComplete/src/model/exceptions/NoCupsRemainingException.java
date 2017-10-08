package model.exceptions;


public class NoCupsRemainingException extends Exception {
    public NoCupsRemainingException(){
        super("Cannot pour coffee when no cups remaining.");
    }
}
