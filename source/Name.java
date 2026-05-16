package source;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Name {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");

        String name = scanner.nextLine();

        if (askYesOrNo(scanner, "Hello " + name + ", do you want to play Flip 7? (yes/no)")) {

            System.out.println("Great, let's play Flip 7 🎰 " + name + "!");

            int points = 0;

            ArrayList<Integer> hand = new ArrayList<>();

            Random random = new Random();

            boolean playing = true;

            while (playing) {

                if (askYesOrNo(scanner, "Do you want a new card? (yes/no)")) {

                    int card = random.nextInt(13);

                    System.out.println(name + " drew card: " + card);

                    if (hand.contains(card)) {

                        System.out.println(" GAME OVER😢!💥You 💣 lost!💥 You have a card doubled: " + hand);

                        playing = false;

                    } else {

                        hand.add(card);

                        System.out.println("Your hand: " + hand);

                    }

                } else {

                    playing = false;

                }

            }

            for (int i = 0; i < hand.size(); i++) {

                points += hand.get(i);

            }

            System.out.println("Final hand: " + hand);

            System.out.println("Final points: " + points);

        } else {

            System.out.println("👺Maybe 🐒 later!👹");

        }

    }

    private static boolean askYesOrNo(Scanner scanner, String question) {

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
