import java.util.Comparator;

// Class that implements Comparator to compare Visitor objects
public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // First, compare by age
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());
        if (ageComparison != 0) {
            return ageComparison; // Return the result if ages are different
        }
        // If ages are the same, compare by name
        return v1.getName().compareTo(v2.getName()); // Return the result of name comparison
    }
}