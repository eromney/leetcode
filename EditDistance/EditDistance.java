/*
 * https://leetcode.com/problems/edit-distance/ - Hard
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * You have the following three operations permitted on a word:
 *  Insert a character
 *  Delete a character
 *  Replace a character
*/
import java.io.*;
import java.util.*;
import java.util.Arrays;

public class EditDistance {

  public static void main (String [] args) {
    BufferedReader br;
    File input = new File("input.txt");
    try {
      br = new BufferedReader(new FileReader(input));
      String s;
      while ((s = br.readLine()) != null) {
        String[] arr = s.split(",");
        System.out.println(minDistance(arr[0], arr[1]));
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      // do work
    }
  }

  public static int minDistance(String word1, String word2) {
    int[][] cache = new int[word1.length() + 1][word2.length() + 1];
    for (int [] arr : cache) Arrays.fill(arr, -1);
    return dfs(word1.length(), word2.length(), word1, word2, cache);

     
  }

  public static int dfs (int i, int j, String word1, String  word2, int[][] cache) {
    if (j == 0) return i;
    if (i == 0) return j;
    if (cache[i][j] != -1) return cache[i][j];
    if (word1.charAt(i - 1) == word2.charAt(j - 1)) return cache[i][j] = dfs(i - 1, j - 1, word1, word2, cache);
    return cache[i][j] = 1 + Math.min(dfs(i - 1, j - 1, word1, word2, cache), Math.min(dfs(i, j - 1, word1, word2, cache), dfs(i - 1, j, word1, word2, cache)));

  }


 
} 

/* Basic Strategy
 * Break down into two smaller problems where each character represents unit
 * there are three options (where word1 index is i and word2 index is j):
 * 1) insert (i, j - 1)
 * 2) delete (i - 1, j)
 * 3) replace (i - 1, j - 1)
*/ 
