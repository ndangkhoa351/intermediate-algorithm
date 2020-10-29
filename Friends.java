import java.util.*;

public class Main {
	static final int MAX = 30005;
	static int[] parent = new int[MAX];
	static int[] cnt = new int[MAX];

	private static int findSet(int u) {
		while (u != parent[u]) {
			u = parent[u];
		}
		return u;
	}

	private static void unionSet(int u, int v) {
		int up = findSet(u);
		int vp = findSet(v);
		if (up != vp) {
			parent[up] = vp;
			cnt[vp] += cnt[up];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			for (int i = 1; i <= n; i++) {
				parent[i] = i;
				cnt[i] = 1;
			}

			for (int i = 0; i < m; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				unionSet(u, v);
			}

			int res = -1;
			for (int i = 1; i <= n; i++) {
				res = Math.max(res, cnt[i]);
			}

			System.out.println(res);
		}
	}
}
//O(T∗N∗M)
