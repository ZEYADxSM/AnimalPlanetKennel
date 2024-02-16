import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class runs a Kennel
 *
 * @author Lynda Thomas, Chris Loftus and Faisal Rezwan
 * @version 3 (20th February 2023)
 */
public class KennelDemo {
    private String filename; // holds the name of the file
    private Kennel kennel; // holds the kennel
    private Scanner scan; // so we can read from keyboard

    /*
     * Notice how we can make this constructor private, since we only call from main which
     * is in this class. We don't want this class to be used by any other class.
     */
    private KennelDemo() {
        scan = new Scanner(System.in);
        System.out.print("Please enter the filename of kennel information: ");
        filename = scan.nextLine();

        kennel = new Kennel();
    }

    /*
     * initialise() method runs from the main and reads from a file
     */
    private void initialise() {
        System.out.println("Using file " + filename);

        try {
            kennel.load(filename);
        } catch (FileNotFoundException e) {
            System.err.println("The file: " + filename + " does not exist. Assuming first use and an empty file." +
                    " If this is not the first use then have you accidentally deleted the file?");
        } catch (IOException e) {
            System.err.println("An unexpected error occurred when trying to open the file " + filename);
            System.err.println(e.getMessage());
        }
    }

    /*
     * runMenu() method runs from the main and allows entry of data etc
     */
    private void runMenu() {
        String response;
        do {
            printMenu();
            System.out.println("What would you like to do:");
            scan = new Scanner(System.in);
            response = scan.nextLine().toUpperCase();
            switch (response) {
                case "1":
                    admitAnimal();
                    break;
                case "2":
                    changeKennelName();
                    break;
                case "3":
                    printAll();
                    break;
                case "4":
                    searchForCat();
                    break;
                case "5":
                    removeAnimals();
                    break;
                case "6":
                    setKennelCapacity();
                    break;
                case "Q":
                    break;
                default:
                    System.out.println("Try again");
            }
        } while (!(response.equals("Q")));
    }

    private void printMenu() {
        System.out.println("1 -  add a new animal ");
        System.out.println("2 -  set up Kennel name");
        System.out.println("3 -  display all animals");
        System.out.println("4 -  search for an animal");
        System.out.println("5 -  remove a cat");
        System.out.println("6 -  set kennel capacity");
        System.out.println("q - Quit");
    }

    private void setKennelCapacity() {
        System.out.print("Enter max number of cats: ");
        int max = scan.nextInt();
        scan.nextLine();
        kennel.setCapacity(max);
    }

    /*
     * printAll() method runs from the main and prints status
     */
    private void printAll() {
        System.out.println(kennel);
    }

    /*
     * save() method runs from the main and writes back to file
     */
    private void save() {
        try {
            kennel.save(filename);
        } catch (IOException e) {
            System.err.println("Problem when trying to write to file: " + filename);
        }
    }

    private void removeAnimals() {
        System.out.println("which animal do you want to remove");
        String animalToBeRemoved;
        animalToBeRemoved = scan.nextLine();
        kennel.removeAnimal(animalToBeRemoved);
    }

    private void searchForCat() {
        System.out.println("which cat do you want to search for");
        String name = scan.nextLine();
        Animal animal = kennel.search(name);
        if (animal != null) {
            System.out.println(animal.toString());
        } else {
            System.out.println("Could not find cat: " + name);
        }
    }

    private void changeKennelName() {
        String name = scan.nextLine();
        kennel.setName(name);
    }

    private void admitAnimal() {
        System.out.println("Please enter the following information about the animal: \nIs the animal a dog or a cat? (D/C)");
        String animalType = scan.nextLine();
        //name
        System.out.println("What is their name?");
        String name = scan.nextLine();
        //food
        System.out.println("What is his/her favourite food?");
        String fav = scan.nextLine();
        //feeding freq
        System.out.println("How many times is he/she fed a day? (as a number)");
        int numTimes = scan.nextInt();
        //specific animal
        //switch statement for easy expansion
        Animal a;
        switch (animalType) {
            case "C" -> {
                System.out.println("Can the cat share an exercise run?(Y/N)");
                boolean canShare = scan.nextLine().equalsIgnoreCase("Y");
                a = new Cat(name, fav, numTimes, canShare);
            }
            case "D" -> {
                System.out.println("Does the dog like bones?(Y/N)");
                boolean likesBones = scan.next().equalsIgnoreCase("Y");
                a = new Dog(name, fav, numTimes, likesBones);
            }
            default -> {
                System.err.println("Invalid - not a specified input");
                return;
            }
        }
    }

    private ArrayList<Owner> getOwners() {
            ArrayList<Owner> owners = new ArrayList<Owner>();
            String answer;
            do {
                System.out.println("Enter on separate lines: owner-name owner-phone");
                String ownName = scan.nextLine();
                String ownPhone = scan.nextLine();
                Owner own = new Owner(ownName, ownPhone);
                owners.add(own);
                System.out.println("Another owner (Y/N)?");
                answer = scan.nextLine().toUpperCase();
            } while (!answer.equals("N"));
            return owners;
    }


    // /////////////////////////////////////////////////
    public static void main(String args[]) {
        System.out.println("**********HELLO***********");
        KennelDemo demo = new KennelDemo();
        demo.initialise();
        demo.runMenu();
        demo.printAll();
        // MAKE A BACKUP COPY OF cats.txt JUST IN CASE YOU CORRUPT IT
        demo.save();
        System.out.println("***********GOODBYE**********");
    }
}
