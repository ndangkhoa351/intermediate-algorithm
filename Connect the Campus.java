import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.ArrayList;
 
class Node implements Comparable<Node> {
	public Integer id;
	public Integer dist;
	public Node(Integer id, Integer dist) {
	this.id = id;
	this.dist = dist;
	}
	public int compareTo(Node other) {
	return this.dist.compareTo(other.dist);
	}
}
public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static final int MAX = 800;
	static final  int INF = (int) 1e9;
	static ArrayList<ArrayList< Node >> graph = new ArrayList<ArrayList< Node> >();
	static int dist[]= new int[MAX];
	static int path[] = new int[MAX];
	static Boolean visited[] = new Boolean[MAX];
	static int N, M;
	static int x[] = new int[MAX], y[] = new int[MAX];

	static int distance(int i, int j)
	{
		return (x[i] - x[j])*(x[i] - x[j]) + (y[i] - y[j])*(y[i] - y[j]);
	}

	static double result() 
	{
		double ans = 0;
		for (int i = 0; i<N; i++) 
		{
			ans += Math.sqrt(dist[i]);
			if (ans >= INF) 
			{
				return -1;
			}
		}
		return ans;
	}

	static void prims(int src) 
	{
		PriorityQueue<Node > pq = new PriorityQueue<Node>();
		pq.add(new Node(src,0));
		dist[src] = 0;
		while (!pq.isEmpty()) 
		{
			int u = (int) pq.peek().id;
			pq.poll();
			visited[u] = true;
			for (int i = 0; i<graph.get(u).size(); i++) 
			{
				int v = graph.get(u).get(i).id;
				int w = (int) graph.get(u).get(i).dist;
				if (!visited[v] && dist[v] > w) 
				{
					dist[v] = w;
					pq.add(new Node(v, w));
					path[v] = u;
				}
			}
		}
	}

	static void ResetGraph()
	{
		for (int i = 0; i < N; i++)
		{
			graph.get(i).clear();
			visited[i] = false;
			dist[i] = INF;
			path[i] = -1;
		}
	}

	public static void main(String[] args) 
	{
		for (int i=0;i<MAX;i++) graph.add(new ArrayList<Node>());
		N=MAX-1;
		ResetGraph();
		while (sc.hasNext()) 
		{
			N=sc.nextInt();
			for (int i = 0; i<N; i++)
			{
				int a, b;
				a = sc.nextInt();
				b = sc.nextInt();
				x[i] = a;
				y[i] = b;
			}
			M = sc.nextInt();
			boolean edges[][] = new boolean[MAX][MAX];
			for (int i=0;i<N;i++)
				for (int j=0;j<N;j++) edges[i][j]=false;
			
			for (int i = 0; i<M; i++)
			{
				int a, b;
				a= sc.nextInt();
				b= sc.nextInt();
				edges[a - 1][b - 1] = true;
				edges[b - 1][a - 1] = true;
			}
			for (int i = 0; i< N - 1; i++) 
			{
				for (int j = i + 1; j<N; j++)
				{
					if (edges[i][j] == false)
					{
						int w = distance(i, j);
						graph.get(i).add(new Node(j, w));
						graph.get(j).add(new Node(i, w));
					}
					else 
					{
						graph.get(i).add(new Node(j, 0));
						graph.get(j).add(new Node(i, 0));
					}
				}
			}
			prims(0);
			double r = result();
			System.out.printf("%.2f%n", r);
			ResetGraph();
		}
	}
}
//O(T∗N^2∗logN)
