package test;

import model.CoffeeMaker;
import model.exceptions.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CoffeeMakerTest {
    private CoffeeMaker testCM;

    @Before
    public void setUp(){
        testCM = new CoffeeMaker();
    }

    @Test
    public void testConstructor(){
        assertEquals(testCM.getTimeSinceLastBrew(), testCM.getCupsRemaining(), 0);
    }

    @Test
    public void testBrewShouldPass(){
        try {
            successfulBrew();
            assertEquals(testCM.getTimeSinceLastBrew(), 0);
            testCM.brew(2.40, 14.8);
            testCM.brew(2.6, 14.9);
        } catch (Exception e) {
            fail();
        }
    }

    @Test (expected = NotEnoughBeansException.class)
    public void testBrewFailNotEnoughBeans() throws BeansAmountException, WaterException {
        testCM.brew(2.39, 15);
    }

    @Test (expected = TooManyBeansException.class)
    public void testBrewFailTooManyBeans() throws BeansAmountException, WaterException {
        testCM.brew(2.61, 14.9);
    }

    @Test (expected = WaterException.class)
    public void testBrewFailNotEnoughWater() throws BeansAmountException, WaterException {
        testCM.brew(2.5, 14.75);
    }

    @Test (expected = WaterException.class)
    public void testBrewFailBothWrongWaterFirst() throws BeansAmountException, WaterException {
        testCM.brew(2.1, 14);
    }

    @Test
    public void testPourCoffeePass() throws BeansAmountException, WaterException {
        successfulBrew();
        try {
            testCM.pourCoffee();
            testCM.pourCoffee();
            testCM.pourCoffee();
            testCM.pourCoffee();
            testCM.pourCoffee();
            testCM.setTimeSinceLastBrew(59);
            assertEquals(testCM.getCupsRemaining(), 15);
            testCM.pourCoffee();
        } catch (Exception e) {
            fail();
        }
    }

    @Test (expected = StaleCoffeeException.class)
    public void testPourCoffeeFailStaleCoffee() throws StaleCoffeeException, NoCupsRemainingException,
            BeansAmountException, WaterException {
        successfulBrew();
        testCM.setTimeSinceLastBrew(60);
        testCM.pourCoffee();
    }

    @Test (expected = NoCupsRemainingException.class)
    public void testPourCoffeeFailNoCupsRemaining() throws BeansAmountException, WaterException,
            StaleCoffeeException, NoCupsRemainingException {
        successfulBrew();
        pour20Cups();
        testCM.pourCoffee(); //exception should be thrown on 21st pour
    }

    @Test (expected = NoCupsRemainingException.class)
    public void testPourCoffeeBothWrongNoCupsFirst() throws StaleCoffeeException, NoCupsRemainingException,
            BeansAmountException, WaterException {
        successfulBrew();
        pour20Cups();
        testCM.setTimeSinceLastBrew(60);
        testCM.pourCoffee();
    }

    private void successfulBrew() throws BeansAmountException, WaterException {
        testCM.brew(2.5, 15);
    }

    private void pour20Cups() throws StaleCoffeeException, NoCupsRemainingException {
        for(int i=0; i<20; i++){
            testCM.pourCoffee();
        }
    }
}
