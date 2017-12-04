import java.util.Arrays;

public class advent_of_code_03 {

    public static void main(String[] args) {
        int end = 1;
        int test = 12;
        int des = 347991;
        int range = 8;
        int circle = 0;
        int step = 0;
        while(end < test) {
            circle++;
            end += range * circle;
        }
        while(circle > 0) {
            System.out.println("step: " + step + "circle: " + circle + "test: " + test);
            if (test % 2 == 0) {
                step++;
                circle--;
            } else {
                int value_temp = test;
                int circle_temp = circle;
                circle_temp--;
                if(circle_temp == 0) {
                    step += 2;
                    circle--;
                } else {
                    value_temp -= circle_temp * range;
                    if((value_temp % (2 * circle)) == 0) {
                        step += 2;
                        circle--;
                    } else {
                        step++;
                        circle--;
                    }
                }
            }
        }
        System.out.println(step);
    }
}
