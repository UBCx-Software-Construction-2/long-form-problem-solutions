package model;

public class Host extends FOHEmployee {

    private static final String PREFIX = "HOST - ";
    private static final String SHORT_PREFIX = "H:";

    public Host(Dish dish) {
        super(dish);
    }

    public String getPrefix() { return PREFIX; }

    public String getShortPrefix() { return SHORT_PREFIX; }

}
