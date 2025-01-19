public class MergeKSortedList {

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
