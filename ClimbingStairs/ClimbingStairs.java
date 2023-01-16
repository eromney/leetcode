/* You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways 
 * can you climb to the top?
 *
 */
import java.io.*;
import java.util.*;

public class ClimbingStairs {
    
    public static void main (String[] args) {
        BufferedReader br = null;
        File input = new File("test.txt");
        try {
            br = new BufferedReader(new FileReader(input));
            String l;
            while ((l = br.readLine()) != null) {
                int n = Integer.parseInt(l);
                System.out.println(climbStairs(n));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // do something
        }
    }

    public static int climbStairs (int n) {
        // edge cases first
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }



}
