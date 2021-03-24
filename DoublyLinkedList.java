import java.util.List;
import java.util.Random;

public class DoublyLinkedList<E> {
    //Nested Class For a doubly linked list
    private static class Node<E> {
        private E element;

        private Node<E> prev;

        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;

            prev = p;

            next = n;

        }
        //Methods to get various elements
        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }
        //Methods to set node elements
        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

    }

    private Node<E> header;

    private Node<E> trailer;

    private int size = 0;
    //Constructor
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);

        trailer = new Node<>(null, header, null);

        header.setNext(trailer);
    }
    //Methods that are also in SinglyLinkedList
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement();

    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement();

    }
    //Header and trailers are null, so things must be placed between them
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);

    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(header.getNext());
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPrev());
    }
    //Adds a node between header and trailer
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {

        Node<E> newest = new Node<>(e, predecessor, successor);

        predecessor.setNext(newest);

        successor.setPrev(newest);

        size++;
    }
    //Removes a node
    private E remove(Node<E> node) {

        Node<E> predecessor = node.getPrev();

        Node<E> successor = node.getNext();

        predecessor.setNext(successor);

        successor.setPrev(predecessor);

        size--;

        return node.getElement();
    }
    //Same as create board in SinglyLinkedList
    public void createBoard2(DoublyLinkedList l, int n) {

        String PlayerName = "Player ";

        int looper = 0;

        while (looper < n) {

            Random Rambo = new Random();

            int ramboScore = Rambo.nextInt(1001);

            String playerNum = String.valueOf(looper);

            String newPerson = PlayerName + playerNum;

            GameEntry newPlayer = new GameEntry(newPerson, ramboScore);

            l.addLast(newPlayer);

            looper++;
        }
        //System.out.println(a.last());
    }
    //Unlike the other printAll(), certain things aren't necessary, we don't nee Node P here
    public void printAll() {

        int i = 0;

        Node n = header;

        while (i < getSize()) {

            if (n.next != null) {

                System.out.println(n.getNext().getElement()); //Header is null, must do this to get useful element

                n = n.next;

                i++;

            } else {


                break;


            }

        }
    }
    //Unlike the other printSummary, this code has less spaghetti
    //This is intentional to demonstrate that there is more than one way to achieve the goal of the method
    public void printSummary() {
        int sum = 0;

        int i = 0;

        int max = 0;

        int min = 1000;

        Node n = header;
        //While loop do maths and comparisons. The end result will change our values to get what we want to know
        while (i < getSize()) {

            if (n.next != null) {

                GameEntry entry = (GameEntry) n.getNext().getElement();

                sum = sum + entry.getScore();
                //This if, elif chain will compare values to reveal the min and max values
                if (max < entry.getScore()) {max = entry.getScore();}

                else if (min > entry.getScore()){min = entry.getScore();}

                n = n.next;

                i++;

                }
            }
        //This will just print out the maths we need to see certain values, like the other printSummary()
        System.out.println("The size of the board is " + getSize());
        System.out.println("The average score was " + (sum/getSize()));

        int range = max - min;

       System.out.println("The max value was " + max);

        System.out.println("The minimum value was " + min);

        System.out.println("The range for scores was " + range);
        }
    }
