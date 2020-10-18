import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static final int MAX = (int)1e6 + 5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Point> points = new ArrayList<>();
        ArrayList<Integer> unique_x = new ArrayList<>(), unique_y = new ArrayList<>();
        boolean[] fre_x = new boolean[MAX], fre_y = new boolean[MAX]; 

        for (int i = 0; i < 8; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            points.add(new Point(x, y));

            if (!fre_x[x]) {
                fre_x[x] = true;
                unique_x.add(x);
            }

            if (!fre_y[y]) {
                fre_y[y] = true;
                unique_y.add(y);
            }
        }

        if (unique_x.size() != 3 || unique_y.size() != 3) {
            System.out.print("ugly");
            return;
        }

        Collections.sort(unique_x);
        Collections.sort(unique_y);
        Collections.sort(points);
        int index = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j && i == 1) {
                    continue;
                }

                int x = points.get(index).x;
                int y = points.get(index).y;
                if (unique_x.get(i) == x && unique_y.get(j) == y) {
                    index++;
                }
                else {
                    System.out.print("ugly");
                    return;
                }
            }
        }

        System.out.print("respectable");
    }
}

class Point implements Comparable<Point> {
    Integer x, y;

    public Point(int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }
    
    @Override
    public int compareTo(Point another) {
        if (this.x.equals(another.x)) {
            return this.y.compareTo(another.y);
        }
        return this.x.compareTo(another.x);
    }
}
//O(NlogN)
