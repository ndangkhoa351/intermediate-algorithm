import java.util.*;
import java.io.*;
 
class Node {
    public Node[] child;
    public int countWord;
    public Node() {
        child = new Node[26];
        this.countWord = 0;
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
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a'; 
            if (temp.child[ch] == null) {
                temp.child[ch] = new Node();
            }
            temp = temp.child[ch];
            if (temp.countWord > 0) // có 1 từ là tiền tố của từ đang thêm vào trie
                return false;
        }
        temp.countWord += 1;
        for (int i = 0; i < MAX; i++) {
            if (temp.child[i] != null) // từ vừa thêm vào trie là tiền tố của 1 từ khác
                return false;
        }
        return true;
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
            if (!trie.addWord(s)){
                System.out.print("BAD SET\n");
                System.out.print(s);
                return;
            }
        }
        System.out.print("GOOD SET");
    } 
}
//O(N∗∣s∣)
