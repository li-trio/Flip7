package source;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    ArrayList<Integer> cards = new ArrayList<>();

    Random random = new Random();

    public Deck() {

        for (int number = 0; number <= 12; number++) {

            int amount;

            if (number == 0 || number == 1) {
                amount = 1;
            } else {
                amount = number;
            }

            for (int i = 0; i < amount; i++) {

                cards.add(number);
            }
        }
    }

    public int drawCard() {

        int index = random.nextInt(cards.size());

        int card = cards.remove(index);

        return card;
    }
}