/**
 * Complexity:
 * Time Complexity:
 * Each merge operation takes linear time, i.e.,
 * O(n) where n is the total number of elements across all lists.
 * The number of merge operations is O(log k) where k is
 * the number of input lists. Hence, the total time complexity is O(n log k).
 * <p>
 * Space Complexity:
 * The space complexity is O(k) due to recursion stack
 * in mergeSort and additional space used by the merged list.
 */

public class MergeKSortedList {

  static class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
      this.data = data;
      this.next = null;
    }

    public String toString() {
      return String.valueOf(data);
    }
  }


  private static void printList(ListNode mergedList) {
    while (mergedList != null) {
      System.out.print(mergedList.data + "->");
      mergedList = mergedList.next;
    }
  }

  private static ListNode createList(int[] ints) {
    ListNode head = new ListNode(0);
    ListNode current = head;
    for (int data : ints) {
      current.next = new ListNode(data);
      current = current.next;
    }
    return head.next;
  }

  private static ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 1) {
      return lists[0];
    }
    return mergeSort(lists, 0, lists.length - 1);
  }

  private static ListNode mergeSort(ListNode[] lists, int start, int end) {
    if (start == end) {
      return lists[start];
    } else if (start + 1 == end) {
      return mergeLists(lists[start], lists[end]);
    }
    int mid = start + (end - start) / 2;
    ListNode firstHalf = mergeSort(lists, start, mid);
    ListNode secondHalf = mergeSort(lists, mid + 1, end);
    return mergeLists(firstHalf, secondHalf);
  }

  private static ListNode mergeLists(ListNode firstHalf, ListNode secondHalf) {
    ListNode mergedList = new ListNode(0);
    ListNode current = mergedList;

    while (firstHalf != null && secondHalf != null) {
      if (firstHalf.data <= secondHalf.data) {
        current.next = firstHalf;
        firstHalf = firstHalf.next;
      } else {
        current.next = secondHalf;
        secondHalf = secondHalf.next;
      }
      current = current.next;
    }

    if (firstHalf != null) {
      current.next = firstHalf;
    } else if (secondHalf != null) {
      current.next = secondHalf;
    }

    return mergedList.next;
  }

  public static void main(String[] args) {
    // Creating k sorted lists
    ListNode list1 = createList(new int[]{1, 4, 5});
    ListNode list2 = createList(new int[]{1, 3, 4});
    ListNode list3 = createList(new int[]{2, 6});

    // Put all lists into an array
    ListNode[] lists = {list1, list2, list3};

    // Merge the k sorted lists
    ListNode mergedList = mergeKLists(lists);

    // Print the merged sorted list
    System.out.println("Merged Sorted List:");
    printList(mergedList);
  }
}
