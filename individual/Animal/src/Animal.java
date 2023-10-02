/**
 * Represents a certain species of animal.
 * @author Mikkel Stuckert 2023-10-01
 */
public class Animal implements Comparable<Animal> {
    private final String name;
    private final int females;
    private final int males;

    public Animal(String name, int females, int males) {
        this.name = name;
        this.females = females;
        this.males = males;
    }

    public int getFemales() {
        return females;
    }

    public int getMales() {
        return males;
    }

    public int totalAnimals() {
        return getMales() + getFemales();
    }

    public String toString() {
        return name + ": " + getFemales() + " female and " + getMales() + " male";
    }

    @Override
    public int compareTo(Animal o) {
        if (this.getFemales() != o.getFemales()) {
            return Integer.compare(o.getFemales(), this.getFemales());
        }
        return Integer.compare(o.getMales(), this.getMales());
    }
}