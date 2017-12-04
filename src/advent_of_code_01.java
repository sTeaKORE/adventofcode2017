import java.util.Scanner;

public class advent_of_code_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = 0;
        String toParse = "";
        while(in.hasNext()) {
            toParse += in.next();
        }
        System.out.println(toParse);
        int current = -1;
        for(int i = 0; i < toParse.length();i++) {
            int toCheck = Integer.parseInt(toParse.charAt(i)+"");
            if(current == -1) {
                current = toCheck;
            } else {
                if(current == toCheck) {
                    result += toCheck;
                } else {
                    current = toCheck;
                }
            }
        }
        int lastCheck = Integer.parseInt(toParse.charAt(0) + "");
        if(lastCheck == current) {
            result += current;
        }
        in.close();
        System.out.println(result);
    }
}
