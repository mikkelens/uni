/**
 * Represents a type of vegetable
 */
public class Vegetable {
    private final String name;
    private final boolean organic;
    private final int number;

    public Vegetable(String name, boolean organic, int number) {
        this.name = name;
        this.organic = organic;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public boolean isOrganic() {
        return organic;
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        return this.getNumber()
                + (this.isOrganic() ? " organic " : " non-organic ")
                + this.getName();
    }
}