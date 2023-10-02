import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        return (int)this.nails.stream()
                .filter(nail -> nail.getDiameter() >= diameter && nail.getLength() >= length)
                .count();
    }

    public List<Nail> find(String material) {
        return this.nails.stream()
                .filter(nail -> nail.getMaterial().toLowerCase() == material.toLowerCase())
                .collect(Collectors.toList());
    }

    public void printBox() {
        List<Nail> nails_sorted = this.nails.stream()
                .sorted((n1, n2) -> {
                    if (n1.getLength() != n2.getLength()) {
                        return Integer.compare(n1.getLength(), n2.getLength());
                    }
                    return n1.getMaterial().compareTo(n2.getMaterial());
                })
                .collect(Collectors.toList());
        System.out.println(this.name + ": " + nails_sorted);
    }
}