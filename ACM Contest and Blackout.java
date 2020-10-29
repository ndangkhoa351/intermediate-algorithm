import java.util.Scanner;
public class Main {

	static Scanner sc  = new Scanner(System.in);
	static final int MAX  =  10001000;
	static final int INF =  1000000000;
	static final int N = 110;
	static int graph[][] = new int[N][N], path[][] = new int[N][N], used[][] = new int[N][N];
	static int pre[]= new int[N], key[] = new int[N], n, res, ans;
	static boolean visited[]=new boolean[N];
	

	static int minKey(int key[], boolean visited[])
	{
		int min = INF, min_index = 0;

		for (int v = 0; v < n; v++)
			if (visited[v] == false && key[v] < min)
			{
				min = key[v];
				min_index = v;
			}
		return min_index;
	}

	static void prim()
	{
		int i, j;
		for(i=0; i<n; i++)
			key[i] = graph[0][i];

		for(int k=0; k<n-1; k++)
		{

			int u = minKey(key, visited);
			
			visited[u] = true;
			res += key[u];
			used[u][pre[u]] = used[pre[u]][u] = 1;

			for(j=0; j<n; j++)
			{
				if(!visited[j] && key[j]>graph[u][j])
				{
					key[j] = graph[u][j];
					pre[j] = u;
				}
				else if(visited[j] && j!=u)
				{
					path[u][j] = path[j][u] = Math.max(key[u], path[j][pre[u]]);
				}
			}
		}
		
		for(i=0; i<n; i++)
		{
			for(j=i+1; j<n; j++)
				if(used[i][j]==0)
				{
					ans = Math.min(ans, res-path[i][j] + graph[i][j]);
				}
		}
	}

	public static void main(String[] args) 
	{

		int T, a, b, c, m;
		T = sc.nextInt();
		while(T > 0)
		{
			T--;
			n = sc.nextInt();
			m = sc.nextInt();
			for (int i=0;i<n;i++){
				visited[i]=false;
				pre[i]=0;
				for (int j=0;j<n;j++){
					graph[i][j]=INF;
					path[i][j]=0;
					used[i][j]=0;
				}
			}
			visited[0] = true;
			res = 0;
			ans = INF;
			for(int i=0; i<m; i++)
			{
				a = sc.nextInt();
				b = sc.nextInt();
				c = sc.nextInt();
				graph[a-1][b-1] = c;
				graph[b-1][a-1] = c;
			}
			prim();
			System.out.println(res+" "+ans);
		}

	}

}
//O(T∗N∗MlogN)
