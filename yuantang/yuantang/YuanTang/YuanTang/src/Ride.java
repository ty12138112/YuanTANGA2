import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class Ride implements RideInterface {
    private String name;
    private int capacity;
    private int minimumHeight;
    private Employee operator;
    private boolean isOperational;
    private int totalRiders;
    private Queue<Visitor> visitorQueue;
    private List<Visitor> rideHistory;

    public Ride() {
        this.name = "Unknown Ride";
        this.capacity = 0;
        this.minimumHeight = 0;
        this.isOperational = false;
        this.totalRiders = 0;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new ArrayList<>();
    }

    public Ride(String name, int capacity, int minimumHeight) {
        this.name = name;
        this.capacity = capacity;
        this.minimumHeight = minimumHeight;
        this.isOperational = true;
        this.totalRiders = 0;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getMinimumHeight() {
        return minimumHeight;
    }

    public void setMinimumHeight(int minimumHeight) {
        this.minimumHeight = minimumHeight;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public boolean isOperational() {
        return isOperational;
    }

    public void setOperational(boolean operational) {
        isOperational = operational;
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        visitorQueue.offer(visitor);
        System.out.println("Visitor " + visitor.getName() + " has been added to the queue for " + name);
    }

    @Override
    public void removeVisitorFromQueue() {
        Visitor removed = visitorQueue.poll();
        if (removed != null) {
            System.out.println("Visitor " + removed.getName() + " has been removed from the queue for " + name);
        } else {
            System.out.println("The queue for " + name + " is empty. No visitor removed.");
        }
    }

    @Override
    public void printQueue() {
        if (visitorQueue.isEmpty()) {
            System.out.println("The queue for " + name + " is currently empty.");
        } else {
            System.out.println("Visitors in queue for " + name + ":");
            int position = 1;
            for (Visitor visitor : visitorQueue) {
                System.out.println(position + ". Name: " + visitor.getName() +
                        ", Age: " + visitor.getAge() +
                        ", Ticket Type: " + visitor.getTicketType());
                position++;
            }
        }
    }

    @Override
    public void runOneCycle() {
        if (!isOpen()) {
            System.out.println("The ride is not operational.");
            return;
        }

        int ridersThisCycle = Math.min(capacity, visitorQueue.size());
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor rider = visitorQueue.poll();
            addVisitorToHistory(rider);
            totalRiders++;
        }

        System.out.println("Ride " + name + " completed one cycle with " + ridersThisCycle + " riders.");
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride history for " + name + ":");
        for (Visitor visitor : rideHistory) {
            System.out.println(visitor.getName());
        }
    }

    public boolean isOpen() {
        return isOperational && operator != null;
    }
}