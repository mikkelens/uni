import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a zoo with animals.
 * @author Mikkel Stuckert 2023-10-01
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

    public int animals() {
        int count = 0;
        for (Animal animal : animals) {
            if (animal.getFemales() > 0 && animal.getMales() > 0) {
                count += animal.totalAnimals();
            }
        }
        return count;
    }

    public Animal largestPopulation() {
        Animal largestAnimal = null;
        int maxPopulation = Integer.MIN_VALUE;
        for (Animal animal : animals) {
            int totalAnimals = animal.totalAnimals();
            if (totalAnimals > maxPopulation) {
                maxPopulation = totalAnimals;
                largestAnimal = animal;
            }
        }
        return largestAnimal;
    }

    public void printZoo() {
        List<Animal> sortedAnimals = new ArrayList<>(animals);
        Collections.sort(sortedAnimals);

        System.out.print(name + ": " + sortedAnimals + "\n");
    }
}