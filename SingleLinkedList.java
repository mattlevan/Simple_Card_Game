/*
 * Matt Levan
 * CSC 331, Dr. Amlan Chatterjee
 * Data Structures
 *
 * Implement a singly linked list
 * 
 * Must include methods:
 * addFirst, addAfter add, removeAfter, removeFirst, printList, getNode
 *
 * Due in full by 10/15/2015
 *
 */

class Node {
    // Attributes

    Object data;
    Node next;

    // Constructors

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }
}

public class SingleLinkedList {
    // Attributes

    private Node head = new Node(-1);
    public int size = 0; // Size of linked list in number of Node

    // Methods

    // Adds by default to the end
    public void add(Object item) {
        addAfter(item, getNode(size));
    }

    public void add(Object item, int index) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addFirst(item);
        }
        else {
            addAfter(item, getNode(index - 1));
        }
    }

    public void addFirst(Object item) {
        Node first = new Node(item); // Create new first Node
        first.next = head.next;
        head.next = first;
        size++;
    }

    public void addAfter(Object item, Node target) {
        Node after = new Node(item);
        after.next = target.next;
        target.next = after;
        size++;
    }

    public Object removeFirst() {
        if (size > 0) { 
            Node first = head.next;
            head.next = first.next;
            size--;

            return first.data;
        }

        return null;
    }

    public Object removeAfter(Node target) {
        if (target.next != null) {
            Node after = target.next;
            target.next = after.next;
            size--;

            return after.data;
        }

        return null;
    }

    public Node getNode(int index) {
        Node node = head;

        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        
        return node;
    }

    // Custom printList for cards
    public void printList(Node head) {
        Node temp = head.next; // Start printing at node AFTER head

        while (temp != null) {
            System.out.print(temp.data.toString() + " ");
            temp = temp.next;
        }
    }
}