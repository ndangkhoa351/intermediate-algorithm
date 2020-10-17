import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> chocolate = new ArrayList<>();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            chocolate.add(sc.nextInt());
        }

        int t_alice = 0, t_bob = 0;
        int i = 0, j = n - 1;

        while (i <= j) {
            if (t_alice + chocolate.get(i) <= t_bob + chocolate.get(j)) {
                t_alice += chocolate.get(i);
                i++;
            }
            else {
                t_bob += chocolate.get(j);
                j--;
            }
        }

        System.out.print(i + " " + (n - i));
    }
}
//O(n)
