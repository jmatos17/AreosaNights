import java.util.ArrayList;
import java.util.Scanner;

public class ProgramController {

    private Hotel hotel;
    private ArrayList<Person> clientList;
    private int clientCounter;
    private boolean isConsoleRunning;
    private boolean isLoggedIn;
    private String loggedInName;


    public static void main(String[] args) {

        ProgramController programController = new ProgramController();
        programController.run();

    }

    public ProgramController() {

        hotel = new Hotel("Big Chungus", 10);
        clientList = new ArrayList<>();
        clientCounter = 0;
        isConsoleRunning = true;
        isLoggedIn = false;
        loggedInName = "";

    }

    public void run() {

        int activeOperation;
        Scanner input = new Scanner(System.in);

        while (isConsoleRunning) {
            printLogInMessage(input);
            while (isLoggedIn) {
                activeOperation = printHotelMenu(input);
                computeOperation(activeOperation, input);
            }
        }
    }

    public void printLogInMessage(Scanner input) {

        System.out.println("Insert your username: ");
        loggedInName = input.nextLine();
        isLoggedIn = true;
    }

    public int printHotelMenu(Scanner input) {

        System.out.println("Welcome to Hotel " + hotel.getName() + " management software");
        System.out.println("Insert 1 for check in");
        System.out.println("Insert 2 for check out");
        System.out.println("Insert 3 to log off");
        System.out.println("Insert 4 to check your room number");
        System.out.println("Insert 666 to close console");

        int returnValue = Integer.parseInt(input.nextLine());

        return returnValue;
    }

    public void computeOperation(int operationID, Scanner input) {

        switch (operationID) {

            case 1:
                registerCustomer(input);
                break;

            case 2:
                checkOutCostumer(input);
                break;

            case 3:
                isLoggedIn = false;
                loggedInName = "";
                break;

            case 4:
                printCostumerRoom();
                break;

            case 666:
                leaveConsole();
                break;

            default:
                System.out.println("Stop trying to break my program");
                break;
        }
    }

    public void registerCustomer(Scanner input) {

        for (int i = 0; i < clientList.size(); i++) {
            if (loggedInName.equals(clientList.get(i).getName())) {
                System.out.println("You have already checked in to your room");
                return;
            }
        }

        Person guest = new Person(loggedInName);
        clientList.add(clientCounter, guest);
        guest.checkIn(hotel);
        clientCounter++;
    }

    public void checkOutCostumer(Scanner input) {
        System.out.println("Please insert your name to check out: ");
        String checkOutName = input.nextLine();

        if (!checkOutName.equals(loggedInName)) {
            System.out.println("hilarious stuff user, no");
            return;
        }
        for (int i = 0; i < clientList.size(); i++) {
            if (checkOutName.equals(clientList.get(i).getName())) {
                clientList.get(i).checkOut(hotel);
                clientList.remove(i);
                clientCounter--;
                return;
            }
        }
        System.out.println("Invalid name, please try again");

    }

    public void printCostumerRoom() {
        for (int i = 0; i < clientList.size(); i++) {
            if (loggedInName.equals(clientList.get(i).getName()) && clientList.get(i).getIsCheckedIn()) {
                System.out.println("Your room number is " + clientList.get(i).getRoomNumber());
                return;
            }
        }
        System.out.println("You are not checked in any room");
    }

    public void leaveConsole() {
        isConsoleRunning = false;
        isLoggedIn = false;
        System.out.println("Thank you for visiting " + hotel.getName());
    }

}
