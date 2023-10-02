/**
 * Representing a nail.
 * @author Mikkel Stuckert 2023-10-01
 */
public class Nail {
    private String material;
    private int diameter;
    private int length;

    public Nail(String material, int diameter, int length) {
        this.material = material;
        this.diameter = diameter;
        this.length = length;
    }

    public String toString() {
        return getDiameter() + " mm x " + getLength() + " mm of " + getMaterial();
    }

    public String getMaterial() {
        return material;
    }

    public int getDiameter() {
        return diameter;
    }

    public int getLength() {
        return length;
    }
}