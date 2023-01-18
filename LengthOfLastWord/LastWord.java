/* Easy - https://leetcode.com/problems/length-of-last-word/
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
*/
import java.io.*;
import java.util.*;
public class LastWord {
  public static void main (String[] args) {
    BufferedReader br;
    File file = new File("input.txt");
    try {
      br = new BufferedReader(new FileReader(file));
      String s;
      while ((s = br.readLine()) != null) {
        System.out.println(lengthOfLastWord(s));   
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    finally {
      // do stuff
    }
  }

  public static int lengthOfLastWord (String s) {
    String[] arr = s.split(" ");
    int i = arr.length - 1;
    while (arr[i].equals(" ") && i > 0) {
      i--;
    }
    return arr[i].length();
  }

}
