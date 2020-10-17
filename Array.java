import java.util.Scanner;
import java.util.ArrayList;
 
public class Main {
    static final int MAX = (int)1e5 + 5;
    static int fre[] = new int[MAX];
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
         
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
         
        int unique = 0;
        int j = 0;
 
        for (int i = 0; i < n; i++) {
            if (fre[a.get(i)] == 0) {
                unique++;
            }
 
            fre[a.get(i)]++;
             
            while (unique == k) {
                fre[a.get(j)]--;
 
                if (fre[a.get(j)] == 0) {
                    System.out.printf("%d %d", j + 1, i + 1); 
                    return;
                }
 
                j++;
            }
        }
 
        System.out.print("-1 -1");
    }
}
//O(N)
