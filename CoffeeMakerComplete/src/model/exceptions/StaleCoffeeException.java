package model.exceptions;

public class StaleCoffeeException extends Exception {

    private int time;

    public StaleCoffeeException(int time){
        super(time + " is too long! Coffee is stale!");
        this.time = time;
    }

    //getter
    public int getTime(){
        return time;
    }
}
