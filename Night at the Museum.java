import java.util.Scanner;
 
public class Main {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        String wheel = sc.next();
        char pointer = 'a';
        int dist, count = 0;
 
        for (char c : wheel.toCharArray()) {
            dist = Math.abs(pointer - c);
 
            if (dist < 13) {
                count = count + dist;
            }
            else {
                count = count + (26 - dist);
            }
 
            pointer = c;
        }
 
        System.out.print(count);
    }
}
