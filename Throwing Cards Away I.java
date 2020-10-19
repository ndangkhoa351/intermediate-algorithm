import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
 
public class Main {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> deck = new LinkedList<>();
        ArrayList<Integer> discarded_cards = new ArrayList<>();
         
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
 
            for (int i = 1; i <= n; i++) {
                deck.add(i);
            }
 
            while (deck.size() >= 2) {
                discarded_cards.add(deck.poll());
                deck.add(deck.poll());
            }
 
            System.out.print("Discarded cards:");
            for (int i = 0; i < n - 1; i++) {
                if (i != 0) {
                    System.out.print(",");
                }
                System.out.format(" %d", discarded_cards.get(i));
            }
            System.out.println();
            System.out.format("Remaining card: %d\n", deck.poll());
 
            discarded_cards.clear();
        }
    }
}
//O(T∗N)
