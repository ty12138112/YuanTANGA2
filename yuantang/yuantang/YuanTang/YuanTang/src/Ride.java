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

    // Existing getters, setters, and methods...

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        visitorQueue.offer(visitor);
    }

    @Override
    public void removeVisitorFromQueue() {
        visitorQueue.poll();
    }

    @Override
    public void printQueue() {
        System.out.println("Visitors in queue for " + name + ":");
        for (Visitor visitor : visitorQueue) {
            System.out.println(visitor.getName());
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
        return false;
    }
}