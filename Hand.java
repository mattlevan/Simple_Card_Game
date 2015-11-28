/*
 * Matt Levan
 * CSC 331, Dr. Amlan Chatterjee
 * Data Structures
 *
 * Project 3 -- Simple Card Game
 *
 * Hand.java
 *
 * CITATION: 
 * Java Programming: From the Ground Up by Bravaco, Simonson
 * Page 481
 *
 * Original code modified to fit the needs of the project.
 *
 * Due in full by 11/16/2015 @ 11:59 PM.
 *
 */

public class Hand {
     // Attributes

     private SingleLinkedList cards; // Cards in hand

     // Default constructor

     public Hand() {
          cards = new SingleLinkedList(); // A singly linked list of cards
     }

     // Methods

     public void addCard(Card card) {
          cards.add(card);
     }

     public Card playCard() {
          Card cardToPlay = (Card) cards.removeFirst();

          return cardToPlay;
     }

     public int getSize() {
          return cards.size;
     }

     public void display() {
          String[][] tempArray = new String[13][4];
          int k = 1;

          // Populate tempArray with cards
          for (int i = 0; i < 13; i++) {
               for (int j = 0; j < 4; j++) {
                    if (cards.getNode(k) != null) {
                         tempArray[i][j] = cards.getNode(k).data.toString();
                         k++;
                    }
               }
          }

          for (int i = 0; i < 13; i++) {
               if (tempArray[i][0] != null) {
                    for (int j = 0; j < 4; j++) {
                         if (tempArray[i][j] != null) {
                              System.out.print(String.format("%3s", tempArray[i][j]));
                              System.out.print(" ");
                         }
                    }
                    System.out.println();               
               }
          }

          // cards.printList(cards.getNode(0));
     }
}