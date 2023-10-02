/**
 * Represents a certain species of animal.
 */
public class Animal {
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

    public String toString() {
        return name + ": " + getFemales() + " females and " + getMales() + " males";
    }

    int totalAnimals() {
        return getMales() + getFemales();
    }
}