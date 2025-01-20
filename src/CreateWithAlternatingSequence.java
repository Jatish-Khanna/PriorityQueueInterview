public class CreateWithAlternatingSequence {




  public static void main(String[] args) {
    String s = "aaabbc";
    String result = reorganizeString(s);

    if (result.isEmpty()) {
      System.out.println("Not possible to reorganize");
    } else {
      System.out.println("Reorganized String: " + result);
    }
  }
}
