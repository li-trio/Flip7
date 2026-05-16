package source;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private final Scanner scanner = new Scanner(System.in);

    private final Deck deck = new Deck();

    private final Player player = new Player();

    public void start() {

        System.out.println("What is your name?");

        player.setName(scanner.nextLine());

        if (askYesOrNo("Hello " + player.getName() + ", do you want to play Flip 7? (yes/no)")) {

            System.out.println("Great, let's play Flip 7 🎰 " + player.getName() + "!");

            boolean playing = true;

            while (playing) {

                if (askYesOrNo("Do you want to draw a card? (yes/no)")) {

                    int card = deck.drawCard();

                    System.out.println(player.getName() + " drew: " + card);

                    if (player.hasCard(card)) {

                        ArrayList<Integer> tempHand = player.handWithCard(card);

                        System.out.println(
                            "GAME OVER😢!💥You 💣 lost!💥 You have a card doubled: " + tempHand
                        );

                        player.addCard(card);

                        player.lose();

                        playing = false;

                    } else {

                        player.addCard(card);

                        player.showHand();

                    }

                } else {

                    playing = false;

                }

            }

            player.showFinalScore();

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

}