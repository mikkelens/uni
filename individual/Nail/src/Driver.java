import java.util.List;

/**
 * Representing a way of testing Box/nail methods
 * @author Mikkel Stuckert 2023-10-01
 */
public class Driver {
    public static void exam() {
        Nail[] nails = new Nail[] {
                new Nail("rubber", 5, 40),
                new Nail("titanium", 4, 30),
                new Nail("steel", 10, 100),
                new Nail("aluminium", 8, 90),
                new Nail("bronze", 7, 75),
                new Nail("rubber", 11, 75)
        };
        Box box = new Box("My Box of Nails");
        for (Nail nail : nails) {
            System.out.println(nail);
            box.add(nail);
        }
        int diameterConstraint = 6;
        System.out.println("Diameter constraint: " + diameterConstraint);
        int lengthConstraint = 40;
        System.out.println("Length constraint: " + lengthConstraint);
        int nailCountWithConstraint = box.number(diameterConstraint, lengthConstraint);
        System.out.println("Number of nails with constraint: " + nailCountWithConstraint);

        String materialFilter = "rubber";
        List<Nail> nailsOfMaterial = box.find(materialFilter);
        System.out.println("Nails of '" + materialFilter + "': " + nailsOfMaterial);

        box.printBox();
    }
}