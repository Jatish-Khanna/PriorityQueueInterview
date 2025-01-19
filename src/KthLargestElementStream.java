import java.util.PriorityQueue;

/**
 * Time Complexity:
 * add(): O(log K) for adding an element to the min-heap and maintaining the size.
 * getKthLargest(): O(1) since the root of the min-heap is the K-th largest element.
 */
public class KthLargestElementStream {

  KthLargestElementStream(int size) {
    this.size = size;
  }

  PriorityQueue<Integer> stream = new PriorityQueue<>();
  int size = 0;

  // O(1) from the PQ peek
  private Integer getKthLargest() {
    return stream.isEmpty() || stream.size() < size ? -1 : stream.peek();
  }

  // Log n for each add operation
  private void add(int data) {
    if (stream.size() < size) {
      stream.offer(data);
    } else if (!stream.isEmpty() && stream.peek() < data) {
      stream.poll();
      stream.offer(data);
    }
  }

  public static void main(String[] args) {
    KthLargestElementStream stream = new KthLargestElementStream(3);

    System.out.println("Adding 4 to the stream");
    stream.add(4);
    System.out.println("The 3rd largest element: " + stream.getKthLargest());

    System.out.println("Adding 5 to the stream");
    stream.add(5);
    System.out.println("The 3rd largest element: " + stream.getKthLargest());

    System.out.println("Adding 8 to the stream");
    stream.add(8);
    System.out.println("The 3rd largest element: " + stream.getKthLargest());

    System.out.println("Adding 1 to the stream");
    stream.add(1);
    System.out.println("The 3rd largest element: " + stream.getKthLargest());

    System.out.println("Adding 3 to the stream");
    stream.add(3);
    System.out.println("The 3rd largest element: " + stream.getKthLargest());
  }


}
