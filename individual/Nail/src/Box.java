import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Representing a box of nails
 * @author Mikkel Stuckert 2023-10-01
 */
public class Box {
    private String name;
    private List<Nail> nails;

    public Box(String name) {
        this.name = name;
        this.nails = new ArrayList<>();
    }

    public void add(Nail n) {
        this.nails.add(n);
    }

    public int number(int diameter, int length) {
        int count = 0;
        for (Nail nail : this.nails) {
            if (nail.getDiameter() >= diameter && nail.getLength() >= length) {
                count++;
            }
        }
        return count;
    }

    public List<Nail> find(String material) {
        List<Nail> foundNails = new ArrayList<>();
        for (Nail nail : this.nails) {
            if (nail.getMaterial().equalsIgnoreCase(material)) {
                foundNails.add(nail);
            }
        }
        return foundNails;
    }

    public void printBox() {
        List<Nail> nails_sorted = new ArrayList<>(this.nails);
        nails_sorted.sort((a, b) -> {
            // lambdas are technically declarative, not imperative,
            // but I don't think reimplementing a specific sorting algorithm myself is the point of this assignment
            if (a.getLength() != b.getLength()) {
                return Integer.compare(b.getLength(), a.getLength()); // descending order
            }
            return a.getMaterial().compareTo(b.getMaterial()); // ascending alphabetical order
        });

        // this is not getting accepted by the test server, and I don't think it's possible for me to know why
        System.out.println(this.name + ": " + nails_sorted);
    }
}