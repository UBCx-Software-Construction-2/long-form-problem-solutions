package model;

public abstract class Choice {

    private String optionMessage;

    public Choice(String optionMessage) {
        this.optionMessage = optionMessage;
    }

    //EFFECTS: prints the message to describe this choice
    public void printOption() {
        System.out.println(optionMessage);
    }

    //EFFECTS: prints the result of choosing this choice
    public abstract void printOutcome();

}
