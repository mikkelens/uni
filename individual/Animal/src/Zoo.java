import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Represents a zoo with animals.
 */
public class Zoo {
    private final String name;
    private final List<Animal> animals;

    public Zoo(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public void add(Animal a) {
        this.animals.add(a);
    }

    int animals() {
        return animals.stream()
                .filter(animal -> animal.getFemales() > 0 && animal.getMales() > 0)
                .mapToInt(Animal::totalAnimals)
                .sum();
    }

    public Animal largestPopulation() {
        return animals.stream()
                .max(Comparator.comparingInt(Animal::totalAnimals))
                .orElse(null);
    }

    public void printZoo() {
        List<Animal> animals = this.animals.stream()
                .sorted((a1, a2) -> { // sort by amount of females, otherwise amount of males
                    if (a1.getFemales() != a2.getFemales()) {
                        return Integer.compare(a2.getFemales(), a1.getFemales()); // descending order
                    }
                    return Integer.compare(a2.getMales(), a1.getMales()); // descending order
                })
                .toList();
        System.out.println(name + ": " + animals);
    }
}