package model.exceptions;

public class BeansAmountException extends Exception {

    private double beans;

    public BeansAmountException(double beans){
        super(beans + " is not the right amount of beans");
        this.beans = beans;
    }

    protected BeansAmountException(double beans, String message){
        super(beans + message);
        this.beans = beans;
    }

    //getter
    public double getBeans(){
        return beans;
    }

}
