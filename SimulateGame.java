/*
 * Matt Levan
 * CSC 331, Dr. Amlan Chatterjee
 * Data Structures
 *
 * Project 3 -- Simple Card Game
 *
 * SimulateGame.java
 * Main class for running the simple card game.
 *
 * A simple card game with an option for two players.
 * The deck of cards contains 52 cards with 13 cards each in the 4 suits:
 * clubs, diamonds, hearts, spades.
 * 
 * Each player begins with 26 cards and one of the players starts the game
 * by putting their first card on the table. Players take turns by putting the
 * top card from their hand, until the current card placed on the table matches
 * the suit of the previous card on the table. If a match happens, the player
 * whose card matched gets all the cards currently on the table and adds them
 * at the end of the cards currently in his or her hand. Game continues until
 * one player gets all 52 cards, or for 10 rounds.
 *
 * Construct the game using the following guidelines:
 *
 * 1. Create a method to deal the deck of cards so that each player gets 26
 * random cards.
 *
 * 2. Start the game by choosing either of the player randomly. 
 *
 * 3. Show the cards on the table and in the hand of each player at each step
 * of the game.
 *
 * 4. Continue the game for 10 rounds or until one player has all the cards, 
 * whichever happens first.
 *
 * 5. Declare the winner (the player with all the cards, or with more cards 
 * after 10 rounds), or say its a tie (when both players have equal number
 * of cards after 10 rounds).
 *
 * Must use at least one singly linked list, one 2D array, methods to separate
 * work (main method should not have more than 20 lines of code).
 *
 * Due in full by 11/16/2015 @ 11:59 PM.
 *
 */

import java.util.*; // Import Random

public class SimulateGame {
    // Attributes

    private static Player playerOne = new Player("Bob");
    private static Player playerTwo = new Player("Alice");
    private static Player currentPlayer = playerOne;
    private static Deck deck = new Deck(true); // Shuffle deck automatically
    private static ArrayList<Card> table = new ArrayList<>();
    private static Card topCard;
    private static int roundsPlayed = 1;
    private static boolean gameOver = false;

    // Main method

    public static void main(String[] args) {
        playGame();
    }

    // Methods

    // Play the simple card game
    public static void playGame() {
        System.out.println("Starting simple card game simulation...");
        System.out.println();

        dealCards(); // Deal 26 cards to each player
        chooseFirstPlayer(); // Choose who goes first
        playRounds(); // Start the rounds
        declareWinner(); // Declare a winner
    }

    // Deal 26 cards to each hand in alternating order
    public static void dealCards() {
        for (int i = 0; i < 26; i++) {
            playerOne.takeCard(deck.deal());
            playerTwo.takeCard(deck.deal());
        }
    }

    // Choose who goes first
    public static void chooseFirstPlayer() {
        Random random = new Random();
        int n = random.nextInt(2);

        if (n == 1) { // Make playerTwo the new playerOne
            Player temp = playerOne;
            playerOne = playerTwo;
            playerTwo = temp;
        }
    }

    // Play rounds, max 10
    public static void playRounds() {
        while (roundsPlayed <= 10 && (gameOver == false)) {
            // Display the round number
            System.out.println("ROUND " + roundsPlayed);
            System.out.println();

            // Display each player's hand
            displayHands();

            // Play individual round
            playRound();

            // Increment roundsPlayed counter
            roundsPlayed++;    
        }
    }

    // Play an individual round
    public static void playRound() {
        boolean suitMatch = false; // Flag for notifying a suit match
        Card cardToPlay;

        if ((playerOne.handSize() == 52) || (playerTwo.handSize() == 52)) {
            gameOver = true;
        }

        while (suitMatch == false) {
            // Current player places card on table
            cardToPlay = currentPlayer.playCard();
            table.add(cardToPlay);

            // Check if there's a suit match
            suitMatch = checkSuitMatch();

            if (suitMatch == false)
                switchCurrentPlayer();
        }

        collectCards();
        System.out.println();

        // Sleep for a second before beginning a new round
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
        }
    }

    // Switch current player
    public static void switchCurrentPlayer() {
        if (currentPlayer == playerOne)
            currentPlayer = playerTwo;
        else if (currentPlayer == playerTwo)
            currentPlayer = playerOne;
    }

    // Check for a suit match
    public static boolean checkSuitMatch() {
        int tableSize = table.size();
        int lastSuit;
        int topSuit;

        if (tableSize < 2) {
            return false;
        }
        else {
            lastSuit = table.get(tableSize - 1).getSuit();
            topSuit = table.get(tableSize - 2).getSuit();
        }

        // Check suit equivalence
        if (lastSuit == topSuit) {
            System.out.println();
            System.out.println(currentPlayer.getName() + " wins the round!");
            System.out.println();

            return true;
        }

        return false;
    }

    // Collect cards from table
    public static void collectCards() {
        // Print a message
        System.out.print(currentPlayer.getName() + " takes the table (" +
            table.size() + "): ");
        displayTable();

        // Player takes each card from the table and adds to hand
        for (int i = 0; i < table.size(); i++) {
            Card cardToTake = table.get(i);
            currentPlayer.takeCard(cardToTake);
        }

        table.clear();
    }

    // Displays all the cards currently on the table
    public static void displayTable() {
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i) != null) {
                System.out.print(table.get(i).getName() + " ");
            }
        }

        System.out.println();
        System.out.println();
    }

    // Displays each player's current hand
    public static void displayHands() {
        playerOne.displayHand();
        playerTwo.displayHand();
    }

    // Declare a winner
    public static void declareWinner() {
        if (playerOne.handSize() > playerTwo.handSize()) {
            System.out.println(playerOne.getName().toUpperCase() + " WINS " +
                "WITH A TOTAL OF " + playerOne.handSize() + " CARDS!");
        }
        else if (playerTwo.handSize() > playerOne.handSize()) {
            System.out.println(playerTwo.getName().toUpperCase() + " WINS " +
                "WITH A TOTAL OF " + playerTwo.handSize() + " CARDS!");
        }
        else {
            System.out.println("TIE! WOW IT'S SUPER RARE!");
        }

        System.out.println();
    }
}