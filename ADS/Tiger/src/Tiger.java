public class Tiger implements Comparable<Tiger> {
    private final boolean male;
    private final int weight;
    private final String colour;

    public Tiger(boolean male, int weight, String colour) {
        this.male = male;
        this.weight = weight;
        this.colour = colour;
    }

    public boolean getMale() {
        return this.male;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getColour() {
        return this.colour;
    }

    public String toString() {
        return weight + " kg " + colour + (male ? " male" : " female");
    }

    public int compareTo(Tiger other) {
        if (!this.getColour().equalsIgnoreCase(other.getColour())) {
            return this.getColour().compareToIgnoreCase(other.getColour()); // alphabetical
        }
        return Integer.compare(this.getWeight(), other.getWeight()); // low to high
    }
}