import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      TreeSet<Long> prices = new TreeSet<Long>();
      int n = sc.nextInt();
      long minimum_loss = Long.MAX_VALUE;

      for (int i = 0; i < n; i++) {
         Long sell_price = sc.nextLong();
         if (!prices.isEmpty() && prices.last() > sell_price) {
            long loss = prices.higher(sell_price) - sell_price;
            if (loss < minimum_loss) {
               minimum_loss = loss;
            }
         }
         prices.add(sell_price);
      }

      System.out.print(minimum_loss);
   }
}
//O(N∗logN)
