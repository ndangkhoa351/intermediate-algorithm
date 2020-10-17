import java.util.Scanner;
import java.util.ArrayList;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int na = sc.nextInt();
        int nb = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
 
        ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>();
         
        for (int i = 0; i < na; i++) 
            a.add(sc.nextInt());
             
        for (int i = 0; i < nb; i++)
            b.add(sc.nextInt());
         
        System.out.print(a.get(k - 1) < b.get(nb - m) ? "YES" : "NO");
    } 
}
//O(n)
