public class Ride {
    private String name;
    private int capacity;
    private int minimumHeight;
    private Employee operator;
    private boolean isOperational; // 新增
    private int totalRiders; // 新增

    public Ride() {
        this.name = "Unknown Ride";
        this.capacity = 0;
        this.minimumHeight = 0;
        this.isOperational = false;
        this.totalRiders = 0;
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

    public int getTotalRiders() {
        return totalRiders;
    }

    public void setTotalRiders(int totalRiders) {
        this.totalRiders = totalRiders;
    }

    public Ride(String name, int capacity, int minimumHeight) {
        this.name = name;
        this.capacity = capacity;
        this.minimumHeight = minimumHeight;
        this.isOperational = true;
        this.totalRiders = 0;
    }

    // Getters and setters for all fields...

    public boolean isOpen() {
        return operator != null && isOperational;
    }

    // 新增方法
    public void performMaintenance() {
        this.isOperational = false;
        System.out.println(name + " is under maintenance.");
    }

    public void addRider() {
        if (isOpen()) {
            totalRiders++;
        }
    }

    public double getAverageRidersPerDay(int days) {
        return (double) totalRiders / days;
    }
}