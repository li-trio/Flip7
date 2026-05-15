package source;

import java.util.Random;
import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);

    Random random = new Random();

    Player player = new Player();

    public void start() {

        System.out.println("What is your name?");

        player.name = scanner.nextLine();

        System.out.println("Welcome " + player.name);

        boolean playing = true;

        while (playing) {

            System.out.println("Do you want to draw a card? (yes/no)");

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("yes")) {

                int card = random.nextInt(13);

                System.out.println(player.name + " drew: " + card);

                if (player.hand.contains(card)) {

                    System.out.println(" GAME OVER😢!💥You 💣 lost!💥 You have a card doubled: " + player.hand);

                    player.lost = true;

                    playing = false;

                } else {

                    player.hand.add(card);

                    System.out.println("Hand: " + player.hand);
                }

            } else {

                playing = false;
            }
        }

        calculatePoints();
    }

    public void calculatePoints() {

        for (int card : player.hand) {
            player.points += card;
        }

        System.out.println("Final points: " + player.points);
    }
}