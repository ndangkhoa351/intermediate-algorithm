import java.util.*;

public class Main {
    static final int MAX = 500 + 1;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int n, m;
    static char[][] level = new char[MAX][MAX];

    static class Cell {
        int r, c;

        public Cell(int _r, int _c) {
            this.r = _r;
            this.c = _c;
        }
    };

    public static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    public static boolean BFS(Cell s, Cell f) {
        Queue<Cell> q = new LinkedList<>();
        level[s.r][s.c] = 'X';
        q.add(s);

        while (!q.isEmpty()) {
            Cell u = q.poll();

            for (int i = 0; i < 4; i++) {
                int r = u.r + dr[i];
                int c = u.c + dc[i];

                if (r == f.r && c == f.c && level[r][c] == 'X') {
                    return true;
                }

                if (isValid(r, c) && level[r][c] == '.') {
                    level[r][c] = 'X';
                    q.add(new Cell(r, c));
                }
            }
        }

        return false;
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            level[i] = sc.next().toCharArray();
        }

        Cell s = new Cell(sc.nextInt() - 1, sc.nextInt() - 1);
        Cell f = new Cell(sc.nextInt() - 1, sc.nextInt() - 1);

        System.out.print(BFS(s, f) ? "YES" : "NO");
    }
}
//O(n⋅m)
