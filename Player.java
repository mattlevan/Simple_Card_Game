/*
 * Matt Levan
 * CSC 331, Dr. Amlan Chatterjee
 * Data Structures
 *
 * Project 3 -- Simple Card Game
 *
 * Player.java
 * Player class.
 *
 * CITATION: 
 * Java Programming: From the Ground Up by Bravaco, Simonson
 * Page 496
 *
 * Original code modified to fit the needs of the project.
 *
 * Due in full by 11/14/2015 @ midnight
 *
 */

public class Player {
     // Attributes

     private Hand hand;
     private String name;

     // Default constructor

     public Player(String name) {
          hand = new Hand(); // Instantiate new hand object
          this.name = name;
     }

     // Methods

     public Card playCard() {
          Card c = hand.playCard();
          System.out.println(String.format("%5s", name) + " plays a " + c.getName() + "!");

          return c;
     }

     public void takeCard(Card card) {
          hand.addCard(card);
     }

     public String getName() {
          return name;
     }

     public void displayHand() {
          System.out.println(name + "\'s hand (" + hand.getSize() + "):");
          hand.display();
          System.out.println();
     }

     public int handSize() {
          return hand.getSize();
     }
}