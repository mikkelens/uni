import java.util.ArrayList;
import java.util.List;

/**
 * Represents a grocery store with vegetables.
 */
public class Shop {
    private final String owner;
    private final List<Vegetable> vegetables;

    public Shop(String owner) {
        this.owner = owner;
        this.vegetables = new ArrayList<>();
    }

    public void add(Vegetable v) {
        vegetables.add(v);
    }

    public Vegetable find(boolean organic) {
        return vegetables.stream()
                .filter(v -> v.isOrganic() == organic)
                .findAny()
                .orElse(null);
    }

    public boolean organic() {
        int totalOrganic = vegetables.stream()
                .filter(Vegetable::isOrganic)
                .mapToInt(Vegetable::getNumber)
                .sum();
        int totalNonOrganic = vegetables.stream()
                .filter(v -> !v.isOrganic())
                .mapToInt(Vegetable::getNumber)
                .sum();
        return totalOrganic > totalNonOrganic;
    }

    public void printShop() {
        List<Vegetable> sortedVegetables = vegetables.stream().sorted((a, b) -> {
            if (!a.getName().equals(b.getName())) {
                return a.getName().compareTo(b.getName());
            }
            return Integer.compare(b.getNumber(), a.getNumber()); // descending
        }).toList();
        System.out.println(owner + ": " + sortedVegetables);
    }
}