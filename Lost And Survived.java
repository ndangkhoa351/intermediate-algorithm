import java.util.Scanner;
import java.util.PriorityQueue;

class Main {
    private static class IntegerPair implements Comparable<IntegerPair> {
        Integer first;
        Integer second;

        IntegerPair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(IntegerPair o) {
            if (first.compareTo(o.first) == 0) {
                return second.compareTo(o.second);
            }
            else {
                return first.compareTo(o.first);
            }
        }
    }

    private static int MAX_N = 100005;

    private static int n, m;
    private static int root[] = new int[MAX_N];
    private static int cnt[] = new int[MAX_N];
    private static int maxi = 0;
    private static PriorityQueue<IntegerPair> pq = new PriorityQueue<>();

    private static int findRoot(int u) {
        if (u == root[u]) {
            return u;
        }

        return root[u] = findRoot(root[u]);
    }

    private static void unionSet(int u, int v) {
        int uu = findRoot(u);
        int vv = findRoot(v);

        if (uu != vv) {
            cnt[uu] += cnt[vv];
            root[vv] = uu;
            pq.add(new IntegerPair(cnt[uu], uu));
            maxi = Math.max(maxi, cnt[uu]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            cnt[i] = 1;
            root[i] = i;
            pq.add(new IntegerPair(1, i));
        }

        maxi = 1;

        for (int i = 1; i <= m; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            unionSet(u, v);
            while (true) {
                IntegerPair tmp = pq.peek();
                int r = findRoot(tmp.second);
                if (r != tmp.second) {
                    pq.poll();
                    continue;
                }
                
                if (cnt[r] != tmp.first) {
                    pq.poll();
                    continue;
                }

                break;
            }

            System.out.println(maxi - pq.peek().first);
        }
        sc.close();
    }
}
//O(Q∗log(N)) 
