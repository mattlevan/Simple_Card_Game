/*
 * Matt Levan
 * CSC 331, Dr. Amlan Chatterjee
 * Data Structures
 *
 * Project 3 -- Simple Card Game
 *
 * Deck.java
 * A deck of cards.
 *
 * CITATION: 
 * Java Programming: From the Ground Up by Bravaco, Simonson
 * Page 478
 *
 * Original code modified to fit the needs of the project.
 *
 * Due in full by 11/16/2015 @ 11:59 PM.
 *
 */

import java.util.*; // For Random

public class Deck {
     // Attributes

     private Card deck[]; // An array of Card objects
     private int next; // Holds position of next card to be dealt

     // Default constructor

     public Deck(boolean startShuffled) {
          deck = new Card[53]; // Indices 1-52 (does not use index 0)

          // Fill the deck with cards
          for (int rank = 1; rank <= 13; rank++) {
               // Place cards in order in deck, shuffle later
               deck[rank] = new Card(1, rank); // First suit, ex: 3 of clubs
               deck[rank+13] = new Card(2, rank); // Second suit, diamonds
               deck[rank+26] = new Card(3, rank); // Third suit, hearts
               deck[rank+39] = new Card(4, rank); // Fourth suit, spades
          }

          next = 1; // Set next to 1 since first card is in index 1

          if (startShuffled == true) {
               shuffle();
          }
     }

     // Methods

     public void shuffle() {
          Random randomNumber = new Random();

          for (int card = 1; card <= 52; card++) {
               // Find a random place in the deck
               int rand = randomNumber.nextInt(52) + 1;

               // Swap cards in deck
               Card temp = deck[card]; // Card from random position
               deck[card] = deck[rand];
               deck[rand] = temp;
          }

          next = 1; // Reset next
     }

     public Card deal() { // Deals one card at a time
          if (next > 53) // If deck is depleted
               shuffle();

          Card c = deck[next];
          next++;

          return c;
     }
}