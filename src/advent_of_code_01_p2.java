import java.util.Scanner;

public class advent_of_code_01_p2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = 0;
        String toParse = "";
        while(in.hasNext()) {
            toParse += in.next();
        }
        in.close();
        System.out.println(toParse);
        int half = toParse.length() / 2;
        System.out.println("Half Value: " + half);
        String part1 = toParse.substring(0,half);
        String part2 = toParse.substring(half,toParse.length());
        System.out.println(part1);
        System.out.println(part2);
        for(int i = 0; i < half;i++) {
            int number_p1 = Integer.parseInt(toParse.charAt(i)+"");
            int number_p2 = Integer.parseInt(toParse.charAt(half + i) + "");
            if(number_p1 == number_p2) {
                result += 2 * number_p1;
            }
        }
        System.out.println(result);
    }
}
