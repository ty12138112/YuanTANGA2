public class Employee extends Person {
    private String employeeId;
    private String department;
    private double salary;
    private int yearsOfExperience; // 新增

    public Employee() {
        super();
        this.employeeId = "E0000";
        this.department = "Unassigned";
    }

    public Employee(String name, int age, String gender, String employeeId, String department, double salary) {
        super(name, age, gender);
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
        this.yearsOfExperience = 0;
    }

    // Getters and setters for all fields...

    // 新增方法
    public void giveRaise(double percentage) {
        this.salary *= (1 + percentage / 100);
    }

    public String getEmployeeInfo() {
        return String.format("Employee %s, Dept: %s, Experience: %d years", employeeId, department, yearsOfExperience);
    }
}