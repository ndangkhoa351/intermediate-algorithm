import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int numLocation, totalPeople, people;
        double x, y;
        numLocation = in.nextInt();
        totalPeople = in.nextInt();
        Map<Double, Integer> location = new TreeMap<>();
        for (int i = 0; i < numLocation; ++ i) {
            x = in.nextDouble();
            y = in.nextDouble();
            people = in.nextInt();
            double r = x * x + y * y;
            if (location.containsKey(r)) 
                location.put(r, location.get(r) + people);
            else
                location.put(r, people);
        }
        for (Double r : location.keySet()) {
            totalPeople += location.get(r);
            if (totalPeople >= 1000000) {
                System.out.printf("%.6f\n", Math.sqrt(r));
                return;
            }
        }
        System.out.print("-1\n");
    }
}
//O(NlogN)
