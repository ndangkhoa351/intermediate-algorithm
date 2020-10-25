import java.io.*;
import java.util.*;

class Main {
    
    public static int bsFirst(ArrayList<Integer> a, int left, int right, int x) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid == 0 || x > a.get(mid - 1)) && a.get(mid) == x)
                return mid;
            else if (x > a.get(mid))
                return bsFirst(a, (mid + 1), right, x);
            else
                return bsFirst(a, left, (mid - 1), x);
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<Integer>();
        int n, q, temp;
        int count = 1;
		
        while (true) {
            n = in.nextInt();
            q = in.nextInt();
            if (n == 0 && q == 0)
                break;
            for (int i = 0; i < n; i++) {
                temp = in.nextInt();
                a.add(temp);
            }
			
            int x;
            Collections.sort(a);
            System.out.printf("CASE# %d:\n", count++);
            for (int i = 0; i < q; i++) {
                x = in.nextInt();
                int result = bsFirst(a, 0, n - 1, x);
                if (result != -1) {
                    System.out.printf("%d found at ", x);
                    System.out.printf("%d\n", result+1);
                }
                else {
                    System.out.printf("%d not found\n", x);
                }
            }
            a.clear();
        }
        return;
    }
}
//O(T∗Q∗logN)
