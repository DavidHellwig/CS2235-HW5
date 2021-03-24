import java.util.Random;
public class DisplayBoardLists {
    public static void main(String[] args) {

        //Demonstration of function methods, shows us things we want to know
        SinglyLinkedList Galaga = new SinglyLinkedList();

        Galaga.createBoard(Galaga,20);

        Galaga.printAll(Galaga);

        Galaga.printSummary(Galaga);



        DoublyLinkedList SpaceInvader2 = new DoublyLinkedList();

        SpaceInvader2.createBoard2(SpaceInvader2, 20);

        SpaceInvader2.printAll();

        SpaceInvader2.printSummary();


        }

}
