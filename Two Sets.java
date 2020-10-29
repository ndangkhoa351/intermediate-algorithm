import java.io.*;
import java.util.*;

public class Solution_AC {
    static int[] par;
    static int find(int u) {
        if (u != par[u]) {
            par[u] = find(par[u]);
        }
        return par[u];
    }
    static void union(int u, int v) {
        u = find(u);
        v = find(v);
        par[u] = v;
    }
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        int[] p = new int[n];
        par = new int[n + 2];
        for (int i = 0; i <= n + 1; ++i) {
            par[i] = i;
        }
        Map<Integer, Integer> mp = new TreeMap<>();
        for (int i = 0; i < n; ++i) {
            p[i] = sc.nextInt();
            mp.put(p[i], i + 1);
        }

        for (int i = 0; i < n; ++i) {
            union(i + 1, mp.containsKey(a - p[i]) ? mp.get(a - p[i]) : n + 1);
            union(i + 1, mp.containsKey(b - p[i]) ? mp.get(b - p[i]) : 0);
        }

        int A = find(0), B = find(n + 1);
        if (A != B) {
            System.out.println("YES");
            for (int i = 1; i <= n; ++i) {
                System.out.print(find(i) == A ? "0 " : "1 ");
            }
        }
        else {
            System.out.print("NO");
        }
	}
}
//O(n∗log(n))
