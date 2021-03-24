import java.lang.Math;
import java.util.List;
import java.util.Random;

//Code for the Singly Linked List Class
public class SinglyLinkedList<E> {
    //Nested class
    private static class Node<E> {
        //Instane Varaibles
        private E element;
        private Node<E> next;

        //Constructor
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        //Methods
        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    //End Nested Node class
    //Instance Variables for the SLL class
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    //Constructor
    public SinglyLinkedList() {
    }//Just create empty SLL

    //Method for the Singly Linked List class
    //Access Methods
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //First method returns the element at the head of the list
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    //Last method: return the element at the tail of list
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    //Update methods
    //addFirst Method: add new element as the head of the SLL
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    //addLast Method: add new element as the tail of SLL
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    //removeFirst method: This return and remove the head element of the SLL
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }
    //This method will create a linked list to store the board
    public void createBoard(SinglyLinkedList a, int n) {
        //SinglyLinkedList Board = new SinglyLinkedList();
        String PlayerName = "Player ";

        int looper = 0;

        while (looper < n) {

            Random Rambo = new Random();

            int ramboScore = Rambo.nextInt(1001);

            String playerNum = String.valueOf(looper);

            String newPerson = PlayerName + playerNum;

            GameEntry newPlayer = new GameEntry(newPerson, ramboScore);

            a.addLast(newPlayer);

            looper++;
        }


    }
    //Method to print everything in the list
    public void printAll(SinglyLinkedList l) {
        int i = 0;
        //This while loop will move us through the list and do math along the way
        Node p = null;

        Node n = head;

        while (i < l.getSize()) {

            if (n.next != null) {

                System.out.println(n.getElement());

                p = n;

                n = n.next;

                i++;

            } else {

                System.out.println(n.getElement()); // the loop won't get the last object, so this is neccesary


                break;
            }


        }
    }


    //This method will print some certain values we care about
    public void printSummary(SinglyLinkedList l) {

        //System.out.println("The current size of the board is " + getSize());

        int sum = 0;

        int i = 0;

        Node p = null;

        Node n = head;

        //While loop that does maths to help us reveal the average of the scores
        while (i < l.getSize()) {

            if (n.next != null) {

                GameEntry entry = (GameEntry) n.getElement();

                sum = sum + entry.getScore();

                p = n;

                n = n.next;

                i++;

            } else {

                GameEntry entry = (GameEntry) n.getElement();

                sum = sum + entry.getScore();

                break;

            }

        }
        //Create an average variable
        double average = Math.round(sum / getSize());

       // System.out.println("The average score was " + average);

        int newI = 0;

        int max = 0;

        int min = 1000;

        Node a = null;

        Node j = head;

        //This very long chunk of loop will compare values to reveal min and max values
        while (newI < l.getSize()){

            if (j.next != null){

                GameEntry entry = (GameEntry) j.getElement();

                if (max < entry.getScore()){ max = entry.getScore();}

                else if (min > entry.getScore()){ min = entry.getScore();}

                a = j;

                j = j.next;

                i++;

            }else{

                //This section ensures the last node is checked
                GameEntry entry = (GameEntry) j.getElement();

                if (max < entry.getScore()){ max = entry.getScore();}

                else if (min > entry.getScore()){ min = entry.getScore();}

                break;
            }
        }
        //Print out values we want to know
        int range = max - min;

        System.out.println("The max value was " + max);

        System.out.println("The minimum value was " + min);

        System.out.println("The range for scores was " + range);


            }


}



