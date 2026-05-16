package source;

import java.util.ArrayList;

import java.util.Random;

import java.util.Scanner;

public class Name {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");

        String name = scanner.nextLine();

        System.out.println("Hello " + name + ", do you want to play Flip 7? (yes/no)");

        String antwort = scanner.nextLine();

        if (antwort.equalsIgnoreCase("yes")) {

            System.out.println("Great, let's play Flip 7 🎰 " + name + "!");

            int points = 0;

            ArrayList<Integer> hand = new ArrayList<>();

            Random random = new Random();

            boolean playing = true;

while (playing) {

    System.out.println("Do you want a new card? (yes/no)");

    String choice = scanner.nextLine();

    if (choice.equalsIgnoreCase("yes")) {

        int card = random.nextInt(13);

        System.out.println(name + " drew card: " + card);

        if (hand.contains(card)) {

        System.out.println(" GAME OVER😢!💥You 💣 lost!💥 You have a card doubled: " + hand);

            playing = false;

        } else {

            hand.add(card);

            System.out.println("Your hand: " + hand);

        }

    } else if (choice.equalsIgnoreCase("no")) {

        playing = false;

    } else {

        System.out.println("Please type yes or no!");

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
}