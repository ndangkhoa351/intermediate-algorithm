import java.util.*;

public class Main {
    static final int MAX = 105;
    static int[] parent = new int[MAX];
    static int[] ranks = new int[MAX];
    static Set<Integer>[] trees = new TreeSet[MAX];

    private static int findSet(int u) {
        if (u != parent[u]) {
            parent[u] = findSet(parent[u]);
        }
        return parent[u];
    }

    private static void unionSet(int u, int v) {
        int up = findSet(u);
        int vp = findSet(v);

        if (up == vp) {
            return;
        }

        if (ranks[up] > ranks[vp]) {
            parent[vp] = up;
        }
        else if (ranks[up] < ranks[vp]) {
            parent[up] = vp;
        }
        else {
            parent[up] = vp;
            ranks[vp]++;
        }
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();

        for (int i = 0; i < MAX; i++) {
            trees[i] = new TreeSet<>();
        }

        while (Q-- > 0) {
            int P = sc.nextInt();
            int T = sc.nextInt();
            sc.nextLine();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.length() == 0) {
                    break;
                }

                String[] arrOfStr = line.split(" ");
                int person = Integer.parseInt(arrOfStr[0]);
                int tree = Integer.parseInt(arrOfStr[1]);
                trees[person].add(tree);
            }

            for (int i = 1; i <= P; i++) {
                parent[i] = i;
                ranks[i] = 0;
            }

            for (int i = 1; i <= P; i++) {
                for (int j = i + 1; j <= P; j++) {
                    if (trees[i].equals(trees[j])) {
                        unionSet(i, j);
                    }
                }
            }

            int nSets = 0;
            for (int i = 1; i <= P; i++) {
                if (i == parent[i]) {
                    nSets++;
                }
                trees[i].clear();
            }

            System.out.println(nSets);
            if (Q > 0) {
                System.out.println();
            }
        }
    }
}
//O(Q∗P^2∗(T+P))
