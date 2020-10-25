import java.util.*;
import java.io.*;
 
class Node {
    public Node[] child;
    public boolean isLeaf;
    public Node() {
        child = new Node[26];
        this.isLeaf = false;
    }
}

class Trie {
    public static final int MAX = 26;
    private Node root;
    public Trie() {
        root = new Node();
    }
    
    public boolean addWord(String s) {
        Node temp = root;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a'; 
            if (temp.child[ch] == null) {
                flag = true;
                temp.child[ch] = new Node();
            }
            temp = temp.child[ch];
            if (temp.isLeaf == true)
                return false;
        }
        temp.isLeaf = true;
        return flag;
    } 
} 

class Main {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Trie trie = new Trie();
        boolean nonVulnerable = true;
        while (n-- > 0) {
            String s = in.nextLine();
            nonVulnerable &= trie.addWord(s);
        }
        if (nonVulnerable)
            System.out.print("non vulnerable");
        else
            System.out.print("vulnerable");
    } 
}
//O(string_length∗N)
