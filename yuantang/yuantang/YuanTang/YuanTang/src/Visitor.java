import java.util.ArrayList;
import java.util.List;

public class Visitor extends Person {
    // Private fields to store visitor-specific information
    private String ticketType; // Type of ticket the visitor holds
    private boolean hasPassedSafetyCheck; // Indicates if the visitor has passed the safety check
    private int visitCount; // Number of times the visitor has visited
    private List<String> ridesToTry; // List of rides the visitor wants to try

    // Default constructor initializes visitor fields with default values
    public Visitor() {
        super(); // Calls the default constructor of the Person class
        this.ticketType = "Day Pass"; // Default ticket type
        this.hasPassedSafetyCheck = false; // Default safety check status
        this.visitCount = 1; // Default visit count
        this.ridesToTry = new ArrayList<>(); // Initializes an empty list of rides to try
    }

    // Parameterized constructor to initialize a visitor with specific details
    public Visitor(String name, int age, String gender, String ticketType, boolean hasPassedSafetyCheck) {
        super(name, age, gender); // Calls the parameterized constructor of the Person class
        this.ticketType = ticketType; // Initialize ticket type with given value
        this.hasPassedSafetyCheck = hasPassedSafetyCheck; // Initialize safety check status with given value
        this.visitCount = 1; // Default visit count
        this.ridesToTry = new ArrayList<>(); // Initializes an empty list of rides to try
    }

    // Getter method for the ticket type field
    public String getTicketType() {
        return ticketType;
    }

    // Setter method for the ticket type field
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    // Getter method for the safety check status field
    public boolean isHasPassedSafetyCheck() {
        return hasPassedSafetyCheck;
    }

    // Setter method for the safety check status field
    public void setHasPassedSafetyCheck(boolean hasPassedSafetyCheck) {
        this.hasPassedSafetyCheck = hasPassedSafetyCheck;
    }

    // Getter method for the visit count field
    public int getVisitCount() {
        return visitCount;
    }

    // Setter method for the visit count field
    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    // Getter method for the list of rides to try
    public List<String> getRidesToTry() {
        return ridesToTry;
    }

    // Setter method for the list of rides to try
    public void setRidesToTry(List<String> ridesToTry) {
        this.ridesToTry = ridesToTry;
    }

    // Method to add a ride to the list of rides the visitor wants to try
    public void addRideToTry(String rideName) {
        ridesToTry.add(rideName); // Adds the specified ride to the list
    }

    // Method to determine if the visitor is considered a frequent visitor
    public boolean isFrequentVisitor() {
        return visitCount > 5; // Returns true if the visit count is greater than 5
    }
}