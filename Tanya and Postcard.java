import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner in = new Scanner(System.in);
        String message, newspaper;
        Map<Integer, Integer> a = new HashMap<Integer, Integer>();
        Map<Integer, Integer> b = new HashMap<Integer, Integer>();
        int yay = 0, whoops = 0;
        message = in.nextLine();
        newspaper = in.nextLine();
        
        for (int i = 0; i < 52; i++) {
            a.put(i, 0);
            b.put(i, 0);
        }
        for (int i = 0; i < message.length(); i++) {
            int id = message.charAt(i) - 'A';
            if (message.charAt(i) > 'Z')
        	    id = message.charAt(i) - 'a' + 26;
            a.put(id, a.get(id) + 1);
        }
        for (int i = 0; i < newspaper.length(); i++) {
            int id = newspaper.charAt(i) - 'A';
            if (newspaper.charAt(i) > 'Z')
        	    id = newspaper.charAt(i) - 'a' + 26;
            b.put(id, b.get(id) + 1);
        }
    
        for (int i = 0; i < 52; i++) {
            int tmp = Math.min(a.get(i), b.get(i));
            yay += tmp;
            a.put(i, a.get(i) - tmp);
            b.put(i, b.get(i) - tmp);
        }
        for (int i = 0; i < 26; i++) {
            whoops += Math.min(a.get(i), b.get(i+26)) + Math.min(a.get(i+26), b.get(i));
        }
        System.out.printf("%d %d", yay, whoops);
    }
}
//O(K∗log(K)) K=52
