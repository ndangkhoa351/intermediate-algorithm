import java.util.*;

public class Main {
    static final int MAX = 500 + 1;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int N, M;
    static int nsheeps, nwolves;
    static char[][] backyard = new char[MAX][MAX];

    static class Cell {
        int r, c;

        public Cell(int _r, int _c) {
            this.r = _r;
            this.c = _c;
        }
    };

    public static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    public static void BFS(Cell s) {
        Queue<Cell> q = new LinkedList<>();
        q.add(s);

        int sheep = (backyard[s.r][s.c] == 'k' ? 1 : 0);
        int wolf = (backyard[s.r][s.c] == 'v' ? 1 : 0);

        boolean canEscape = false;
        backyard[s.r][s.c] = '#';

        while (!q.isEmpty()) {
            Cell u = q.poll();

            for (int i = 0; i < 4; i++) {
                int r = u.r + dr[i];
                int c = u.c + dc[i];

                if (!isValid(r, c)) {
                    canEscape = true;
                    continue;
                }

                if (backyard[r][c] != '#') {
                    sheep += (backyard[r][c] == 'k' ? 1 : 0);
                    wolf += (backyard[r][c] == 'v' ? 1 : 0);
                    backyard[r][c] = '#';
                    q.add(new Cell(r, c));
                }
            }
        }

        if (canEscape) {
            nsheeps += sheep;
            nwolves += wolf;
        }
        else {
            if (sheep > wolf) {
                nsheeps += sheep;
            }
            else {
                nwolves += wolf;
            }
        }
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            backyard[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (backyard[i][j] != '#') {
                    BFS(new Cell(i, j));
                }
            }
        }

        System.out.print(nsheeps + " " + nwolves);
    }
}
//O(n∗m)
