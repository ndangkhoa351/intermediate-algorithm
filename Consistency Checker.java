import java.io.*;
import java.util.*;
import java.lang.*;

class Node {
    static final int MAX = 10;
    public Node[] child;
    public boolean isLeaf;
    public Node() {
        child = new Node[MAX];
        isLeaf = false;
    }
}
class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    public boolean add(String s) {
        Node p = root;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - '0';
            if (p.child[c] == null) {
                p.child[c] = new Node();
                flag = true;
            }
            p = p.child[c];
            if (p.isLeaf) {
                flag = false;
                break;
            }
        }
        p.isLeaf = true;
        return flag;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t = 1; t <= T; t++) {
            System.out.print("Case " + t + ": ");
            Trie trie = new Trie();
            int n = Integer.parseInt(sc.nextLine());
            boolean flag = true;
            while (n-- > 0) {
                String s = sc.nextLine();
                if (flag && !trie.add(s)) 
                    flag = false;
            }
            if (flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        System.exit(0);
    }
}
//O(T∗string_length∗N) 
