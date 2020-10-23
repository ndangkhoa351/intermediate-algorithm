import java.util.*;

public class Main {
	static final int MAX = 505;
	static final int INF = (int)1e9 + 7;
	
	static class Node implements Comparable<Node> {
		int id, weight;
		
		public Node(int _id, int _weight) {
			this.id = _id;
			this.weight = _weight;
		}
		
		@Override
		public int compareTo(Node other) {
			return this.weight - other.weight;
		}
	}
	
	static ArrayList<Node> graph[] = new ArrayList[MAX];
	static ArrayList<Node> graphS[] = new ArrayList[MAX];
	static ArrayList<Node> graphD[] = new ArrayList[MAX];
	static int[] dist = new int[MAX];
	static int[] distS = new int[MAX];
	static int[] distD = new int[MAX];
	
	public static void Dijkstra(int s, int[] dist, ArrayList<Node> graph[]) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));
		dist[s] = 0;
		
		while (!pq.isEmpty()) {
			Node top = pq.poll();
			int u = top.id;
			int w = top.weight;
			
			if (w > dist[u]) {
				continue;
			}
			
			for (Node neighbor : graph[u]) {
				if (w + neighbor.weight < dist[neighbor.id]) {
					dist[neighbor.id] = w + neighbor.weight;
					pq.add(new Node(neighbor.id, dist[neighbor.id]));
				}
			}
		}
	}
	
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			if (N == 0 && M == 0) {
				break;
			}
			
			for (int i = 0; i < N; i++) {
				graph[i] = new ArrayList<Node>();
				graphS[i] = new ArrayList<Node>();
				graphD[i] = new ArrayList<Node>();
				dist[i] = INF;
				distS[i] = INF;
				distD[i] = INF;
			}
			
			int S = sc.nextInt();
			int D = sc.nextInt();
			
			for (int i = 0; i < M; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int w = sc.nextInt();
				graphS[u].add(new Node(v, w));
				graphD[v].add(new Node(u, w));
			}
			
			Dijkstra(S, distS, graphS);
			Dijkstra(D, distD, graphD);
			int shortestPath = distS[D];
			
			for (int u = 0; u < N; u++) {
				for (Node neighbor : graphS[u]) {
					int v = neighbor.id;
					int w = neighbor.weight;
					
					if (distS[u] + w + distD[v] != shortestPath) {
						graph[u].add(neighbor);
					}
				}
			}
			
			Dijkstra(S, dist, graph);
			System.out.println(dist[D] != INF ? dist[D] : -1);
		}
	}
}
//O(T∗ElogV)
