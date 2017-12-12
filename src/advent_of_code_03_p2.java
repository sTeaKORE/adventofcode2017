import java.util.Arrays;

public class advent_of_code_03_p2 {

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
        for(int i = 0; i < sum;i++) {
            System.out.println(i + ".Runde: " + val);
            spiral[y][x] = val;
            if(val > toBeSearched) {
                System.out.println("got it");
                break;
            }

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
            val = 0;
            if(spiral[y-1][x-1] != 0) {
                val += spiral[y-1][x-1];
                System.out.println("added " + spiral[y-1][x-1]);
            }
            if(spiral[y-1][x] != 0) {
                val += spiral[y-1][x];
                System.out.println("added " + spiral[y-1][x]);
            }
            if(spiral[y-1][x+1] != 0) {
                val += spiral[y-1][x+1];
                System.out.println("added " + spiral[y-1][x+1]);
            }
            if(spiral[y][x-1] != 0) {
                val += spiral[y][x-1];
                System.out.println("added " + spiral[y][x-1]);
            }
            if(spiral[y][x+1] != 0) {
                val += spiral[y][x+1];
                System.out.println("added " + spiral[y][x+1]);
            }
            if(spiral[y+1][x-1] != 0) {
                val += spiral[y+1][x-1];
                System.out.println("added " + spiral[y+1][x-1]);
            }
            if(spiral[y+1][x] != 0) {
                val += spiral[y+1][x];
                System.out.println("added " + spiral[y+1][x]);
            }
            if(spiral[y+1][x+1] != 0) {
                val += spiral[y+1][x+1];
                System.out.println("added " + spiral[y+1][x+1]);
            }
        }
        System.out.println(val);
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
