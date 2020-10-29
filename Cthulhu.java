package main;

import java.util.*;
import java.io.*;


public class Main
{ 
    static PrintWriter out;
    static final int MAX  = 110;
    static int parent[] = new int[MAX];
    static int ranks[] = new int[MAX];
    public static int Findset(int parent[], int i) {
        if(parent[i]!=i){
            return Findset(parent, parent[i]);
        }
        else
            return i;
    }
    public static void Unionset(int parent[], int x, int y)
    {
        int xroot = Findset(parent, x);
        int yroot = Findset(parent, y);

        if (ranks[xroot] < ranks[yroot])
            parent[xroot] = yroot;
        else if (ranks[xroot] > ranks[yroot])
            parent[yroot] = xroot;
        else{
            parent[yroot] = xroot;
            ranks[xroot]++;
        }
    }
    
    public static void main(String[] args) {
        MyScanner in = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int i, j, k, n, m;
        n = in.nextInt();
        m = in.nextInt();
        for(i=0; i<=n; i++)
            parent[i] = i;
        for(i=0; i<m; i++)
        {
            int x, y, f1, f2;
            x = in.nextInt();
            y = in.nextInt();
            f1 = Findset(parent, x);
            f2 = Findset(parent, y);
            Unionset(parent, f1, f2);
        }
        int flag = 1;
        if(m!=n)
            flag = 0;
        for(i=1; i<=n; i++)
        {
            int temp1 = Findset(parent, i);
            int temp2 = Findset(parent, 1);
            if(temp1 != temp2)
                    flag = 0;
        }
        if(flag==1)
                out.printf("FHTAGN!");
        else
                out.printf("NO");
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
//O(N∗M)
//O(M∗logN)
