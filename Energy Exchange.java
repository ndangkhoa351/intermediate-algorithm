import java.util.*;
import java.io.*;


public class Main
{ 
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
    static MyScanner in = new MyScanner();
    static final int MAX = 10000;
    static final int MAX_A = 1000;
    static int n, k;
    static int A[] = new int[MAX];
    static double sumEnergy, sumTransfer, _left, _right, mid;
    

    public static void main(String[] args) {
        n = in.nextInt();
        k = in.nextInt();
        sumEnergy = 0;
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
            sumEnergy += A[i];
        }

        _left = 0;
        _right = MAX_A;
        while (_right - _left > 1e-7) {
            mid =(_left + _right) / 2;
            sumTransfer = 0;
            for (int i = 0; i < n; i++) {
                if (A[i] > mid)
                    sumTransfer += A[i] - mid;
            }
            if (mid * n < sumEnergy - sumTransfer*k/100) {
                    _left = mid;
            }
            else {
                    _right = mid;
            }
        }
        out.printf("%.9f", _left);
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
//O(N∗log(10^7))
