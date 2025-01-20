import java.util.Comparator;
import java.util.PriorityQueue;

public class CreateWithAlternatingSequence {


  private static String reorganizeString(String s) {
    if (s == null) {
      return "";
    }
    char[] freq = new char[26];
    for (char data : s.toCharArray()) {
      freq[data - 'a']++;
    }

    PriorityQueue<int[]> order = new PriorityQueue<>(Comparator.comparing(d -> -d[1]));
    for (int index = 0; index < freq.length; index++) {
      if (freq[index] > 0) {
        order.offer(new int[]{index, freq[index]});
      }
    }

    StringBuilder sb = new StringBuilder();
    int[] prev = null;
    int[] current;
    while (!order.isEmpty()) {
      current = order.poll();
      sb.append((char)(current[0] + 'a'));
      --current[1]; // update the freq

      if (prev != null && prev[1] > 0) {
        order.offer(prev);
      }
      prev = current;
    }

    return sb.length() == s.length() ? sb.toString() : "";
  }

  public static void main(String[] args) {
    String s = "aaabbc";
    String result = reorganizeString(s);

    if (result.isEmpty()) {
      System.out.println("Not possible to reorganize");
    } else {
      System.out.println("Reorganized String: " + result);
    }


    System.out.println("Reorganized String: " + reorganizeString("aaaaa"));
    System.out.println("Reorganized String: " + reorganizeString("asdfhlycajnkaweisrjfak"));


  }
}
