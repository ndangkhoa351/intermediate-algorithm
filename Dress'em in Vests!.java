import java.util.Scanner;
import java.util.ArrayList;

public class Main {
   static class Vest {
      int u, v;

      public Vest(int x , int y) {
         u = x;
         v = y; 
      }
   }

   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in); 
      int n = sc.nextInt(); 
      int m = sc.nextInt(); 
      int x = sc.nextInt(); 
      int y = sc.nextInt(); 

      ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>();

      for (int i = 0; i < n; i++) {
         a.add(sc.nextInt());
      }

      for (int i = 0; i < m; i++) {
         b.add(sc.nextInt()); 
      }

      ArrayList<Vest> v = new ArrayList<>();  

      int i = 0, j = 0;
      while (i < n && j < m) {
         if (a.get(i) - x <= b.get(j) && b.get(j) <= a.get(i) + y) {
            v.add(new Vest(i + 1, j + 1));
            i++;
            j++;
         }
         else if (a.get(i) + y < b.get(j)) {
            i++;
         }
         else if (a.get(i) - x > b.get(j)) {
            j++;
         }
      }

      System.out.println(v.size()); 

      for (Vest vest : v) {
         System.out.println(vest.u + " " + vest.v);
      }
   }
}
//O(max(n, m))
