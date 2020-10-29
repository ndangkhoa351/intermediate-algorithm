import java.io.File;
import java.io.IOException;
import java.util.*;
 
public class Penguins {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> penguins = new TreeMap<>();
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String name = sc.nextLine();
            if (penguins.containsKey(name))
                penguins.put(name, penguins.get(name) + 1);
            else
                penguins.put(name, 1);
        }
        String kind = "";
        int maxCount = 0;
        for (String name : penguins.keySet())
            if (maxCount < penguins.get(name)) {
                kind = name;
                maxCount = penguins.get(name);
            }
        System.out.println(kind);
    }
}
//O(NlogN) 
