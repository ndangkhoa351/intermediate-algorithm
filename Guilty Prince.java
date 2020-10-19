import java.util.*;
 
public class Main {
    static final int MAX = 21;
    static int dr[] = {0, 0, 1, -1};
    static int dc[] = {1, -1, 0, 0};
    static int W, H;
    static boolean visited[][] = new boolean[MAX][MAX];
    static String maze[] = new String[MAX];
 
    static class Cell {
        int r, c;
 
        public Cell(int _r, int _c) {
            this.r = _r;
            this.c = _c;
        }
    };
 
    public static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < H && c < W;
    }
 
    public static int BFS(Cell s) {
        Queue<Cell> q = new LinkedList<>();
        q.add(s);
        visited[s.r][s.c] = true;
        int count = 1;
 
        while (!q.isEmpty()) {
            Cell u = q.poll();
 
            for (int i = 0; i < 4; i++) {
                int r = u.r + dr[i];
                int c = u.c + dc[i];
 
                if (isValid(r, c) && maze[r].charAt(c) == '.' && !visited[r][c]) {
                    visited[r][c] = true;
                    q.add(new Cell(r, c));
                    count++;
                }
            }
        }
 
        return count;
    }
     
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        Cell s = new Cell(0, 0);
 
        for (int k = 1; k <= Q; k++) {
            W = sc.nextInt();
            H = sc.nextInt();
 
            for (int i = 0; i < H; i++) {
                maze[i] = sc.next();
                 
                for (int j = 0; j < W; j++) {
                    if (maze[i].charAt(j) == '@') {
                        s = new Cell(i, j);
                    }
                 
                    visited[i][j] = false;
                }
            }
             
            System.out.println("Case " + k + ": " + BFS(s));
        }   
    }
}
//O(T∗W∗W∗H∗H)
//O(T∗W∗H)
