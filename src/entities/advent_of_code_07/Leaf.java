package entities.advent_of_code_07;

public class Leaf {

    String name;
    int weight;

    public Leaf() {

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

    @Override
    public String toString() {
        String result = "Type: Leaf\n";
        result +="Name: "+name +"\n";
        result +="Weight: "+weight +"\n";
        return result;
    }
}
