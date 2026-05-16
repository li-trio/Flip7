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

        System.out.println("Hello " + player.name + ", do you want to play Flip 7? (yes/no)");

        String antwort = scanner.nextLine();

        if (antwort.equalsIgnoreCase("yes")) {

            System.out.println("Great, let's play Flip 7 🎰 " + player.name + "!");

            boolean playing = true;

            while (playing) {

                System.out.println("Do you want to draw a card? (yes/no)");

                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("yes")) {

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

                } else if (choice.equalsIgnoreCase("no")) {

                    playing = false;

                } else {

                    System.out.println("Please type yes or no!");

                }

            }

            calculatePoints();

        } else {

            System.out.println("👺Maybe 🐒 later!👹");

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