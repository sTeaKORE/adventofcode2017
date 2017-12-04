import java.util.Scanner;
import java.util.regex.Pattern;

public class advent_of_code_02 {

    public static void main(String[] args) {
        int checkSum = 0;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            int high = -1;
            int low = -1;
            String temp = in.nextLine();
            String[] numbers = temp.split("\\s+");
            for(int i  = 0; i < numbers.length;i++) {
                int toCheck = Integer.parseInt(numbers[i]);
                if(high == -1 && low == -1) {
                    high = toCheck;
                    low = toCheck;
                } else {
                    if(high < toCheck) { high = toCheck; }
                    if(low > toCheck) { low = toCheck;}
                }
            }
            int addCheckSum = high - low;
            checkSum += addCheckSum;
        }
        in.close();
        System.out.println(checkSum);
    }
}
