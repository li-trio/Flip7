package source;

import java.util.Scanner;

public class Game {

    private final Scanner scanner = new Scanner(System.in);

    private final Deck deck = new Deck();

    private final Player player = new Player();

    public void start() {

        System.out.println("What is your name?");

        player.setName(scanner.nextLine());

        if (askYesOrNo("Hello " + player.getName() + ", do you want to play Flip 7? (yes/no)")) {

            System.out.println();
            System.out.println("Great, let's play Flip 7 🎰 " + player.getName() + "!");

            boolean playing = true;

            while (playing) {

                if (askYesOrNo("Do you want to draw a card? (yes/no)")) {

                    int card = deck.drawCard();

                    System.out.println();
                    System.out.println(player.getName() + " drew: " + card);

                    if (player.hasCard(card)) {

                        java.util.List<Integer> tempHand = player.handWithCard(card);

                        System.out.println("GAME OVER😢!💥You 💣 lost!💥 You have a card doubled:");
                        System.out.println(CardRenderer.renderHandWithDuplicate(tempHand));

                        player.addCard(card);

                        player.lose();

                        playing = false;

                    } else {

                        player.addCard(card);

                        showHand();

                    }

                } else {

                    playing = false;

                }

            }

            showFinalScore();

        } else {

            System.out.println();
            System.out.println("👺Maybe 🐒 later!👹");

        }

    }

    private void showHand() {

        System.out.println();
        System.out.println("Hand:");
        System.out.println(CardRenderer.renderHand(player.getHand()));

    }

    private void showFinalScore() {

        System.out.println();
        System.out.println("Final hand:");

        if (player.isLost()) {
            System.out.println(CardRenderer.renderHandWithDuplicate(player.getHand()));
            System.out.println();
            System.out.println("Final points: null");
            System.out.println("You could have reached " + player.getPointsBeforeLastCard() + " points before the duplicated card, but you exploded.");
            return;
        }

        System.out.println(CardRenderer.renderHand(player.getHand()));
        System.out.println();
        System.out.println("Final points: " + player.getPoints());

    }

    private boolean askYesOrNo(String question) {

        while (true) {

            System.out.println();
            System.out.println(question);

            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {

                return true;

            }

            if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {

                return false;

            }

            System.out.println();
            System.out.println("Please type yes, y, no, or n!");

        }

    }

}