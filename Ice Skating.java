import java.io.*;
import java.util.*;

public class Main {
    public static class DSU { // chỉ được để 1 class
        Integer[] parent;
        public DSU(int size) {
            parent = new Integer[size];
            for (int i = 0; i < size; i++)
                parent[i] = i;
        }
        public int find(int u) {
            if (u == parent[u])
                return u;
            return parent[u] = find(parent[u]);
        }
        public void union(int u, int v) {
            u = find(u);
            v = find(v);
            parent[v] = u;
        }
        public int count() {
            int res = 0;
            for (int i = 0; i < parent.length; i++)
                if (i == parent[i])
                    res++;
            return res;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                if (x[i] == x[j] || y[i] == y[j])
                    dsu.union(i, j);
        System.out.println(dsu.count() - 1);
    }
}
//O(N∗M)
