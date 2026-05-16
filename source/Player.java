package source;

import java.util.ArrayList;

public class Player {

    private String name;

    private ArrayList<Integer> hand = new ArrayList<>();

    private int points = 0;

    private boolean lost = false;

    public Player(String name) {
        this.name = name;
    }
    public Player() {
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public boolean hasCard(int card) {
        return hand.contains(card);
    }
    public ArrayList<Integer> handWithCard(int card) {
        ArrayList<Integer> tempHand = new ArrayList<>(hand);

        tempHand.add(card);

        return tempHand;
    }
    public void lose() {
        lost = true;
    }
    public void addCard(int card) {

        hand.add(card);
    }
    public void calculatePoints() {

        points = 0;

        for (int card : hand) {

            points += card;
        }
    }
    public void showHand() {

        System.out.println("Hand: " + hand);
    }
    public void showFinalScore() {

        calculatePoints();

        System.out.println("Final hand: " + hand);

        System.out.println("Final points: " + points);
    }
}