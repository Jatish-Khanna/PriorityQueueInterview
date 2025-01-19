import java.util.*;

public class KSmallestElements {

  private static List<Integer> findKSmallest(int[] arr, int k) {
    if (k <= 0) {
      return List.of();
    }

    Map<Integer, Integer> dataByFreq = new HashMap<>();
    for (int data : arr) {
      dataByFreq.merge(data, 1, Integer::sum);
    }

    PriorityQueue<int[]> smallest = new PriorityQueue<>(Comparator.comparing((d1) -> -d1[0]));
    for (var dataEntry : dataByFreq.entrySet()) {
      if (smallest.size() < k) {
        smallest.offer(new int[]{dataEntry.getKey(), dataEntry.getValue()});
      } else if (smallest.peek()[0] > dataEntry.getKey()) {
        smallest.poll();
        smallest.offer(new int[]{dataEntry.getKey(), dataEntry.getValue()});
      }
    }
    List<Integer> kSmallest = new ArrayList<>();
    for (int[] element : smallest) {
      kSmallest.add(element[0]);
    }
    return kSmallest.reversed(); // make sure you're reversing as the list is highest first
  }

  public static void main(String[] args) {
    // Example input
    int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
    int K = 4;

    // Finding the K smallest elements
    List<Integer> result = findKSmallest(arr, K);

    // Printing the result
    System.out.println("The " + K + " smallest elements in the array are:");
    System.out.println(result);
  }
}