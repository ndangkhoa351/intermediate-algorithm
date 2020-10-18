import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> ratings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ratings.add(sc.nextInt());
        }

        ArrayList<Integer> sorted_ratings = new ArrayList<>(ratings);
        Collections.sort(sorted_ratings, Collections.reverseOrder());
        int[] ranked = new int[2005];

        for (int i = 0; i < n; i++) {
            int rating = sorted_ratings.get(i);
            if (ranked[rating] == 0) {
                ranked[rating] = i + 1;
            }
        }

        for (int rating : ratings) {
            System.out.print(ranked[rating] + " ");
        }
    }
}
//O(nlogn)
