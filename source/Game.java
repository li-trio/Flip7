package source;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);

    Deck deck = new Deck();

    Player player = new Player();

    public void start() {

        System.out.println("What is your name?");

        player.name = scanner.nextLine();

        if (askYesOrNo("Hello " + player.name + ", do you want to play Flip 7? (yes/no)")) {

            System.out.println("Great, let's play Flip 7 🎰 " + player.name + "!");

            boolean playing = true;

            while (playing) {

                if (askYesOrNo("Do you want to draw a card? (yes/no)")) {

                    int card = deck.drawCard();

                    System.out.println(player.name + " drew: " + card);

if (player.hand.contains(card)) {

    ArrayList<Integer> tempHand = new ArrayList<>(player.hand);

    tempHand.add(card);

    System.out.println(
        "GAME OVER😢!💥You 💣 lost!💥 You have a card doubled: " + tempHand
    );

    player.hand.add(card);

    player.lost = true;

    playing = false;

}else {

                        player.hand.add(card);

                        System.out.println("Hand: " + player.hand);

                    }

                } else {

                    playing = false;

                }

            }

            calculatePoints();

        } else {

            System.out.println("👺Maybe 🐒 later!👹");

        }

    }

    private boolean askYesOrNo(String question) {

        while (true) {

            System.out.println(question);

            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {

                return true;

            }

            if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {

                return false;

            }

            System.out.println("Please type yes, y, no, or n!");

        }

    }

    public void calculatePoints() {

        for (int card : player.hand) {

            player.points += card;

        }

        System.out.println("Final hand: " + player.hand);

        System.out.println("Final points: " + player.points);

    }

}