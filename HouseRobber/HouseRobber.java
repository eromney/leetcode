/* 198. House Robber - Medium
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount 
 * of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses 
 * have security systems connected and it will automatically contact the police if two adjacent houses 
 * were broken into on the same night.  Given an integer array nums representing the amount of money of 
 * each house, return the maximum amount of money you can rob tonight without alerting the police.
*/

import java.io.*;
import java.util.*;

public class HouseRobber {
  static int[] memo;
  public static void main (String[] args) {
    BufferedReader br;
    File input = new File("input.txt");
    try {
      String line;
      br = new BufferedReader(new FileReader(input));
      while ((line = br.readLine()) != null) {
        String[] in = line.split(",");
        int[] nums = new int[in.length];
        for (int i = 0; i < in.length; i++) {
          nums[i] = Integer.parseInt(in[i]);
        }
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        System.out.println("best robbing path to take: " + rob(nums));
      }
  } catch (IOException e) {
    e.printStackTrace();
  } finally {
    // do stuff
  }
 }

  public static int rob (int[] nums) {
    return(rob3(nums.length - 1, nums));
    //return rob2(0, nums);
    //return performRob(nums.length - 1, nums);
  }
  // Add memoization to reduce runtime  
  private static int rob3 (int index, int[] nums) {
    if (index < 0) return 0;
    // check if cache has it
    if (memo[index] != -1) return memo[index];
    int res = Math.max(rob3(index - 1, nums), rob3(index - 2, nums) + nums[index]);
    memo[index] = res;
    return res;
  }

  // This solution gets TLE on Leetcode
  private static int performRob (int index, int[] nums) {
    if (index < 0) return 0;
    return Math.max(performRob(index - 1, nums), performRob(index - 2, nums) + nums[index]);
  }
  private static int rob2 (int index, int[] nums) {
    if (index >= nums.length) return 0;
    return Math.max(rob2(index + 1, nums), rob2(index + 2, nums) + nums[index]);
  }

}
