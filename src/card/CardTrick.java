///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */

//
///**
// * A class that fills a magic hand of 7 cards with random Card Objects
// * and then asks the user to pick a card and searches the array of cards
// * for the match to the user's card. To be used as starting code in ICE 1
// * @author Kshitij Ale 991722551
// */

package card;
import java.util.Random;
import java.util.Scanner;

public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];

        // Add one luck card: hard code 2 of clubs
        Card luckCard = new Card();
        luckCard.setValue(2);
        luckCard.setSuit("Clubs");
        magicHand[0] = luckCard; // Overwrite the first card with the luck card

        // Fill magicHand with random Card objects (excluding the first card)
        for (int i = 1; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(generateRandomValue());
            c.setSuit(Card.SUITS[generateRandomSuitIndex()]);
            magicHand[i] = c;
        }

        Card luckyCard = new Card();
        luckyCard.setValue(7);
        luckyCard.setSuit("Hearts");
        magicHand[6] = luckyCard;

        // Display the magic hand
        System.out.println("Magic Hand:");
        for (Card card : magicHand) {
            System.out.println(card.getSuit() + " " + card.getValue());
        }

        // Ask the user for Card value and suit
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter your card value (1-13): ");
        int userValue = scanner.nextInt();
        System.out.println("Enter your card suit (0-Hearts, 1-Diamonds, 2-Clubs, 3-Spades): ");
        int userSuitIndex = scanner.nextInt();

        // Validate user input for suit
        if (userSuitIndex >= 0 && userSuitIndex <= 3) {
            String userSuit = Card.SUITS[userSuitIndex];

            // Create the user's card
            Card userCard = new Card();
            userCard.setValue(userValue);
            userCard.setSuit(userSuit);

            // Search magicHand for a match
            boolean foundMatch = false;
            for (Card card : magicHand) {
                if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                    foundMatch = true;
                    break;
                }
            }

            // Report the result
            if (foundMatch) {
                System.out.println("Congratulations! You found a match in the magic hand.");
            } else {
                System.out.println("Sorry! No match found in the magic hand.");
            }
        } else {
            System.out.println("Invalid suit index. Please enter a valid suit index (0-3).");
        }
    }

    // Helper method to generate a random card value (1-13)
    private static int generateRandomValue() {
        Random random = new Random();
        return random.nextInt(13) + 1;
    }

    // Helper method to generate a random suit index (0-3)
    private static int generateRandomSuitIndex() {
        Random random = new Random();
        return random.nextInt(4);
    }
    
}
