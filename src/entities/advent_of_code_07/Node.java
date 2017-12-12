package entities.advent_of_code_07;

import java.util.List;

public class Node {

    String name;
    int weight;
    List<String> children;


    public Node() {

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

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public boolean isChild(String test) {
        for(int i = 0; i < children.size();i++) {
            if(test.equals(children.get(i))) {
                System.out.println(test + " is child of " + name);
                return true;
            }
        }
        System.out.println(test + " is no child of " + name);
        return false;
    }

    @Override
    public String toString() {
        String result = "Type: Node\n";
        result += "Name: " + name + "\n";
        result += "Weight: " + weight + "\n";
        result += "Children:\n";
        for(int i = 0; i < children.size();i++) {
            result += children.get(i) + "\n";
        }
        return result;
    }
}
