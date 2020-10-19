import java.util.*;
 
public class Main {
    static final int MAX = 251;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int N, M;
    static int[][] table = new int[MAX][MAX];
    static int[] slick = new int[MAX * MAX];
 
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
        table[s.r][s.c] = 0;
        int count = 1;
 
        while (!q.isEmpty()) {
            Cell u = q.poll();
 
            for (int i = 0; i < 4; i++) {
                int r = u.r + dr[i];
                int c = u.c + dc[i];
 
                if (isValid(r, c) && table[r][c] == 1) {
                    table[r][c] = 0;
                    q.add(new Cell(r, c));
                    count++;
                }
            }
        }
 
        slick[count]++;
    }
 
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            N = sc.nextInt();
            M = sc.nextInt();
 
            if (N == 0 && M == 0) {
                break;
            }
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    table[i][j] = sc.nextInt();
                    slick[i * M + j + 1] = 0;
                }
            }
 
            int nslicks = 0;
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (table[i][j] == 1) {
                        nslicks++;
                        BFS(new Cell(i, j));
                    }
                }
            }
 
            System.out.println(nslicks);
 
            for (int i = 1; i <= N * M; i++) {
                if (slick[i] != 0) {
                    System.out.println(i + " " + slick[i]);
                }
            }
        }
    }
}
//O(N∗M)
