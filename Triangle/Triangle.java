/* Triangle - DP - Medium - https://leetcode.com/problems/triangle/
 * Given a triangle array, return the minimum path sum from top to bottom.
 * For each step, you may move to an adjacent number of the row below. More formally,
 * if you are on index i on the current row, you may move to either index i or index i + 1 on the next row
*/

import java.util.*;
import java.io.*;

public class Triangle {
  static int[][] memo;
  public static void main (String[] args) {
    BufferedReader br;
    File input = new File("input.txt");
    try {
      br = new BufferedReader(new FileReader(input));
      String line;
      List<List<Integer>> list = new ArrayList();
      while ((line = br.readLine()) != null) {
        // parse
        if (line.length() == 0) {
          // I know there will be too many cols for most of the rows, but didn't want to work with an ArrayList
          memo = new int[list.size()][list.size()];
          for (int[] arr : memo) Arrays.fill(arr, -1);
          System.out.println(minimumTotal(list));
          list.clear();
        } else {
          String[] in = line.split(",");
          List<Integer> l = new ArrayList();
          for (String s: in) l.add(Integer.parseInt(s));
          list.add(l);
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {}
  }

  private static int minimumTotal (List<List<Integer>> triangle) {
    return search2(triangle, 0, 0);
    //return search(triangle, 0, 0);
  }
  // TLE need to memo
  private static int search (List<List<Integer>> triangle, int row, int col) {
    if (row >= triangle.size()) return 0;

   return Math.min(search(triangle, row + 1, col) + triangle.get(row).get(col), search(triangle, row + 1, col + 1) + triangle.get(row).get(col));
  }

  private static int search2 (List<List<Integer>> triangle, int row, int col) {
    if (row >= triangle.size()) return 0; 
    if (memo[row][col] != -1) return memo[row][col];
    int res = Math.min(search2(triangle, row + 1, col) + triangle.get(row).get(col), search2(triangle, row + 1, col + 1) + triangle.get(row).get(col));
    memo[row][col] = res;
    return res;
  }



}
