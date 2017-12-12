import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class advent_of_code_04_p2 {

    public static void main(String[] args) {
        int overallCount = 0;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String temp = in.nextLine();
            List<String> Check = new ArrayList<>();
            String[] count = temp.split(" ");
            for(int i = 0; i < count.length;i++) {
                String toCheck = count[i];
                boolean copy = false;
                for(int j = 0; j < Check.size();j++) {
                    if(areAnagram(toCheck.toCharArray(),Check.get(j).toCharArray())) {
                        copy = true;
                    }
                }
                if(!copy) {
                    Check.add(toCheck);
                }
            }
            if(count.length == Check.size()) {
                overallCount++;
            }
        }
        in.close();
        System.out.println(overallCount);
    }

    /* function to check whether two strings are
  anagram of each other */
    static boolean areAnagram(char[] str1, char[] str2)
    {
        // Get lenghts of both strings
        int n1 = str1.length;
        int n2 = str2.length;

        // If length of both strings is not same,
        // then they cannot be anagram
        if (n1 != n2)
            return false;

        // Sort both strings
        quickSort(str1, 0, n1 - 1);
        quickSort(str2, 0, n2 - 1);

        // Compare sorted strings
        for (int i = 0; i < n1;  i++)
            if (str1[i] != str2[i])
                return false;

        return true;
    }

    // Following functions (exchange and partition
    // are needed for quickSort)
    static void exchange(char A[],int a, int b)
    {
        char temp;
        temp = A[a];
        A[a]   = A[b];
        A[b]   = temp;
    }

    static int partition(char A[], int si, int ei)
    {
        char x = A[ei];
        int i = (si - 1);
        int j;

        for (j = si; j <= ei - 1; j++)
        {
            if(A[j] <= x)
            {
                i++;
                exchange(A, i, j);
            }
        }
        exchange (A, i+1 , ei);
        return (i + 1);
    }

    /* Implementation of Quick Sort
    A[] --> Array to be sorted
    si  --> Starting index
    ei  --> Ending index
    */
    static void quickSort(char A[], int si, int ei)
    {
        int pi;    /* Partitioning index */
        if(si < ei)
        {
            pi = partition(A, si, ei);
            quickSort(A, si, pi - 1);
            quickSort(A, pi + 1, ei);
        }
    }

}
