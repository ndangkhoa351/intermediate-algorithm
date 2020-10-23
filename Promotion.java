import java.util.*;

public class Solution {
    static final int MAX = (int)1e6 + 5;

    static class Bill {
        int number, price;

        public Bill(int _number, int _price) {
            this.number = _number;
            this.price = _price;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] taken = new boolean[MAX];
        int n = sc.nextInt();
        int nbills = 0;
        long money = 0;

        PriorityQueue<Bill> maxHeap = new PriorityQueue<>(new Comparator<Bill>() {
            public int compare(Bill a, Bill b) {
                return b.price - a.price;
            }
        });

        PriorityQueue<Bill> minHeap = new PriorityQueue<>(new Comparator<Bill>() {
            public int compare(Bill a, Bill b) {
                return a.price - b.price;
            }
        });

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                nbills++;

                maxHeap.add(new Bill(nbills, x));
                minHeap.add(new Bill(nbills, x));
            }

            while (taken[maxHeap.peek().number]) {
                maxHeap.remove();
            }

            while (taken[minHeap.peek().number]) {
                minHeap.remove();
            }
            
            taken[maxHeap.peek().number] = taken[minHeap.peek().number] = true;
            money += maxHeap.poll().price - minHeap.poll().price;
        }

        System.out.print(money);
    }
}
//O(N∗log(N))
