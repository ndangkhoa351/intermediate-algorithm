import java.util.*;

public class Main {
    static final int INF = (int)1e9 + 7;
    static final int MAX = 28;
    static class Place implements Comparable<Place>{
        int cost, id;

        public Place(int _cost, int _id) {
            this.cost = _cost;
            this.id = _id;
        }

        @Override
        public int compareTo(Place other) {
            return (this.cost == other.cost ? this.id - other.id : this.cost - other.cost);
        }
    }

    static int[][] distS = new int[MAX][MAX];
    static int[][] distD = new int[MAX][MAX];
    static ArrayList<Place> res = new ArrayList<>();

    public static void FloydWarshall(int[][] dist) {
        for (int k = 0; k < MAX; k++) {
            for (int i = 0; i < MAX; i++) {
                for (int j = 0; j < MAX; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }

            for (int i = 0; i < MAX; i++) {
                for (int j = 0; j < MAX; j++) {
                    distS[i][j] = (i == j ? 0 : INF);
                    distD[i][j] = (i == j ? 0 : INF);
                }
            }

            for (int i = 0; i < N; i++) {
                char age = sc.next().charAt(0);
                char dir = sc.next().charAt(0);
                char x = sc.next().charAt(0);
                char y = sc.next().charAt(0);
                int c = sc.nextInt();

                int u = x - 'A';
                int v = y - 'A';

                if (age == 'Y') {
                    distS[u][v] = Math.min(distS[u][v], c);
                    if (dir == 'B') {
                        distS[v][u] = Math.min(distS[v][u], c);
                    }
                }
                else {
                    distD[u][v] = Math.min(distD[u][v], c);
                    if (dir == 'B') {
                        distD[v][u] = Math.min(distD[v][u], c);
                    }
                }
            }

            char x = sc.next().charAt(0);
            char y = sc.next().charAt(0);
            int s = x - 'A';
            int d = y - 'A';
            FloydWarshall(distS);
            FloydWarshall(distD);

            res.clear();
            int minDist = INF;

            for (int i = 0; i < MAX; i++) {
                int dist1 = distS[s][i];
                int dist2 = distD[d][i];

                if (dist1 != INF && dist2 != INF && dist1 + dist2 <= minDist) {
                    res.add(new Place(dist1 + dist2, i));
                    minDist = dist1 + dist2;
                }
            }

            if (res.isEmpty()) {
                System.out.print("You will never meet.");
            }
            else {
                Collections.sort(res);
                System.out.print(minDist);

                for (Place place : res) {
                    if (place.cost != minDist) {
                        break;
                    }
                    System.out.print(" " + (char)(place.id + 'A'));
                }
            }
            System.out.println();
        }
    }
}
//O(T∗N^3)
