import java.util.Scanner;
import java.util.Stack;
 
public class Main {
    static final int MAX = 1005;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] trucks = new int[MAX];
        Stack<Integer> side_trucks = new Stack<>();
         
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
 
            for (int i = 0; i < n; i++) {
                trucks[i] = sc.nextInt();
            }
 
            int ordering = 1;
            int i = 0;
 
            while (i < n) {
                if (trucks[i] == ordering) {
                    ordering++;
                    i++;
                }
                else if (!side_trucks.empty() && side_trucks.peek().equals(ordering)) {
                    ordering++;
                    side_trucks.pop();
                }
                else {
                    side_trucks.push(trucks[i]);
                    i++;
                }
            }
 
            while (!side_trucks.empty() && side_trucks.peek().equals(ordering)) {
                ordering++;
                side_trucks.pop();
            }
 
            System.out.println(ordering == n + 1 ? "yes" : "no");
            side_trucks.clear();
        }
    }
}
//O(T∗N)
