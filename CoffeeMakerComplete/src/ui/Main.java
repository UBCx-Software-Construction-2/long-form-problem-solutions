package ui;

import model.CoffeeMaker;
import model.exceptions.BeansAmountException;
import model.exceptions.WaterException;

public class Main {

        public static void main(String[] args){
            CoffeeMaker cm = new CoffeeMaker();
            try {
                cm.brew(2.4, 15.0);
                cm.pourCoffee();
                cm.pourCoffee();
                cm.setTimeSinceLastBrew(20);
                cm.pourCoffee();
                System.out.println("Coffee brewed correctly.");
                System.out.println(60 - cm.getTimeSinceLastBrew() + " minutes remaining to pour " +
                cm.getCupsRemaining() + " cups");
            } catch (Exception e) {
                System.out.println("Exception should not have been caught here");
            }

            try {
                cm.brew(2.65, 14.0);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            try {
                cm.brew(2.3, 14.9);
            } catch (WaterException e) {
                System.out.println("WaterException should not have been thrown");
            } catch (BeansAmountException e) {
                System.out.println(e.getMessage());
            }

            try {
                cm.pourCoffee();
                cm.pourCoffee();
                cm.setTimeSinceLastBrew(60);
                cm.pourCoffee();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            try {
                cm.brew(2.5, 15);
                for (int i=0; i<20; i++){
                    cm.pourCoffee();
                }
                cm.pourCoffee();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
}
