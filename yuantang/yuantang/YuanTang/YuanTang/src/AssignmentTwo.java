import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AssignmentTwo {
    // Lists to store employees, visitors, and rides
    private List<Employee> employees;
    private List<Visitor> visitors;
    private List<Ride> rides;

    // Constructor to initialize the lists
    public AssignmentTwo() {
        employees = new ArrayList<>(); // Initialize the employee list
        visitors = new ArrayList<>();  // Initialize the visitor list
        rides = new ArrayList<>();     // Initialize the ride list
    }

    // Method to demonstrate part three of the assignment
    public void partThree() {
        System.out.println("Part Three Demonstration:");

        // Create a new ride called "Thrilling Coaster" with a duration of 20 minutes and a height requirement of 140 cm
        Ride rollerCoaster = new Ride("Thrilling Coaster", 20, 140);

        // Create visitor objects with their respective details
        Visitor v1 = new Visitor("Alice", 25, "Female", "Day Pass", true);
        Visitor v2 = new Visitor("Bob", 30, "Male", "Season Pass", true);
        Visitor v3 = new Visitor("Charlie", 22, "Male", "Day Pass", true);
        Visitor v4 = new Visitor("Diana", 28, "Female", "Season Pass", true);
        Visitor v5 = new Visitor("Eve", 35, "Female", "Day Pass", true);

        // Add visitors to the queue of the roller coaster
        System.out.println("\nAdding visitors to the queue:");
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // Print the current queue of visitors
        System.out.println("\nCurrent queue:");
        rollerCoaster.printQueue();

        // Remove a visitor from the queue
        System.out.println("\nRemoving a visitor from the queue:");
        rollerCoaster.removeVisitorFromQueue();

        // Print the updated queue after removal
        System.out.println("\nUpdated queue after removal:");
        rollerCoaster.printQueue();
    }

    // Method to demonstrate part four A of the assignment
    public void partFourA() {
        System.out.println("Part Four A Demonstration:");

        // Create a new ride called "Giant Ferris Wheel" with a duration of 30 minutes and a height requirement of 120 cm
        Ride ferrisWheel = new Ride("Giant Ferris Wheel", 30, 120);

        // Create visitor objects with their respective details
        Visitor v1 = new Visitor("Alice", 25, "Female", "Day Pass", true);
        Visitor v2 = new Visitor("Bob", 30, "Male", "Season Pass", true);
        Visitor v3 = new Visitor("Charlie", 22, "Male", "Day Pass", true);
        Visitor v4 = new Visitor("Diana", 28, "Female", "Season Pass", true);
        Visitor v5 = new Visitor("Eve", 35, "Female", "Day Pass", true);

        // Add visitors to the ride history of the ferris wheel
        System.out.println("\nAdding visitors to the ride history:");
        ferrisWheel.addVisitorToHistory(v1);
        ferrisWheel.addVisitorToHistory(v2);
        ferrisWheel.addVisitorToHistory(v3);
        ferrisWheel.addVisitorToHistory(v4);
        ferrisWheel.addVisitorToHistory(v5);

        // Check if specific visitors are in the ride history
        System.out.println("\nChecking if visitors are in the ride history:");
        ferrisWheel.checkVisitorFromHistory(v3);
        ferrisWheel.checkVisitorFromHistory(new Visitor("Frank", 40, "Male", "Day Pass", true));

        // Print the number of visitors in the ride history
        System.out.println("\nNumber of visitors in the ride history:");
        ferrisWheel.numberOfVisitors();

        // Print all visitors in the ride history
        System.out.println("\nPrinting all visitors in the ride history:");
        ferrisWheel.printRideHistory();
    }

    public void partFourB() {
        System.out.println("Part Four B Demonstration:");

        // Create a new ride called "Swinging Ship" with a duration of 40 minutes and a height requirement of 130 cm
        Ride swingingShip = new Ride("Swinging Ship", 40, 130);

        // Create visitor objects with their respective details
        Visitor v1 = new Visitor("Alice", 25, "Female", "Day Pass", true);
        Visitor v2 = new Visitor("Bob", 30, "Male", "Season Pass", true);
        Visitor v3 = new Visitor("Charlie", 22, "Male", "Day Pass", true);
        Visitor v4 = new Visitor("Diana", 28, "Female", "Season Pass", true);
        Visitor v5 = new Visitor("Eve", 25, "Female", "Day Pass", true);

        // Add visitors to the ride history of the swinging ship
        System.out.println("\nAdding visitors to the ride history:");
        swingingShip.addVisitorToHistory(v1);
        swingingShip.addVisitorToHistory(v2);
        swingingShip.addVisitorToHistory(v3);
        swingingShip.addVisitorToHistory(v4);
        swingingShip.addVisitorToHistory(v5);

        // Print all visitors in the ride history before sorting
        System.out.println("\nPrinting all visitors in the ride history before sorting:");
        swingingShip.printRideHistory();

        // Sort the ride history using a VisitorComparator
        System.out.println("\nSorting the ride history:");
        swingingShip.sortRideHistory(new VisitorComparator());

        // Print all visitors in the ride history after sorting
        System.out.println("\nPrinting all visitors in the ride history after sorting:");
        swingingShip.printRideHistory();
    }

    public void partFive() {
        System.out.println("Part Five Demonstration:");

        // Create a new ride called "Extreme Coaster" with a duration of 30 minutes, height requirement of 150 cm, and max riders of 5
        Ride rollerCoaster = new Ride("Extreme Coaster", 30, 150, 5);

        // Create an employee object to act as the ride operator
        Employee operator = new Employee("John Doe", 35, "Male", "E001", "Ride Operator", 50000);
        rollerCoaster.setOperator(operator);

        Random r = new Random();

        // Add 10 visitors to the queue with random ages between 10 and 40
        for (int i = 1; i <= 10; i++) {
            int a = r.nextInt(10, 40); // Generate a random age
            Visitor visitor = new Visitor("Visitor" + i, a, (a % 2 == 0) ? "Male" : "Female", "Day Pass", true);
            rollerCoaster.addVisitorToQueue(visitor);
        }

        // Print all visitors in the queue before running a cycle
        System.out.println("\nPrinting all visitors in the queue before running a cycle:");
        rollerCoaster.printQueue();

        // Run one cycle of the ride
        System.out.println("\nRunning one cycle:");
        rollerCoaster.runOneCycle();

        // Print all visitors in the queue after running one cycle
        System.out.println("\nPrinting all visitors in the queue after running one cycle:");
        rollerCoaster.printQueue();

        // Print all visitors in the ride history
        System.out.println("\nPrinting all visitors in the ride history:");
        rollerCoaster.printRideHistory();
    }
    public void partSix() {
        System.out.println("Part Six Demonstration:");

        // Create a new ride called "Giant Ferris Wheel" with a duration of 40 minutes, height requirement of 120 cm, and max riders of 8
        Ride ferrisWheel = new Ride("Giant Ferris Wheel", 40, 120, 8);

        // Add 5 visitors to the ride history
        Visitor v1 = new Visitor("Alice", 25, "Female", "Day Pass", true);
        Visitor v2 = new Visitor("Bob", 30, "Male", "Season Pass", true);
        Visitor v3 = new Visitor("Charlie", 22, "Male", "Day Pass", true);
        Visitor v4 = new Visitor("Diana", 28, "Female", "Season Pass", true);
        Visitor v5 = new Visitor("Eve", 35, "Female", "Day Pass", true);

        ferrisWheel.addVisitorToHistory(v1);
        ferrisWheel.addVisitorToHistory(v2);
        ferrisWheel.addVisitorToHistory(v3);
        ferrisWheel.addVisitorToHistory(v4);
        ferrisWheel.addVisitorToHistory(v5);

        // Export the ride history to a CSV file
        System.out.println("\nExporting ride history to file:");
        ferrisWheel.exportRideHistory("ferris_wheel_history.csv");

        // Print the ride history
        System.out.println("\nPrinting ride history:");
        ferrisWheel.printRideHistory();
    }

    public void partSeven() {
        System.out.println("Part Seven Demonstration:");

        // Create a new ride called "Giant Ferris Wheel" with a duration of 40 minutes, height requirement of 120 cm, and max riders of 8
        Ride ferrisWheel = new Ride("Giant Ferris Wheel", 40, 120, 8);

        // Import the ride history from a CSV file
        System.out.println("\nImporting ride history from file:");
        ferrisWheel.importRideHistory("ferris_wheel_history.csv");

        // Print the number of visitors in the ride history
        System.out.println("\nNumber of visitors in the ride history:");
        ferrisWheel.numberOfVisitors();

        // Print the imported ride history
        System.out.println("\nPrinting imported ride history:");
        ferrisWheel.printRideHistory();
    }

    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        System.out.println("=== Part Three ===");
        assignment.partThree();
        System.out.println("\n=== Part Four A ===");
        assignment.partFourA();
        System.out.println("\n=== Part Four B ===");
        assignment.partFourB();
        System.out.println("\n=== Part Five ===");
        assignment.partFive();
        System.out.println("\n=== Part Six ===");
        assignment.partSix();
        System.out.println("\n=== Part Seven ===");
        assignment.partSeven();
    }
}