import java.io.*;
import java.util.*;

class Node {
	static final int MAX = 26;
	public Node[] child;
	public int count;
	public Node() {
		child = new Node[MAX];
	}
}
class Trie {
	Node root;
	public Trie() {
		root = new Node();
	}
	public void add(String s) {
		Node p = root;
		for (int i = 0; i < s.length(); i++) {
			int next = s.charAt(i) - 'a';
			if (p.child[next] == null) {
				p.child[next] = new Node();
			}
			p = p.child[next];
			p.count++;
		}
	}
	public int find(String s) {
		Node p = root;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			int next = s.charAt(i) - 'a';
			if (p.child[next] == null)
				return 0;
			p = p.child[next];
			res = p.count;
		}
		return res;
	}
}
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Trie trie = new Trie();
		while (n > 0) {
			n--;
			String type = sc.next();
			String s = sc.next();
			if (type.equals("add")) 
				trie.add(s);
			else
				System.out.println(trie.find(s));
		}
	}
}
//O(string_length∗N)
