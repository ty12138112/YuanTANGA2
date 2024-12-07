import java.util.ArrayList;
import java.util.List;

public class Visitor extends Person {
    private String ticketType;
    private boolean hasPassedSafetyCheck;
    private int visitCount; // 新增
    private List<String> ridesToTry; // 新增

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public boolean isHasPassedSafetyCheck() {
        return hasPassedSafetyCheck;
    }

    public void setHasPassedSafetyCheck(boolean hasPassedSafetyCheck) {
        this.hasPassedSafetyCheck = hasPassedSafetyCheck;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public List<String> getRidesToTry() {
        return ridesToTry;
    }

    public void setRidesToTry(List<String> ridesToTry) {
        this.ridesToTry = ridesToTry;
    }

    public Visitor() {
        super();
        this.ticketType = "Day Pass";
        this.hasPassedSafetyCheck = false;
        this.visitCount = 1;
        this.ridesToTry = new ArrayList<>();
    }

    public Visitor(String name, int age, String gender, String ticketType, boolean hasPassedSafetyCheck) {
        super(name, age, gender);
        this.ticketType = ticketType;
        this.hasPassedSafetyCheck = hasPassedSafetyCheck;
        this.visitCount = 1;
        this.ridesToTry = new ArrayList<>();
    }

    // Getters and setters for all fields...

    // 新增方法
    public void addRideToTry(String rideName) {
        ridesToTry.add(rideName);
    }

    public boolean isFrequentVisitor() {
        return visitCount > 5;
    }
}