import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class advent_of_code_06_p2 {

    private static HashSet<String> countWithoutDuplicate = new HashSet<>();
    private static HashSet<String> determineLoop = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> banks = new ArrayList<>();
        while(in.hasNextInt()) {
            banks.add(in.nextInt());
        }
        in.close();
        int steps = 0;
        while(saveConstelation(banks)) {
            display(banks);
            int index = getMaxIndex(banks);
            distributeNumber(banks,index);
        }
        int index = getMaxIndex(banks);
        distributeNumber(banks,index);
        steps++;
        while(determineLoopSize(banks)) {
            display(banks);
            index = getMaxIndex(banks);
            distributeNumber(banks,index);
            steps++;
        }
        System.out.println(steps);
    }

    private static void display(List<Integer> numbers) {
        for(int i = 0; i < numbers.size();i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println("\n");
    }

    private static int getMaxIndex(List<Integer> numbers) {
        int max = -1;
        int index = -1;
        for(int i = 0; i < numbers.size();i++) {
            if(numbers.get(i) > max) {
                max = numbers.get(i);
                index = i;
            }
        }
        return index;
    }

    private static boolean saveConstelation(List<Integer> numbers) {
        String toBeSaved = "";
        int checkSize = countWithoutDuplicate.size();
        for(int i = 0; i < numbers.size();i++) {
            toBeSaved += numbers.get(i);
        }
        countWithoutDuplicate.add(toBeSaved);
        if(checkSize == countWithoutDuplicate.size()) {
            determineLoop.add(toBeSaved);
            return false;
        } else {
            return true;
        }
    }

    private static boolean determineLoopSize(List<Integer> numbers) {
        String toBeSaved = "";
        int checkSize = determineLoop.size();
        for(int i = 0; i < numbers.size();i++) {
            toBeSaved += numbers.get(i);
        }
        determineLoop.add(toBeSaved);
        if(checkSize == determineLoop.size()) {
            return false;
        } else {
            return true;
        }
    }

    private static List<Integer> distributeNumber(List<Integer> numbers,int index) {
        int toDistribute = numbers.get(index);
        numbers.set(index, 0);
        index = (index + 1) % numbers.size();
        while(toDistribute != 0) {
            int tmp = numbers.get(index);
            tmp ++;
            toDistribute--;
            numbers.set(index,tmp);
            index = (index + 1) % numbers.size();
        }
        return numbers;
    }
}
