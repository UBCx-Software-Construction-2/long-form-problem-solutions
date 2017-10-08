package model.exceptions;


public class NotEnoughBeansException extends BeansAmountException {

    public NotEnoughBeansException(double beans) {
        super(beans, " is not enough beans");
    }
}
