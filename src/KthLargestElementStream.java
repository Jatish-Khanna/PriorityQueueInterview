import java.util.PriorityQueue;

public class KthLargestElementStream {

  KthLargestElementStream(int size) {
    this.size = size;
  }

  PriorityQueue<Integer> stream = new PriorityQueue<>();
  int size = 0;

  private Integer getKthLargest() {
    return stream.isEmpty() || stream.size() < size ? -1 : stream.peek();
  }

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
