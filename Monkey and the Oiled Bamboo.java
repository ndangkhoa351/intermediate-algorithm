import java.util.*;
import java.io.*;


public class Main
{ 
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
    static MyScanner in = new MyScanner();
    static final int MAX_N = 100005; 
    static int a[] = new int[MAX_N]; 
    static int n, test;
    

    public static void main(String[] args) {
        test = in.nextInt();

	for (int t = 1; t <= test; t++) {
            out.printf("Case %d: ", t); 
            n = in.nextInt();

            for (int i = 1; i <= n; i++) {
                a[i] = in.nextInt();
            }

            int l = 1; int r = a[n] + 1; 

            int res = 0; 

            while (l <= r) {
                int mid = (l + r) >> 1;
                int k = mid; 

                boolean check = true; 
                for (int i = 1; i <= n; i++) {
                    if (a[i] - a[i - 1] > k) {
                        check = false;
                        break; 	
                    }	
                    else {
                        if (a[i] - a[i - 1] == k) {
                            k--; 
                        }
                    }
                }

                    if (check == true) {
                        res = mid; 
                        r = mid - 1; 
                    }
                    else {
                        l = mid + 1; 
                    }
		}

		out.printf("%d\n", res); 
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
//O(T∗N∗log(diff))
