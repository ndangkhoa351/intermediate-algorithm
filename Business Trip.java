import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            a.add(sc.nextInt());
        }

        Collections.sort(a, Collections.reverseOrder());
        int n_months = 0;
        
        for (int height : a) {
            if (k <= 0) {
                break;
            }

            n_months++;
            k -= height;
        }

        System.out.print(k <= 0 ? n_months : -1);
    }
}
//O(NlogN)
