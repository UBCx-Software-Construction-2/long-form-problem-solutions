package model;

import model.observer_pattern.Observer;
import model.observer_pattern.Subject;
import model.random.BingoCall;

import java.util.ArrayList;
import java.util.List;

public class Game implements Subject {

    public static int CARD_SIZE = 25;
    public static int SIDE_LENGTH = (int) Math.sqrt(CARD_SIZE);

    private BingoCall currentCall;
    private List<Observer> cards;
    private boolean gameOver;

    public Game() {
        cards = new ArrayList<>();
        callNext();
    }

    //getters
    public BingoCall getCurrentCall(){
        return currentCall;
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public List<PlayerCard> getCards() {
        List<PlayerCard> playerCards = new ArrayList<>();
        for (Observer o : cards) {
            if (o.getClass().getSimpleName().equals("PlayerCard"))
                playerCards.add((PlayerCard) o);
        }
        return playerCards;
    }

    //EFFECTS: generates the next bingo call and notifies observers
    public void callNext() {
        currentCall = new BingoCall();
        notifyObservers();
        checkGameOver();
    }

    //MODIFIES: this
    //EFFECTS: adds observer to list of observers
    @Override
    public void addObserver(Observer o) {
        cards.add(o);
    }

    //EFFECTS: notifies observers of state change
    @Override
    public void notifyObservers(){
        for (Observer o : cards){
            o.update(currentCall);
        }
    }

    //EFFECTS: sets game over to true if one of the players has bingo
    private void checkGameOver(){
        for (Observer o : cards) {
            PlayerCard p = (PlayerCard) o;
            if (p.hasBingo()) {
                gameOver = true;
                break;
            }
        }
    }
}
