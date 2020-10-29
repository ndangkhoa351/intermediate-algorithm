import java.util.*;
import java.io.*;


public class Main
{ 
    static PrintWriter out;
    final static int MAX =  10005;
    static int N;
    static int []path = new int[MAX];
    static int []dist = new int[MAX];
    static boolean[] visited = new boolean[MAX];
    static ArrayList<Pair<Integer,Integer> > graph[];

    public static void main(String[] args) {
        MyScanner in = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int M,u,v,w;
        
        N = in.nextInt();
        M = in.nextInt();
        graph = new ArrayList[MAX];
        
        
        // initialize variable
        for(int i = 0 ; i < MAX ; i++){
            graph[i] = new ArrayList<>();
            path[i] = -1;
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        int s = 0;
        for (int i = 0; i<M; i++)
    	{
            u = in.nextInt();
            v = in.nextInt();
            w = in.nextInt();
            s = u-1;
            graph[u-1].add(new Pair(v-1, w));
            graph[v-1].add(new Pair(u-1, w));
    	}
        Prim(s);
        PrintMST();
    }
    
    
    static void Prim(int source){
        PriorityQueue< Pair<Integer,Integer> > pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>(){
            public int compare(Pair<Integer,Integer> a, Pair<Integer,Integer> b){
                return a.getFirst() - b.getFirst();
            }
        });
        pq.add(new Pair(0,source));
        dist[source] = 0;

    	while(!pq.isEmpty())
    	{
            int node = pq.peek().getSecond();
            int d = pq.peek().getFirst();
            pq.remove();
            visited[node]= true;
            for(int i=0; i<graph[node].size(); ++i)
            {
                Pair<Integer,Integer> neighbor = graph[node].get(i);
                if(!visited[neighbor.first] && neighbor.second < dist[neighbor.first])
                {
                    dist[neighbor.first] = neighbor.second;
                    pq.add(new Pair(dist[neighbor.first],neighbor.first));
                    path[neighbor.first] = node;
                }
            }
    	}
        
    }
    
    static void PrintMST()
    {
        long ans = 0;
        for (int i = 0; i<N; i++)
        {
            if (path[i] == -1)
                continue;
            ans += dist[i];
            //cout << path[i] << " - " << i << ": " << dist[i]<<endl;	
        }
        System.out.print(ans);
        //cout<<"Weight of MST: "<<ans<<endl;
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
//O(MlogN)
