import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class Main {

    private static Site sunderlandHQ = new Site("Sunderland");

    public static void main(String[] args) {
        Scanner scInput = new Scanner(System.in);
        boolean quit = false;
        userMenu();
        while (!quit) {
            System.out.println("Please enter a choice or press 0 to list the menu");
            int userIn = scInput.nextInt();

            switch (userIn) {
                case 0:
                    userMenu();
                    break;
                case 1:
                    createSwitch();
                    break;
                case 2:
                    removeSwitch();
                    break;
                case 3:
                    updateSwitch();
                    break;
                case 4:
                    querySwitch();
                    break;
                case 5:
                    findSwitch();
                    break;
                case 6:
                    printSwitches();
                    break;
                case 9:
                    addSite();
                    break;

            }
        }
    }

    private static boolean findSwitch() {
        if (querySwitch()) {
            System.out.println("Switch exists");
            return true;
        }
        System.out.println("Switch does not exist");
        return false;
    }

    private static boolean updateSwitch() {
        System.out.println("Enter serial of old switch");
        int oldSerial = new Scanner(System.in).nextInt();
        int foundPos = querySwitch(oldSerial);
        Switch foundSwitch = sunderlandHQ.computerNetwork.get(foundPos);
        if (foundPos >= 0) {
            sunderlandHQ.removeSwitch(foundSwitch);
            createSwitch();
            return true;
        }
        return false;
    }

    private static int querySwitch(int switchSerial) {
        int serial = switchSerial;
        int foundPos = sunderlandHQ.findSwitch(serial);
        if (foundPos >= 0) {
            return foundPos;
        }
        return -1;
    }

    private static boolean querySwitch() {
        System.out.println("Enter switch serial");
        int serial = new Scanner(System.in).nextInt();
        int foundPos = sunderlandHQ.findSwitch(serial);
        if (foundPos >= 0) {
            System.out.println(sunderlandHQ.computerNetwork.get(foundPos).getSerial() + "\t" +
                    sunderlandHQ.computerNetwork.get(foundPos).getIpAddress() + "\t" + sunderlandHQ.computerNetwork.get(foundPos).getLocation());
            return true;
        }
        System.out.println("Could not locate switch");
        return false;
    }

    private static void userMenu() {
        System.out.println("Switch management console");
        System.out.println("-------------------------");
        System.out.println("1. \t Create a switch");
        System.out.println("2. \t Remove a switch");
        System.out.println("3. \t Update a switch");
        System.out.println("4. \t Query a switch");
        System.out.println("5. \t Find a switch");
        System.out.println("6. \t Print all switches");
        System.out.println("9. \t Add a site");
        System.out.println("0. \t Show this menu");

    }

    private static void createSwitch() {
        System.out.println("Enter an IP address: ");
        String ip = new Scanner(System.in).next();
        System.out.println("Enter the admin username");
        String userName = new Scanner(System.in).next();
        System.out.println("Enter admin password");
        String password = new Scanner(System.in).next();
        System.out.println("Enter switch location");
        String location = new Scanner(System.in).next();
        System.out.println("Enter model of switch");
        String model = new Scanner(System.in).next();
        System.out.println("Enter serial of switch");
        int serial = new Scanner(System.in).nextInt();
        Switch newSwitch = Switch.createSwitch(ip, userName, password, location, model, serial);
        sunderlandHQ.createSwitch(newSwitch);
    }

    private static void removeSwitch() {
        printSwitches();
        System.out.println("Enter the serial of the switch");
        int serial = new Scanner(System.in).nextInt();
        int foundPos = sunderlandHQ.findSwitch(serial);
        Switch foundSwitch = sunderlandHQ.computerNetwork.get(foundPos);
        sunderlandHQ.removeSwitch(foundSwitch);
    }

    private static void printSwitches() {
        System.out.println("\t Serial \t IP \t Model \n");
        for (int i = 0; i < sunderlandHQ.computerNetwork.size(); i++) {
            System.out.println(i + 1 + ".\t " + sunderlandHQ.computerNetwork.get(i).getSerial() + "\t" +
                    sunderlandHQ.computerNetwork.get(i).getIpAddress() + "\t" + sunderlandHQ.computerNetwork.get(i).getLocation());
        }
        System.out.println("Total number of switches: \t" + sunderlandHQ.computerNetwork.size());
    }

    private static boolean addSite() {
        //Will return to this properly
        System.out.println("Not working yet");
        return true;
    }
}
