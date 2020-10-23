import java.util.*;

public class Main {
	static final int MAX = 100000 + 5;
	static final int INF = (int)1e9;
	static int N, M;
	
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
	
	public static int[] Dijkstra(int s) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		
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
		
		return dist;
	}

	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int k = sc.nextInt();
		int x = sc.nextInt();
		ArrayList<Integer> cities = new ArrayList<>();
		
		for (int i = 0; i < k; i++) {
			cities.add(sc.nextInt());
		}
		
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int d = sc.nextInt();
			graph[u].add(new Node(v, d));
			graph[v].add(new Node(u, d));
		}
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int[] distA = Dijkstra(A);
		int[] distB = Dijkstra(B);
		int res = INF;
		
		for (int city : cities) {
			if (distB[city] <= x) {
				res = Math.min(res, distA[city] + distB[city]);
			}
		}
		
		System.out.print(res < INF ? res : -1);
	}
}
//O(ElogV)
