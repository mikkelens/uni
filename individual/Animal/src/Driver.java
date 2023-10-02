import java.util.Arrays;
import java.util.List;

public class Driver {
    public static void exam() {
        List<Animal> animals = Arrays.asList(
                new Animal("elephant", 17, 24),
                new Animal("horse", 8, 9),
                new Animal("pigeon", 519, 451),
                new Animal("cow", 30, 11),
                new Animal("chicken", 17, 4)
        );
        Zoo zoo = new Zoo("My Zoo");
        for (Animal animal : animals) {
            System.out.println("Animal: " + animal);
            zoo.add(animal);
        }
        int totalAnimals = zoo.animals();
        System.out.println("Total animal count: " + totalAnimals);

        Animal largestAnimalPopulation = zoo.largestPopulation();
        System.out.println("Animal with largest population: " + largestAnimalPopulation);

        zoo.printZoo();
    }
}