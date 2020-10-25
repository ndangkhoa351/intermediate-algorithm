import java.util.*;

public class Main {
    static final int ALPHABET_SIZE = 26;
    
    static class Node {
        Node[] child = new Node[ALPHABET_SIZE];
        int maxValue;
    
        Node() {
            maxValue = -1;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                child[i] = null;
            }
        }
    }
    
    static void addWord(Node root, String s, int value) {
        Node tmp = root;
    
        for (char c : s.toCharArray()) {
            int pos = c - 'a';
            if (tmp.child[pos] == null) {
                tmp.child[pos] = new Node();
            }
    
            tmp = tmp.child[pos];
            tmp.maxValue = Math.max(tmp.maxValue, value);
        }
    }
    
    static int getHighestMatching(Node root, String s) {
        Node tmp = root;
    
        for (char c : s.toCharArray()) {
            int pos = c - 'a';
            if (tmp.child[pos] == null) {
                return -1;
            }
            tmp = tmp.child[pos];
        }
    
        return tmp.maxValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        Node root = new Node();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int value = sc.nextInt();
            addWord(root, s, value);
        }

        for (int i = 0; i < q; i++) {
            String s = sc.next();
            System.out.println(getHighestMatching(root, s));
        }
    }
}
//O((n+q)∗string_length)
