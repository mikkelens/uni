import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a grocery store with vegetables.
 * @author Mikkel Stuckert 2023-10-01
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
        for (Vegetable vegetable : vegetables) {
            if (vegetable.isOrganic() == organic) {
                return vegetable;
            }
        }
        return null;
    }

    public boolean organic() {
        int totalOrganic = 0;
        int totalNonOrganic = 0;
        for (Vegetable vegetable : vegetables) {
            int number = vegetable.getNumber();
            if (vegetable.isOrganic()) {
                totalOrganic += number;
            } else {
                totalNonOrganic += number;
            }
        }
        return totalOrganic > totalNonOrganic;
    }

    public void printShop() {
        List<Vegetable> sortedVegetables = new ArrayList<>(vegetables);
        Collections.sort(sortedVegetables);
        System.out.println(owner + ": " + sortedVegetables);
    }
}