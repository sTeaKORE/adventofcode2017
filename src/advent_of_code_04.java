import java.util.HashSet;
import java.util.Scanner;

public class advent_of_code_04 {

    public static void main(String[] args) {
        int overallCount = 0;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String temp = in.nextLine();
            String[] count = temp.split(" ");
            HashSet<String> countWithoutDuplicate = new HashSet<>();
            for(int i = 0; i < count.length;i++) {
                countWithoutDuplicate.add(count[i]);
            }
            if(countWithoutDuplicate.size() == count.length) {
                overallCount++;
            }
        }
        System.out.println(overallCount);
    }
}
