import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>(); // Monkey ArrayList

    public static void main(String[] args) {
        initializeDogList();
        initializeMonkeyList();

        Scanner scanner = new Scanner(System.in);  // Scanner for user input
        String userInput;
        boolean exit = false;

        while (!exit) {
            displayMenu();  // Displays the menu
            userInput = scanner.nextLine().trim().toLowerCase();

            switch (userInput) {
                case "1":
                    intakeNewDog(scanner);
                    break;
                    
                case "2":
                    intakeNewMonkey(scanner);
                    break;
                    
                case "3":
                    reserveAnimal(scanner);
                    break;
                    
                case "4":
                    printAnimals("dog");
                    break;
                    
                case "5":
                    printAnimals("monkey");
                    break;
                    
                case "6":
                    printAnimals("available");
                    break;
                    
                case "q":
                    System.out.println("Exiting application. Goodbye!");
                    exit = true;
                    break;
                    
                default:
                    System.out.println("Invalid input. Please select a valid menu option.");
            }
        } while (!userInput.equals("q"));
    }

    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.print("Enter a menu selection: ");
    }

    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Charlie", "Capuchin", "male", "10", "3.5", "1.2", "01-10-2020", "Brazil", "in service", false, "United States");
        Monkey monkey2 = new Monkey("Molly", "Tamarin", "female", "12", "4.2", "1.5", "03-15-2021", "Peru", "Phase II", false, "Canada");
        Monkey monkey3 = new Monkey("George", "Macaque", "male", "8", "4.0", "1.4", "07-22-2019", "India", "in service", true, "India");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }

    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        
        // Check if Dog already exists
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return;
            }
        }
        
        // Collect additional data
        System.out.println("Enter the dog's breed:");
        String breed = scanner.nextline();
        System.out.println("Enter the dog's gender:");
        String gender = scanner.nextLine();
        System.out.println("Enter the dog's age:");
        String age = scanner.nextLine();
        System.out.println("Enter the dog's weight:");
        String weight = scanner.nextLine();
        System.out.println("Enter the dog's acquisition date (e.g., MM-DD-YYYY):");
        String acquisitionDate = scanner.nextLine();
        System.out.println("Enter the dog's acquisition country:");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("Enter the dog's training status:");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the dog reserved? (true/false):");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter the dog's service country");
        String serviceCountry = scanner.nextLine();
        
        // Instantiate new dog and add to list
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, serviceCountry);
        dogList.add(newDog);
        
        System.out.println("/nDog added successfully!");
    }

    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("Enter the monkey's name:");
        String name = scanner.nextLine();

        // Check if monkey already exists
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return;
            }
        }
        
        // List of valid monkey species
        String[] validSpecies = {"Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel Monkey", "Tamarin"};
        
        System.out.println("Enter the monkey's species (valid options: Capuchin, Guenon, Macaque, MArmoset, Squirrel Monkey, Tamarin):");
        String species = scanner.nextLine().trim();
        
        // Validate the species type
        boolean isValidSpecies = false;
        for (String valid : validSpecies) {
        	if (valid.equalsIgnoreCase(species)) {
        		isValidSpecies = true;
        		break;
        	}
        }
        
        if (isValidSpecies) {
        	System.out.println("Invalid species. Please enter a valid species from the list.");
        	return; // Exit the methodand return to the menu
        }
        
        // Collect additional data
        System.out.println("Enter the monkey's species:");
        String species = scanner.nextLine();
        System.out.println("Enter the monkey's gender:");
        String gender = scanner.nextLine();
        System.out.println("Enter the monkey's age:");
        String age = scanner.nextLine();
        System.out.println("Enter the monkey's weight:");
        String weight = scanner.nextLine();
        System.out.println("Enter the monkey's tail length:");
        String tailLength = scanner.nextLine();
        System.out.println("Enter the monkey's height:");
        String height = scanner.nextLine();
        System.out.println("Enter the monkey's body length:");
        String bodyLength = scanner.nextLine();
        System.out.println("Enter the monkey's acquisition date (e.g., MM-DD-YYYY):");
        String acquisitionDate = scanner.nextLine();
        System.out.println("Enter the monkey's acquisition country:");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("Enter the monkey's training status:");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the monkey reserved? (true/false):");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter the monkey's service country:");
        String serviceCountry = scanner.nextLine();

        // Instantiate new monkey and add to list
        Monkey newMonkey = new Monkey(name, species, gender, age, weight, tailLength, height, bodyLength, reserved, acquisitionCountry, trainingStatus, acquisitionDate, serviceCountry);
        monkeyList.add(newMonkey);

        System.out.println("\nMonkey added successfully!");
    }

    public static void reserveAnimal(Scanner scanner) {
        System.out.println("Enter the type of animal to reserve (dog/monkey): ");
        String animalType = scanner.nextLine().trim().toLowerCase();

        System.out.println("Enter the service country: ");
        String serviceCountry = scanner.nextLine().trim();

        boolean animalReserved = false;

        if (animalType.equals("dog")) {
            for (Dog dog : dogList) {
                if (dog.getAcquisitionLocation().equalsIgnoreCase(serviceCountry) &&
                    dog.getTrainingStatus().equalsIgnoreCase("in service") &&
                    !dog.getReserved()) {

                    dog.setReserved(true); // Update reserve status
                    System.out.println("The dog " + dog.getName() + " has been successfully reserved.");
                    animalReserved = true;
                    break; // Reserve the first available animal
                }
            }
        } else if (animalType.equals("monkey")) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getAcquisitionLocation().equalsIgnoreCase(serviceCountry) &&
                    monkey.getTrainingStatus().equalsIgnoreCase("in service") &&
                    !monkey.getReserved()) {

                    monkey.setReserved(true); // Update the reserved status
                    System.out.println("The monkey " + monkey.getName() + " has been successfully reserved.");
                    animalReserved = true;
                    break; // Reserve the first available animal
                }
            }
        } else {
            System.out.println("Invalid animal type. Please enter 'dog' or 'monkey'.");
            return;
        }

        if (!animalReserved) {
            System.out.println("No available " + animalType + " found in " + serviceCountry + " that meets the criteria.");
        }
    }

    public static void printAnimals() {
        System.out.println("\n\n--- List of Available Animals (In Service and Not Reserved) ---");

        boolean foundAvailable = false;

        // Print available dogs
        for (Dog dog : dogList) {
            if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.isReserved()) {
                if (!foundAvailable) foundAvailable = true;
                System.out.println("\n[Dog]");
                System.out.println("Name: " + dog.getName());
                System.out.println("Breed: " + dog.getBreed());
                System.out.println("Gender: " + dog.getGender());
                System.out.println("Age: " + dog.getAge());
                System.out.println("Weight: " + dog.getWeight());
                System.out.println("Acquisition Date: " + dog.getAcquisitionDate());
                System.out.println("Acquisition Location: " + dog.getAcquisitionLocation());
                System.out.println("Training Status: " + dog.getTrainingStatus());
                System.out.println("Reserved: " + (dog.isReserved() ? "Yes" : "No"));
            }
        }

        // Print available monkeys
        for (Monkey monkey : monkeyList) {
            if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.isReserved()) {
                if (!foundAvailable) foundAvailable = true;
                System.out.println("\n[Monkey]");
                System.out.println("Name: " + monkey.getName());
                System.out.println("Species: " + monkey.getSpecies());
                System.out.println("Gender: " + monkey.getGender());
                System.out.println("Age: " + monkey.getAge());
                System.out.println("Weight: " + monkey.getWeight());
                System.out.println("Acquisition Date: " + monkey.getAcquisitionDate());
                System.out.println("Acquisition Location: " + monkey.getAcquisitionLocation());
                System.out.println("Training Status: " + monkey.getTrainingStatus());
                System.out.println("Reserved: " + (monkey.isReserved() ? "Yes" : "No"));
            }
        }

        // No animals found case
        if (!foundAvailable) {
            System.out.println("\nNo animals are currently available (In Service and Not Reserved).");
        }
    }
            	}
        }
    }
