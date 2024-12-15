import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

// Class representing a Ride, implementing RideInterface
public class Ride implements RideInterface {
    // Private fields to store ride-specific information
    private String name; // Name of the ride
    private int capacity; // Maximum number of visitors the ride can hold at once
    private int minimumHeight; // Minimum height requirement for the ride
    private Employee operator; // Employee operating the ride
    private boolean isOperational; // Status indicating if the ride is operational
    private int totalRiders; // Total number of riders who have used the ride
    private Queue<Visitor> visitorQueue; // Queue of visitors waiting for the ride
    private LinkedList<Visitor> rideHistory; // History of visitors who have used the ride
    private int maxRider; // Maximum number of riders per cycle
    private int numOfCycles; // Number of cycles the ride has completed

    // Constructor to initialize a ride with basic details
    public Ride(String name, int capacity, int minimumHeight) {
        this.name = name; // Set the ride name
        this.capacity = capacity; // Set the ride capacity
        this.minimumHeight = minimumHeight; // Set the minimum height requirement
        this.isOperational = true; // Set the ride as operational by default
        this.totalRiders = 0; // Initialize total riders to zero
        this.visitorQueue = new LinkedList<>(); // Initialize an empty queue for visitors
        this.rideHistory = new LinkedList<>(); // Initialize an empty list for ride history
    }

    // Overloaded constructor with additional maxRider parameter
    public Ride(String name, int capacity, int minimumHeight, int maxRider) {
        this.name = name; // Set the ride name
        this.capacity = capacity; // Set the ride capacity
        this.minimumHeight = minimumHeight; // Set the minimum height requirement
        this.isOperational = true; // Set the ride as operational by default
        this.totalRiders = 0; // Initialize total riders to zero
        this.visitorQueue = new LinkedList<>(); // Initialize an empty queue for visitors
        this.rideHistory = new LinkedList<>(); // Initialize an empty list for ride history
        this.maxRider = maxRider; // Set the maximum number of riders per cycle
        this.numOfCycles = 0; // Initialize the number of cycles to zero
    }

    // Getter method for the ride name
    public String getName() {
        return name;
    }

    // Setter method for the ride name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for the ride capacity
    public int getCapacity() {
        return capacity;
    }

    // Setter method for the ride capacity
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Getter method for the minimum height requirement
    public int getMinimumHeight() {
        return minimumHeight;
    }

    // Setter method for the minimum height requirement
    public void setMinimumHeight(int minimumHeight) {
        this.minimumHeight = minimumHeight;
    }

    // Getter method for the ride operator
    public Employee getOperator() {
        return operator;
    }

    // Setter method for the ride operator
    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    // Getter method to check if the ride is operational
    public boolean isOperational() {
        return isOperational;
    }

