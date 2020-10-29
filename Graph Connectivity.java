import java.io.*;
import java.util.*;

class DSU {
    Integer[] parent;
    public DSU(int size) {
        parent = new Integer[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
    }
    public int find(int u) {
        while (u != parent[u])
            u = parent[u];
        return u;
    }
    public void union(int u, int v) {
        u = find(u);
        v = find(v);
        parent[v] = u;
    }
}
class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        sc.nextLine();
        while (T-- > 0) {
            int n = sc.nextLine().charAt(0) - 'A' + 1;
            DSU dsu = new DSU(n);
            int ans = n;
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                if (s.isEmpty())
                    break;
                int u = dsu.find(s.charAt(0) - 'A');
                int v = dsu.find(s.charAt(1) - 'A');
                if (u != v) {
                    ans--;
                    dsu.union(u, v);
                }
            }
            System.out.println(ans);
            if (T > 0)
                System.out.println();
        }
    }
}
//O(T∗N∗M)
