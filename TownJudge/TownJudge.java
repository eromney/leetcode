/* 997. Find the town Judge - Easy - https://leetcode.com/problems/find-the-town-judge/
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 * If the town judge exists, then: The town judge trusts nobody. Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2. You are given an array trust where 
 * trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. 
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 */

import java.io.*;
import java.util.*;

public class TownJudge {
  public static void main (String[] args) {
    int[][] test1 = { {1, 2 }  };
    int n1 = 2;
    System.out.println(findJudge(n1, test1));
    int[][] test2 = {{1,3}, {2,3}};
    int n2 = 3;
    System.out.println(findJudge(n2, test2));
  }

  private static int findJudge (int n, int[][] trust) {
    HashSet<Integer> trusts = new HashSet<Integer>();
    int[] nArr = new int[n + 1];
    for (int[] arr : trust) {
      if (!trusts.contains(arr[0])) trusts.add(arr[0]);
      nArr[arr[1]]++;
    }
    for (int i = 1; i <= n; i++) {
      if (nArr[i] == n - 1 && !trusts.contains(i)) return i;
    }
    // no judge return -2
    return -1;
  }


}
