package model;

import model.exceptions.*;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {

    private int timeSinceLastBrew;
    private int cupsRemaining;

    //EFFECTS: sets time since last brew, cups remaining to 0
    public CoffeeMaker(){
        timeSinceLastBrew = 0;
        cupsRemaining = 0;
    }


    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0,
    //         throws BeansAmountException if beans are not between 2.4 and 2.6 cups,
    //         throws WaterException if water <= 14.75
    public void brew(double beans, double water) throws BeansAmountException, WaterException{
        if (water <= 14.75)
            throw new WaterException(water);

        if (beans >= 2.4) {
            if (beans <= 2.6) {
                cupsRemaining = 20;
                timeSinceLastBrew = 0;
            } else {
                throw new TooManyBeansException(beans);
            }
        } else {
            throw new NotEnoughBeansException(beans);
        }
    }


    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    //         throws NoCupsRemainingException if cups remaining <= 0
    //         throws StaleCoffeeException if time since last brew >= 60
    public void pourCoffee() throws StaleCoffeeException, NoCupsRemainingException {
        if(!areCupsRemaining()){
            throw new NoCupsRemainingException();
        } else if (timeSinceLastBrew >= 60){
            throw new StaleCoffeeException(timeSinceLastBrew);
        } else {
            cupsRemaining--;
        }
    }

    //getters
    public int getTimeSinceLastBrew(){
        return timeSinceLastBrew; //stub
    }

    //EFFECTS: returns how many cups remaining in pot (a full pot is 20 cups)
    public int getCupsRemaining(){
        return cupsRemaining;
    }

    //EFFECTS: returns true if there are cups remaining
    public boolean areCupsRemaining(){
        return cupsRemaining > 0;
    }

    //REQUIRES: a non-negative integer
    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time){
        this.timeSinceLastBrew = time;
    }

}
