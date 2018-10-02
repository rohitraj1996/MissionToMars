public class Item {
    private String name;
    private int weight;

    //Parametrized constructor having two parameters.
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    //Default constructor.
    public Item() {
        this("", 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
