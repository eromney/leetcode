/* N-Queens problem on leetcode
 * strategy: use back tracking to calculate all posible combinations
 * to reduce the runtime, can keep track of the columns used and
 * eliminate those from possability
 * https://leetcode.com/problems/n-queens/
 */

import java.io.*;
import java.util.*;

public class queens {

  private static List<List<String>> res = new ArrayList<List<String>>();

  public static void main (String[] args) {
    BufferedReader br = null;
    File input = new File("input.txt");
    String l = null;
    try {
      br = new BufferedReader(new FileReader(input));
      while ((l = br.readLine()) != null) {
        int n = Integer.parseInt(l);
        List<List<String>> tmp = solveNQueens(n);
        System.out.println("number of unique combos found: " + tmp.size() + " for number n: " + n);
        tmp.clear();
      }
    } catch(IOException e) {
        e.printStackTrace();
    } finally {
        // do work
    }
  }

  public static List<List<String>> solveNQueens(int n) {
    HashSet<Integer> col = new HashSet<Integer>();
    HashSet<Integer> posDiag = new HashSet<Integer>();
    HashSet<Integer> negDiag = new HashSet<Integer>();
    List<String> list = new ArrayList();

    backTrack(list, n, 0, col, posDiag, negDiag);
    return res;

  }
  public static void backTrack(List<String> cur, int n, int row, HashSet<Integer> col, HashSet<Integer> posDiag, HashSet<Integer> negDiag) {
    if (row == n) {
      res.add(cur);
      System.out.println("Adding to res: " + cur);
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (!col.contains(i) && !posDiag.contains(row+i) && !negDiag.contains(row-i)) {
        col.add(i);
        posDiag.add(row + i);
        negDiag.add(row - i);
        String s = sb.toString();
        s += "Q";
        for (int tmp = i+1; tmp < n; tmp++) s += ".";
        cur.add(s);
        
        backTrack(cur, n, row+1, col, posDiag, negDiag);
    
        cur.remove(s);
        col.remove(i);
        posDiag.remove(row+i);
        negDiag.remove(row-i);
      }
      sb.append('.');
    }
    return;
  }

 }
  
/* 
 * Negative  diagnoals will go from [-n,n] depending on the diagnoal and can be calculated by r-c
 * Positive diagonals will go from [0, 2n] depending on the diagonal and can be calculated by r+c
*/

