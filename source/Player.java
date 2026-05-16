package source;

import java.util.ArrayList;

public class Player {

    String name;

    ArrayList<Integer> hand = new ArrayList<>();

    int points = 0;

    boolean lost = false;

    public Player(String name) {
        this.name = name;
    }
    public Player() {
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
}