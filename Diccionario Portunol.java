import java.util.*;
import java.io.*;


class Main
{ 
    static PrintWriter out;
    static final int MAX =26;
    static int suffixStateCount = 0;
    static int startWith[] = new int[MAX];    
    
    
    public static class node{

        public node() {
        }
        public node[] child = new node[MAX];
        public int countLeaf;
    }
    
    public static class Trie{

        public Trie() {
            root = NewNode();
        }
        public node root;
        
        public node NewNode(){
            node newNode = new node();
            newNode.countLeaf = 0;
            for(int i = 0 ; i < MAX;i++){
                newNode.child[i] = null;
            }
            return newNode;
        }
        
        public void AddWord(String s){
            int ch;
            node temp = root;
            for(int i = 0 ; i < s.length(); i++){
                ch = s.charAt(i) - 'a';
                if(temp.child[ch] == null)
                    temp.child[ch] = NewNode();
                temp = temp.child[ch];
            }
            temp.countLeaf++;
        }
        
    }
    
    public static void suffixTraversal(node pNode, int level){
        suffixStateCount++;
        for (int i = 0; i < 26; i++){
            if (pNode.child[i]==null)
                    continue;
            if (level > 0) startWith[i]++;
            suffixTraversal(pNode.child[i], level + 1);
        }
    }
    
    
    static long prefixTraversal(node pNode, int level) {
        long result = 0;
        if (level > 0) result += suffixStateCount;
        for (int i = 0; i < 26; i++) {
            if (pNode.child[i] == null)
                continue;
            if (level > 0)
                result -= startWith[i];
            result += prefixTraversal(pNode.child[i], level + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        MyScanner in = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int p = 0 ,s = 0;
        String str;
        while(true){
            p = in.nextInt();
            s = in.nextInt();
            if(p==0 && s ==0){
                break;
            }
            Trie suffixTrie = new Trie();
            Trie prefixTrie = new Trie();
            
            for(int i = 0 ; i < 26 ;i++){
                startWith[i] = 0;
            }
            
            suffixStateCount = 0;
            
            for(int i = 0 ; i < p ; i++){
                str = in.next();
                prefixTrie.AddWord(str);
            }
            
            for(int i = 0 ;i < s;i++){
                str = in.next();
                String reverse = new StringBuffer(str).reverse().toString();
                suffixTrie.AddWord(reverse);
            }
            
            suffixTraversal(suffixTrie.root, 0);
            suffixStateCount--;
            long ans = prefixTraversal(prefixTrie.root, 0);
            out.println(ans);
        }
    }
    
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                        st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                        e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
                return Integer.parseInt(next());
        }
        long nextLong() {
                return Long.parseLong(next());
        }
        double nextDouble() {
                return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
//O(2∗10^5)
