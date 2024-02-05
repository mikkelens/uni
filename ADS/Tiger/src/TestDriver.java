import java.util.Arrays;
import java.util.List;

public class TestDriver {
    public static void test() {
        List<Tiger> tigers = Arrays.asList(
                new Tiger(true, 90, "yellow"),
                new Tiger(true, 200, "red"),
                new Tiger(false, 220, "red"),
                new Tiger(false, 120, "yellow"),
                new Tiger(false, 125, "orange")
        );
        Forest forest = new Forest("India");
        for (Tiger tiger : tigers) {
//            System.out.println(tiger);
            forest.addTiger(tiger);
        }

        System.out.println("Tigers between 100 and 200 weight: " + forest.findTigers(100, 200));
        System.out.println("Smallest tiger that is male: " + forest.smallTiger(true));

        forest.printForest();

        System.out.println("Heavy tigers (above 100 kg): " + forest.heavyTigers(100));
        System.out.println("Sum of male tigers: " + forest.findWeight(true));
    }
}