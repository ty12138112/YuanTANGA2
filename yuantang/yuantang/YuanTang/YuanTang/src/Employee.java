public class Employee extends Person {
    // Private fields to store employee-specific information
    private String employeeId;
    private String department;
    private double salary;
    private int yearsOfExperience;

    // Default constructor initializes employee fields with default values
    public Employee() {
        super(); // Calls the default constructor of the Person class
        this.employeeId = "E0000"; // Default employee ID
        this.department = "Unassigned"; // Default department
    }

    // Parameterized constructor to initialize an employee with specific details
    public Employee(String name, int age, String gender, String employeeId, String department, double salary) {
        super(name, age, gender); // Calls the parameterized constructor of the Person class
        this.employeeId = employeeId; // Initialize employee ID with given value
        this.department = department; // Initialize department with given value
        this.salary = salary; // Initialize salary with given value
        this.yearsOfExperience = 0; // Default years of experience
    }

    // Getter method for the employee ID field
    public String getEmployeeId() {
        return employeeId;
    }

    // Setter method for the employee ID field
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    // Getter method for the department field
    public String getDepartment() {
        return department;
    }

    // Setter method for the department field
    public void setDepartment(String department) {
        this.department = department;
    }

    // Getter method for the salary field
    public double getSalary() {
        return salary;
    }

    // Setter method for the salary field
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Getter method for the years of experience field
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    // Setter method for the years of experience field
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    // Method to give a raise to the employee based on a percentage increase
    public void giveRaise(double percentage) {
        this.salary *= (1 + percentage / 100); // Increase salary by the given percentage
    }

    // Method to get a formatted string containing the employee's ID, department, and years of experience
    public String getEmployeeInfo() {
        return String.format("Employee %s, Dept: %s, Experience: %d years", employeeId, department, yearsOfExperience);
    }
}