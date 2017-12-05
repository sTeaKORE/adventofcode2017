import javax.swing.text.html.ListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class advent_of_code_05 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        while(in.hasNextInt()) {
            numbers.add(in.nextInt());
        }
        in.close();
        display(numbers,0);
        int atm = 0;
        int steps = 0;
        while(atm >= 0 && atm < numbers.size()) {
            int toJump = numbers.get(atm);
            increment(numbers,atm);
            atm += toJump;
            steps++;
            //System.out.println("At: " + atm);
            //display(numbers,atm);
        }
        System.out.println(steps);
    }

    private static List<Integer> increment(List<Integer> temp, int index) {
        int tmp = temp.get(index);
        tmp++;
        temp.set(index, tmp);
        return temp;
    }

    private static void display(List<Integer> numbers,int atm) {
        for(int i = 0; i < numbers.size();i++) {
            if(i == atm) {
                System.out.print("(" + numbers.get(i) + ") ");
            } else {
                System.out.print(numbers.get(i) + " ");
            }
        }
        System.out.println("\n");
    }
}
