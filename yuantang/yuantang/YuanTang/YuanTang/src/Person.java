public abstract class Person {
    private String name;
    private int age;
    private String gender;
    private String contactNumber;
    private String emergencyContact;

    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.gender = "Unspecified";
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactNumber = "";
        this.emergencyContact = "";
    }

    // Getters and setters remain the same...

    public boolean isAdult() {
        return age >= 18;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getFullContactInfo() {
        return "Contact: " + contactNumber + ", Emergency: " + emergencyContact;
    }
}