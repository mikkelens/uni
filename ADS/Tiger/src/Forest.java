import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Forest {
    private final String country;
    private final List<Tiger> tigers;

    public Forest(String country) {
        this.country = country;
        tigers = new ArrayList<>();
    }

    public void addTiger(Tiger t) {
        tigers.add(t);
    }

    public ArrayList<Tiger> findTigers(int min, int max) {
        ArrayList<Tiger> tigersBetween = new ArrayList<>();
        for (Tiger tiger : this.tigers) {
            if (tiger.getWeight() >= min && tiger.getWeight() <= max) {
                tigersBetween.add(tiger);
            }
        }
        return tigersBetween;
    }

    public Tiger smallTiger(boolean male) {
        Tiger smallest = null;
        for (Tiger tiger : this.tigers) {
            if (tiger.getMale() != male) {
                continue;
            }
            if (smallest == null || smallest.getWeight() > tiger.getWeight()) {
                smallest = tiger;
            }
        }
        return smallest;
    }

    public void printForest() {
        List<Tiger> sortedTigers = new ArrayList<>(this.tigers);
        Collections.sort(sortedTigers);
        System.out.println(this.country + ": " + sortedTigers);
    }

    public long heavyTigers(int minWeight) {
        return this.tigers.stream().filter(t -> t.getWeight() >= minWeight).count();
    }

    public int findWeight(boolean male) {
        return this.tigers.stream().filter(t -> t.getMale() == male).mapToInt(t -> t.getWeight()).sum();
    }
}