import java.util.*;

public class Main {
    static final int MAX = 51;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int n, m, k;
    static boolean[][] visited = new boolean[MAX][MAX];
    static char[][] table = new char[MAX][MAX];

    static class Cell {
        int r, c;

        public Cell(int _r, int _c) {
            this.r = _r;
            this.c = _c;
        }
    };

    static ArrayList<ArrayList<Cell>> lakes = new ArrayList<ArrayList<Cell>>();

    public static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    public static boolean onBorder(int r, int c) {
        return r == 0 || c == 0 || r == n - 1 || c == m - 1;
    }

    public static void DFS(Cell scr) {
        Stack<Cell> s = new Stack<>();
        visited[scr.r][scr.c] = true;
        s.add(scr);

        boolean isOcean = false;
        ArrayList<Cell> temp = new ArrayList<>();

        while (!s.isEmpty()) {
            Cell u = s.pop();
            temp.add(u);

            if (onBorder(u.r, u.c)) {
                isOcean = true;
            }

            for (int i = 0; i < 4; i++) {
                int r = u.r + dr[i];
                int c = u.c + dc[i];

                if (isValid(r, c) && table[r][c] == '.' && !visited[r][c]) {
                    visited[r][c] = true;
                    s.add(new Cell(r, c));
                }
            }
        }

        if (!isOcean) {
            lakes.add(temp);
        }
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            table[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && table[i][j] == '.') {
                    DFS(new Cell(i, j));
                }
            }
        }

        Collections.sort(lakes, new Comparator<ArrayList<Cell>>() {
            public int compare(ArrayList<Cell> a, ArrayList<Cell> b) {
                return a.size() - b.size();
            }
        });

        int sum_cell = 0;

        for (int i = 0; i < lakes.size() - k; i++) {
            sum_cell += lakes.get(i).size();
            for (Cell u : lakes.get(i)) {
                table[u.r][u.c] = '*';
            }
        }

        System.out.println(sum_cell);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }
}
//O(n∗m)
