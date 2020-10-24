import java.util.*;
import java.io.*;

public class Solution {
    static final int MAX = 35;
    static int N, M;
    static ArrayList<String> currencies = new ArrayList<>();
    static double[][] dist = new double[MAX][MAX];

    public static void FloydWarshall() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.max(dist[i][j], dist[i][k] * dist[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        MyScanner in = new MyScanner();
        int t = 1;

        while (true) {
            N = in.nextInt();
            if (N == 0) {
                break;
            }

            currencies.clear();
            for (int i = 0; i < N; i++) {
                currencies.add(in.next());
                for (int j = 0; j < N; j++) {
                    dist[i][j] = (i == j ? 1 : 0);
                }
            }

            M = in.nextInt();
            for (int i = 0; i < M; i++) {
                String sourceCur = in.next();
                double rate = in.nextDouble();
                String desCur = in.next();
                int u = currencies.indexOf(sourceCur);
                int v = currencies.indexOf(desCur);
                dist[u][v] = rate;
            }

            FloydWarshall();

            boolean arbitrage = false;
            for (int i = 0; i < N; i++) {
                if (dist[i][i] > 1) {
                    arbitrage = true;
                    break;
                }
            }

            System.out.print("Case " + t++ + ": ");
            System.out.println(arbitrage ? "Yes" : "No");
        }
    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
                br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
                while (st == null || !st.hasMoreElements()) {
                        try {
                                st = new StringTokenizer(br.readLine());
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
                return st.nextToken();
        }
        int nextInt() {
                return Integer.parseInt(next());
        }
        long nextLong() {
                return Long.parseLong(next());
        }
        double nextDouble() {
                return Double.parseDouble(next());
        }
        String nextLine() {
                String str = "";
                try {
                        str = br.readLine();
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return str;
        }
    }
}
//O(T∗N^3)
