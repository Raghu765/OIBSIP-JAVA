import java.util.Scanner;

public class Reservation {
    public static void main (String [] args) {
     DoublyLinkedList seatList = new DoublyLinkedList();
     Scanner in = new Scanner(System.in);
     

        for (int i = 1; i <= 10; i++) {

            seatList.addNode(i);

        }
        
        int choice;
        
        do {

            System.out.println("\nMenu:");

            System.out.println("1. Reserve a seat");

            System.out.println("2. Cancel reservation");

            System.out.println("3. Check seat availability");

            System.out.println("4. List reserved seats");

            System.out.println("5. List available seats");

            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            choice = in.nextInt();

 

            int seatNumber;

            switch (choice) {

                case 1:

                    System.out.print("Enter seat number to reserve: ");

                    seatNumber = in.nextInt();

                    seatList.reserveSeat(seatNumber);

                    break;

                case 2:

                    System.out.print("Enter seat number to cancel reservation: ");

                    seatNumber = in.nextInt();

                    seatList.cancelReservation(seatNumber);

                    break;

                case 3:

                    System.out.print("Enter seat number to check availability: ");

                    seatNumber = in.nextInt();

                    seatList.checkSeatAvailability(seatNumber);

                    break;

                case 4:

                    seatList.listReservedSeats();

                    break;

                case 5:

                    seatList.listAvailableSeats();

                    break;

                case 0:

                    System.out.println("Exiting...");

                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 0);
    }
}

class Node {

    int seatNumber;

    boolean reserved;

    Node next;

    Node prev;

 

    public Node(int seatNumber) {

        this.seatNumber = seatNumber;

        this.reserved = false;

        this.next = null;

        this.prev = null;

    }

}

class DoublyLinkedList {

    Node head;

    Node tail;

 

    public DoublyLinkedList() {

        this.head = null;

        this.tail = null;

    }

 

    public void addNode(int seatNumber) {

        Node newNode = new Node(seatNumber);

 

        if (head == null) {

            head = tail = newNode;

        } else {

            tail.next = newNode;

            newNode.prev = tail;

            tail = newNode;

        }

    }

 

    public void reserveSeat(int seatNumber) {

        Node current = head;

        while (current != null) {

            if (current.seatNumber == seatNumber) {

                if (!current.reserved) {

                    current.reserved = true;

                    System.out.println("Seat " + seatNumber + " reserved.");

                } else {

                    System.out.println("Seat " + seatNumber + " is already reserved.");

                }

                return;

            }

            current = current.next;

        }

        System.out.println("Seat " + seatNumber + " does not exist.");

    }

 

    public void cancelReservation(int seatNumber) {

        Node current = head;

        while (current != null) {

            if (current.seatNumber == seatNumber) {

                if (current.reserved) {

                    current.reserved = false;

                    System.out.println("Reservation for seat " + seatNumber + " cancelled.");

                } else {

                    System.out.println("Seat " + seatNumber + " is not reserved.");

                }

                return;

            }

            current = current.next;

        }

        System.out.println("Seat " + seatNumber + " does not exist.");

    }

 

    public void checkSeatAvailability(int seatNumber) {

        Node current = head;

        while (current != null) {

            if (current.seatNumber == seatNumber) {

                if (current.reserved) {

                    System.out.println("Seat " + seatNumber + " is already reserved.");

                } else {

                    System.out.println("Seat " + seatNumber + " is available.");

                }

                return;

            }

            current = current.next;

        }

        System.out.println("Seat " + seatNumber + " does not exist.");

    }

 

    public void listReservedSeats() {

        Node current = head;

        System.out.println("Reserved Seats:");

        while (current != null) {

            if (current.reserved) {

                System.out.print(current.seatNumber + " ");

            }

            current = current.next;

        }

        System.out.println();

    }

 

    public void listAvailableSeats() {

        Node current = head;

        System.out.println("Available Seats:");

        while (current != null) {

            if (!current.reserved) {

                System.out.print(current.seatNumber + " ");

            }

            current = current.next;

        }

        System.out.println();

    }

}