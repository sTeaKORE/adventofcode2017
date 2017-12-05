import java.util.Arrays;

public class advent_of_code_03 {

    public static void main(String[] args) {
        int toBeSearched = 347991;
        int size = 1000;
        int[][] spiral = new int[size][size];
        for(int[] row : spiral)
            Arrays.fill(row,0);

        int x = (size/2) - 1;
        int y = (size/2) - 1;
        int sum = size * size;
        sum *= 0.8;
        int val = 1;
        int direction = 1;
        spiral[y][x] = val;
        x++;
        val++;
        for(int i = 0; i < sum;i++) {
            spiral[y][x] = val;
            if(val == toBeSearched) {
                System.out.println("got it");
                break;
            }
            val++;
            if(direction == 1) {
                if (spiral[y][x - 1] == 0) {
                    direction = 2;
                    x--;
                } else {
                    y--;
                }
            }
            else if(direction == 2) {
                if (spiral[y + 1][x] == 0) {
                    direction = 3;
                    y++;
                } else {
                    x--;
                }
            }
            else if(direction == 3) {
                if (spiral[y][x + 1] == 0) {
                    direction = 4;
                    x++;
                } else {
                    y++;
                }
            }
            else if(direction == 4) {
                if (spiral[y - 1][x] == 0) {
                    direction = 1;
                    y--;
                } else {
                    x++;
                }
            }
        }

        displayArray(spiral,size);

        int steps = 0;
        boolean found = false;
        while(!found) {
            if(spiral[y][x] == 1) {
                found = true;
                break;
            }
            int temp_newVal = -1;
            int temp_x = -1;
            int temp_y = -1;
            if (spiral[y-1][x] != 0) {
                if(temp_newVal == -1) {
                    temp_newVal = spiral[y-1][x];
                    temp_x = x;
                    temp_y = y - 1;
                } else {
                    if(spiral[y-1][x] < temp_newVal) {
                        temp_newVal = spiral[y-1][x];
                        temp_x = x;
                        temp_y = y - 1;
                    }
                }
            }
            if (spiral[y+1][x] != 0) {
                if(temp_newVal == -1) {
                    temp_newVal = spiral[y+1][x];
                    temp_x = x;
                    temp_y = y + 1;
                } else {
                    if(spiral[y+1][x] < temp_newVal) {
                        temp_newVal = spiral[y+1][x];
                        temp_x = x;
                        temp_y = y + 1;
                    }
                }
            }
            if (spiral[y][x+1] != 0) {
                if(temp_newVal == -1) {
                    temp_newVal = spiral[y][x+1];
                    temp_x = x + 1;
                    temp_y = y;
                } else {
                    if(spiral[y][x+1] < temp_newVal) {
                        temp_newVal = spiral[y][x+1];
                        temp_x = x + 1;
                        temp_y = y;
                    }
                }
            }
            if (spiral[y][x-1] != 0) {
                if(temp_newVal == -1) {
                    temp_newVal = spiral[y][x-1];
                    temp_x = x - 1;
                    temp_y = y;
                } else {
                    if(spiral[y][x-1] < temp_newVal) {
                        temp_newVal = spiral[y][x-1];
                        temp_x = x - 1;
                        temp_y = y;
                    }
                }
            }
            System.out.println(temp_newVal);
            x = temp_x;
            y = temp_y;
            steps++;
        }
        System.out.println(steps);
        /*int end = 1;
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
        System.out.println(step);*/
    }

    private static void displayArray(int[][] spiral,int size) {
        for(int i = 0; i < size; i++) {
            boolean printed = false;
            for(int j = 0; j < size; j++) {
                if(spiral[i][j] != 0) {
                    System.out.print(spiral[i][j]);
                    printed = true;
                }
            }
            if(printed) {
                System.out.print("\n");
            }
        }
        System.out.println("---------------------");
    }
}
