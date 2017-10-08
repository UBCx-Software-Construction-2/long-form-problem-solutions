package model.exceptions;


public class WaterException extends Exception {

    private double water;

    public WaterException(double water){
        super(water + " is not enough water");
    }

    //getter
    public double getWater() {
        return water;
    }

}
