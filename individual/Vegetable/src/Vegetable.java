/**
 * Represents a type of vegetable
 * @author Mikkel Stuckert 2023-10-01
 */
public class Vegetable implements Comparable<Vegetable> {
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

    @Override
    public int compareTo(Vegetable o) {
        if (!this.getName().equals(o.getName())) {
            return this.getName().compareTo(o.getName()); // ascending alphabetical order
        }
        return Integer.compare(o.getNumber(), this.getNumber()); // descending order
    }
}