    // Setter method to set the operational status of the ride
    public void setOperational(boolean operational) {
        isOperational = operational;
    }
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        // Add the visitor to the end of the queue
        visitorQueue.offer(visitor);
        // Print a message indicating the visitor has been added to the queue
        System.out.println("Visitor " + visitor.getName() + " has been added to the queue for " + name);
    }

    @Override
    public void removeVisitorFromQueue() {
        // Remove the visitor at the front of the queue
        Visitor removed = visitorQueue.poll();
        if (removed != null) {
            // If a visitor was removed, print their name
            System.out.println("Visitor " + removed.getName() + " has been removed from the queue for " + name);
        } else {
            // If the queue was empty, print a message indicating no removal
            System.out.println("The queue for " + name + " is empty. No visitor removed.");
        }
    }

    @Override
    public void printQueue() {
        if (visitorQueue.isEmpty()) {
            // If the queue is empty, print a message indicating so
            System.out.println("The queue for " + name + " is currently empty.");
        } else {
            // Otherwise, print the details of each visitor in the queue
            System.out.println("Visitors in queue for " + name + ":");
            int position = 1;
            for (Visitor visitor : visitorQueue) {
                // Print the position, name, age, and ticket type of each visitor
                System.out.println(position + ". Name: " + visitor.getName() +
                        ", Age: " + visitor.getAge() +
                        ", Ticket Type: " + visitor.getTicketType());
                position++;
            }
        }
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            // If no operator is assigned, print a message and return
            System.out.println("The ride cannot be run. No operator assigned to " + name);
            return;
        }
        if (visitorQueue.isEmpty()) {
            // If the queue is empty, print a message and return
            System.out.println("The ride cannot be run. No visitors in the queue for " + name);
            return;
        }

        // Determine the number of riders for this cycle, limited by maxRider and queue size
        int ridersThisCycle = Math.min(maxRider, visitorQueue.size());
        // Print a message indicating the ride is running with the determined number of riders
        System.out.println("Running one cycle of " + name + " with " + ridersThisCycle + " riders.");

        for (int i = 0; i < ridersThisCycle; i++) {
            // Remove each rider from the queue and add them to the ride history
            Visitor rider = visitorQueue.poll();
            addVisitorToHistory(rider);
            // Increment the total number of riders
            totalRiders++;
        }

        // Increment the number of completed cycles
        numOfCycles++;
        // Print a message indicating the completion of the cycle
        System.out.println("Ride " + name + " completed cycle #" + numOfCycles + " with " + ridersThisCycle + " riders.");
    }
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        // Add the visitor to the ride's history list
        rideHistory.add(visitor);
        // Print a message confirming the visitor has been added to the history
        System.out.println(visitor.getName() + " has been added to the ride history of " + name);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        // Check if the visitor is in the ride's history
        boolean isInHistory = rideHistory.contains(visitor);
        // Print a message indicating whether the visitor is in the history
        System.out.println(visitor.getName() + (isInHistory ? " is" : " is not") + " in the ride history of " + name);
        // Return the result of the check
        return isInHistory;
    }

    @Override
    public int numberOfVisitors() {
        // Print the total number of visitors who have taken the ride
        System.out.println("Total number of visitors who have taken " + name + ": " + rideHistory.size());
        // Return the size of the ride history list
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            // If the ride history is empty, print a message indicating so
            System.out.println("No visitors have taken " + name + " yet.");
        } else {
            // Otherwise, print the details of each visitor in the ride history
            System.out.println("Ride history for " + name + ":");
            Iterator<Visitor> iterator = rideHistory.iterator();
            int count = 1;
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                // Print the position, name, age, and ticket type of each visitor
                System.out.println(count + ". Name: " + visitor.getName() +
                        ", Age: " + visitor.getAge() +
                        ", Ticket Type: " + visitor.getTicketType());
                count++;
            }
        }
    }

    public void sortRideHistory(Comparator<Visitor> comparator) {
        // Sort the ride history using the provided comparator
        Collections.sort(rideHistory, comparator);
        // Print a message confirming the ride history has been sorted
        System.out.println("Ride history for " + name + " has been sorted.");
    }

    public void exportRideHistory(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            // Write header to the file
            writer.println("Name,Age,Gender,TicketType");

            // Write each visitor's data to the file
            for (Visitor visitor : rideHistory) {
                writer.println(String.format("%s,%d,%s,%s",
                        visitor.getName(), visitor.getAge(), visitor.getGender(), visitor.getTicketType()));
            }
            // Print a message confirming the export
            System.out.println("Ride history for " + name + " has been exported to " + fileName);
        } catch (IOException e) {
            // Print an error message if an exception occurs
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    public void importRideHistory(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }
                // Split the line into data fields
                String[] data = line.split(",");
                if (data.length == 4) {
                    // Parse visitor attributes from the data
                    String name = data[0];
                    int age = Integer.parseInt(data[1]);
                    String gender = data[2];
                    String ticketType = data[3];
                    // Create a new Visitor object and add it to the history
                    Visitor visitor = new Visitor(name, age, gender, ticketType, true);
                    addVisitorToHistory(visitor);
                }
            }
            // Print a message confirming the import
            System.out.println("Ride history for " + this.name + " has been imported from " + fileName);
        } catch (IOException e) {
            // Print an error message if an I/O exception occurs
            System.err.println("Error reading from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            // Print an error message if age parsing fails
            System.err.println("Error parsing age: " + e.getMessage());
        }
    }

    public boolean isOpen() {
        // Return true if the ride is operational and an operator is assigned
        return isOperational && operator != null;
    }
}