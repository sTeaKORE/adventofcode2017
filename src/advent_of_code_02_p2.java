import java.util.Scanner;
import java.util.regex.Pattern;

public class advent_of_code_02_p2 {

        public static void main(String[] args) {
            int checkSum = 0;
            Scanner in = new Scanner(System.in);
            while(in.hasNextLine()) {
                String temp = in.nextLine();
                String[] numbers = temp.split("\\s+");
                boolean found = false;
                for(int i = 0; i < numbers.length;i++) {
                    if(found) { break; }
                    int toCheck = Integer.parseInt(numbers[i]);
                    for(int j = 0;j < numbers.length;j++) {
                        if(i != j) {
                            int toDivide = Integer.parseInt(numbers[j]);
                            if(toCheck % toDivide == 0) {
                                checkSum += toCheck / toDivide;
                                found = true;
                                break;
                            }
                        }
                    }
                }
            }
            in.close();
            System.out.println(checkSum);
        }
}


