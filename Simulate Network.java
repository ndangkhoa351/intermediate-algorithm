import java.util.*;

class Main {
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    static boolean[] visited;
    
    public static void prim(int src) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(src, 0));
        dist[src] = 0; 
        while (!pq.isEmpty()) {
            Node top = pq.poll();
            int u = top.id;
            visited[u] = true;
            for (int i = 0; i < graph.get(u).size(); i++) {
                Node neighbor = graph.get(u).get(i);
                int v = neighbor.id, w = neighbor.dist;
                if (!visited[v] && w < dist[v]) {
                    dist[v] = w;
                    pq.add(new Node(v, w));
                }
            }
        }
    } 
    
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        graph = new ArrayList<ArrayList<Node>>();
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }
        prim(1);
        PriorityQueue<Integer> mstCable = 
            new PriorityQueue<Integer>(new MaxHeapComparator());
        for (int i = 2; i <= n; i++) {
            mstCable.add(dist[i]); // add all edges in mst to max heap
        }
        int q = in.nextInt();
        PriorityQueue<Integer> newCables = new PriorityQueue<Integer>();
        for (int i = 0; i < q; i++) {
            int x = in.nextInt();
            newCables.add(x);
        }
        long res = 0;
        while (!mstCable.isEmpty()) {
            int usedCable = mstCable.poll();
            if (!newCables.isEmpty() && newCables.peek() < usedCable)
                usedCable = newCables.poll(); // replace old cable by new cable
            res += usedCable;
        }
        System.out.print(res);
    }
}

class Node implements Comparable<Node> {
    public Integer id;
    public Integer dist;
    public Node(Integer id, Integer dist) {
        this.id = id;
        this.dist = dist;
    }
    @Override
    public int compareTo(Node other) {
        return this.dist.compareTo(other.dist);
    }
} 

class MaxHeapComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}
//O(MlogN+NlogN+QlogQ) 
