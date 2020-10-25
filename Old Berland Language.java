import java.io.*;
import java.util.*;

public class Main {

  static class Pair implements Comparable<Pair> {
    public Integer first;
    public Integer second;
    public Pair(Integer first, Integer second) {
      this.first = first;
      this.second = second;
    }
    @Override
    public int compareTo(Pair other) {
      return this.first.compareTo(other.first);
    }
  }

  static class Node {
    public int isBlock = 0;
    public Node[] child;
    public Node pre;
    public Node() {
      this.isBlock = 0;
      this.pre = null;
      this.child = new Node[2];
      Arrays.fill(child, null);
    }
  }

  private static int maxn = 1000001;
  private static int MAX = 2;
  private static String[] ans = new String[10001];
  private static String s;

  private static Node root = new Node();

  private static boolean add(int l) {
    Node temp = root;
    if (root.isBlock == 1)
      return false;
    s = "";
    for (int i = 0; i < l; i++) {
      int check_l = -1;
      boolean canmove = false;
      for (int j = MAX - 1; j >= 0; j--) {
        if (temp.child[j] != null) {
          if (temp.child[j].isBlock == 0) {
            s = s + (char) ('0' + j);
            temp = temp.child[j];
            canmove = true;
            break;
          }
        }
        if (temp.child[j] == null)
          check_l = j;
      }

      if (!canmove) {
        if (check_l == -1)
          return false;
        else {
          s = s + (char) ('0' + check_l);
          temp.child[check_l] = new Node();
          temp.child[check_l].pre = temp;
          temp = temp.child[check_l];
        }
      }
    }

    temp.isBlock = 1;

    while (temp != null) {
      if (temp.child[0] != null && temp.child[1] != null)
        if (temp.child[0].isBlock * temp.child[1].isBlock == 1)
          temp.isBlock = 1;
      temp = temp.pre;
    }

    return true;

  }

  public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      Pair[] a = new Pair[n + 1];
      for (int i = 0; i < n; i++) {
        int l = sc.nextInt();
        a[i] = new Pair(l, i);
      }

      Arrays.sort(a, 0, n);

      for (int i = 0; i < n; i++) {
        int l = a[i].first;
        if (add(l) == false) {
          System.out.println("NO");
          return;
        }
        else
          ans[a[i].second] = s;
      }

      System.out.println("YES");
      for (int i = 0; i < n; i++)
        System.out.println(ans[i]);

      sc.close();

  }

}
//O(N⋅L)
