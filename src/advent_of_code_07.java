import entities.advent_of_code_07.Leaf;
import entities.advent_of_code_07.Node;

import java.util.*;

public class advent_of_code_07 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String parent = "";
        List<Node> Nodes = new ArrayList<>();
        Map<String,Leaf> Leafs = new HashMap<>();
        while(in.hasNextLine()) {
            String temp = in.nextLine();
            //System.out.println(temp);
            if(temp.indexOf("->") < 0) {
                Leaf temp_leaf = new Leaf();
                String[] left_split = temp.split(" ");
                //System.out.println(left_split[0] + "\n" + left_split[1]);
                temp_leaf.setName(left_split[0]);
                String weight = left_split[1].substring(1,left_split[1].length() - 1);
                temp_leaf.setWeight(Integer.parseInt(weight));
                Leafs.put(temp_leaf.getName(),temp_leaf);
            } else {
                Node temp_node = new Node();
                String[] first_split = temp.split(" -> ");
                //System.out.println(first_split[0] + "\n" + first_split[1]);
                String[] left_split = first_split[0].split(" ");
                //System.out.println(left_split[0] + "\n" + left_split[1]);
                temp_node.setName(left_split[0]);
                String weight = left_split[1].substring(1,left_split[1].length() - 1);
                temp_node.setWeight(Integer.parseInt(weight));
                String[] right_split = first_split[1].split(", ");
                List<String> children = new ArrayList<>();
                for(int i = 0; i < right_split.length;i++) {
                    //System.out.println(right_split[i]);
                    children.add(right_split[i]);
                }
                temp_node.setChildren(children);
                Nodes.add(temp_node);
            }
        }
        for(int i = 0; i < Nodes.size();i++) {
            System.out.println(Nodes.get(i));
        }

        for (String key : Leafs.keySet()){
            Leaf value = Leafs.get(key);
            System.out.println("Key: " + key + "\n" + value);
        }

        for(int i = 0; i < Nodes.size();i++) {
            boolean found = false;
            String toCheck = Nodes.get(i).getName();
            for(int j = 0; j < Nodes.size();j++) {
                if(Nodes.get(j).isChild(toCheck)) {
                   found = false;
                   break;
                } else {
                    found = true;
                }
            }
            if(found == true) {
                parent = toCheck;
                break;
            }
        }
        System.out.println(parent);
    }
}
