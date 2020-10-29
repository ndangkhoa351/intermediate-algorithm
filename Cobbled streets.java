import java.util.*;
import java.io.*;


public class Main
{ 
    static PrintWriter out;
    final static int MAX =  10005;
    static int N;
    static int []path = new int[MAX];
    static int []dist = new int[MAX];
    static int []key = new int[MAX];
    static boolean[] visited = new boolean[MAX];
    static ArrayList<Pair<Integer,Integer> > graph[];

    public static void main(String[] args) {
        MyScanner in = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int p,n,m,a,b,c,s;
        int T;
        graph = new ArrayList[MAX];
        // initialize
        for(int i = 0 ; i < MAX ; i++){
            graph[i] = new ArrayList<>();
        }
        T = in.nextInt();
        while(T-->0){
            s = 0;
            // initialize variable
            for(int i = 0 ; i < MAX ; i++){
                graph[i].clear();
                path[i] = -1;
                key[i] = Integer.MAX_VALUE;
                visited[i] = false;
            }
            p = in.nextInt();
            n = in.nextInt();
            m = in.nextInt();
            for (int i = 0; i<m; i++)
            {
                a = in.nextInt();
                b = in.nextInt();
                c = in.nextInt();
                graph[a-1].add(new Pair(b-1, c));
                graph[b-1].add(new Pair(a-1, c));
            }   
            Prim(s);
            long ans = 0;
            for(int i = 0; i < n;i++){
                s = s + key[i];
            }
            out.println(s*p);
        }
    }
    
    
    static void Prim(int source){
        PriorityQueue< Pair<Integer,Integer> > pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>(){
            public int compare(Pair<Integer,Integer> a, Pair<Integer,Integer> b){
                return a.getFirst() - b.getFirst();
            }
        });
        pq.add(new Pair(0,source));
        key[source] = 0;

    	while(!pq.isEmpty())
    	{
            int node = pq.peek().getSecond();
            int d = pq.peek().getFirst();
            pq.remove();
            visited[node]= true;
            for(int i=0; i<graph[node].size(); ++i)
            {
                Pair<Integer,Integer> neighbor = graph[node].get(i);
                if(!visited[neighbor.first] && neighbor.second < key[neighbor.first])
                {
                    key[neighbor.first] = neighbor.second;
                    pq.add(new Pair(key[neighbor.first],neighbor.first));
                    path[neighbor.first] = node;
                }
            }
    	}
        
    }

    
    public static class Pair<F,S>{

        public F getFirst() {
            return first;
        }

        public void setFirst(F first) {
            this.first = first;
        }

        public S getSecond() {
            return second;
        }

        public void setSecond(S second) {
            this.second = second;
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
        public F first;
        public S second;
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
//O(t∗mlogn)
