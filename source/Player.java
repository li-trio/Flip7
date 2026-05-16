package source;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private final ArrayList<Integer> hand = new ArrayList<>();

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
    public List<Integer> getHand() {
        return hand;
    }
    public boolean isLost() {
        return lost;
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
    public int calculatePoints() {

        int total = 0;

        for (int card : hand) {

            total += card;
        }

        return total;
    }
    public int calculatePointsBeforeLastCard() {

        int total = 0;

        for (int i = 0; i < hand.size() - 1; i++) {

            total += hand.get(i);
        }

        return total;
    }
}
