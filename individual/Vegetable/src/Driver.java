import java.util.Arrays;
import java.util.List;

public class Driver {
    public static void exam() {
        List<Vegetable> vegetables = Arrays.asList(
                new Vegetable("carrots", true, 10),
                new Vegetable("tomatoes", true, 98),
                new Vegetable("tomatoes", false, 10),
                new Vegetable("cucumbers", false, 4)
        );
        Shop shop = new Shop("Salling Group");
        for (Vegetable vegetable : vegetables) {
            System.out.println(vegetable);
            shop.add(vegetable);
        }

        System.out.println("Organic vegetable: " + shop.find(true));

        System.out.println("Shop is "
                + (shop.organic() ? "" : "NOT ")
                + "organic.");

        shop.printShop();
    }
}