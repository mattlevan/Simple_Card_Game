/*
 * Matt Levan
 * CSC 331, Dr. Amlan Chatterjee
 * Data Structures
 *
 * Project 3 -- Simple Card Game
 *
 * Card.java
 * A card class.
 *
 * CITATION: 
 * Java Programming: From the Ground Up by Bravaco, Simonson
 * Page 476
 *
 * Original code modified to fit the needs of the project.
 *
 * Due in full by 11/16/2015 @ 11:59 PM.
 *
 */

public class Card {
     // Attributes

     private int suit; // 1 Clubs, 2 Diamonds, 3 Hearts, 4 Spades
     private int value; // 1 Ace... 11 J, 12 Q, 13 K

     // Constructors

     public Card() { // Default constructor, default card is Ace of Spades
          this.suit = 1;
          this.value = 1;
     }

     public Card(int suit, int value) { // Construct a speciifc card
          this.suit = suit;
          this.value = value;
     }

     // Methods

     public int getSuit() {
          return this.suit;
     }

     public int getValue() {
          return this.value;
     }

     public void setSuit(int suit) {
          this.suit = suit;
     }

     public void setValue(int value) {
          this.value = value;
     }

     public String getName() {
          String name = "";

          // Convert int value to name of face value as String

          if (this.value == 1)
               name = "A";
          else if (value == 11) 
               name = "J";
          else if (value == 12)
               name = "Q";
          else if (value == 13)
               name = "K";
          else // For cards 2 through 10
               name = Integer.toString(value);

          // Convert int suit to name of suit as String

          if (suit == 1)
               name += (char)'\u2663';
          else if (suit == 2)
               name += (char)'\u2666';
          else if (suit == 3)
               name += (char)'\u2764';
          else if (suit == 4)
               name += (char)'\u2660';

          // Return name as a String

          return name;
     }

     public String toString() {
          return getName();
     }
}