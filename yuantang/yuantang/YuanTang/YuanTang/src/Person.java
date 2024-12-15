public abstract class Person {
    // Private fields to store the name, age, gender, contact number, and emergency contact of a person
    private String name;
    private int age;
    private String gender;
    private String contactNumber;
    private String emergencyContact;

    // Default constructor initializes the name, age, and gender with default values
    public Person() {
        this.name = "Unknown"; // Default name
        this.age = 0; // Default age
        this.gender = "Unspecified"; // Default gender
    }

    // Parameterized constructor to initialize a person with specific name, age, and gender
    public Person(String name, int age, String gender) {
        this.name = name; // Initialize name with given value
        this.age = age; // Initialize age with given value
        this.gender = gender; // Initialize gender with given value
        this.contactNumber = ""; // Initialize contact number as empty
        this.emergencyContact = ""; // Initialize emergency contact as empty
    }

    // Getter method for the name field
    public String getName() {
        return name;
    }

    // Setter method for the name field
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for the age field
    public int getAge() {
        return age;
    }

    // Setter method for the age field
    public void setAge(int age) {
        this.age = age;
    }

    // Getter method for the gender field
    public String getGender() {
        return gender;
    }

    // Setter method for the gender field
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getter method for the contact number field
    public String getContactNumber() {
        return contactNumber;
    }

    // Setter method for the contact number field
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // Getter method for the emergency contact field
    public String getEmergencyContact() {
        return emergencyContact;
    }

    // Setter method for the emergency contact field
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    // Method to determine if the person is an adult (age 18 or older)
    public boolean isAdult() {
        return age >= 18;
    }

    // Method to get a formatted string containing the contact and emergency contact information
    public String getFullContactInfo() {
        return "Contact: " + contactNumber + ", Emergency: " + emergencyContact;
    }
}