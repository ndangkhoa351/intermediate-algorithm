import java.util.*;
import java.io.*;
 
 
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
 
class TestClass {
    class Node{
 
        public Node(long key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
     
        public Node() {
        }
        public long key;
        public Node left;
        public Node right;
    }
    static PrintWriter out;
    final static int MAX =  1003;
 
    static class BinarySearchTree
    {
        class Node
        {
            long key;
            Node left, right;
 
            public Node(long item)
            {
                key = item;
                left = right = null;
            }
        }
        public int _count;
        Node root;
 
        BinarySearchTree()
        {
            root = null;
            _count = 0;
        }
 
        public void deleteKey(long key)
        {
            root = deleteRec(root, key);
        }
 
        public void deleteTree(){
            deleteNode(root);
        }
         
        public Node deleteNode(Node root){
            if (root == null)
        return null;
            root.left = deleteNode(root.left);
            root.right = deleteNode(root.right);
            root = null;
            return null;
        }
        public Node deleteRec(Node root, long key)
        {
            if (root == null)  return root;
 
            if (key < root.key)
                root.left = deleteRec(root.left, key);
            else if (key > root.key)
                root.right = deleteRec(root.right, key);
            else
            {
                if (root.left == null)
                    return root.right;
                else if (root.right == null)
                    return root.left;
 
                root.key = minValue(root.right);
 
                root.right = deleteRec(root.right, root.key);
            }
 
            return root;
        }
 
        public long minValue(Node root)
        {
            long minv = root.key;
            while (root.left != null)
            {
                minv = root.left.key;
                root = root.left;
            }
            return minv;
        }
 
        public void insert(long key)
        {
            root = insertRec(root, key);
        }
 
        public Node insertRec(Node root, long key)
        {
 
            if (root == null)
            {
                _count++;
                root = new Node(key);
                return root;
            }
 
            if (key < root.key)
                root.left = insertRec(root.left, key);
            else if (key > root.key)
                root.right = insertRec(root.right, key);
 
            return root;
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
     
    public static void main(String args[] ) throws Exception {
        MyScanner in = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int t, n, x;
        long temp;
        t = in.nextInt();
        while (t-->0)
        {
            BinarySearchTree root = new BinarySearchTree();
            root._count = 0;
            //root.deleteTree();
            n = in.nextInt();
            x = in.nextInt();
            for (int i = 0; i < n; i++)
            {
                temp = in.nextLong();
                root.insert(temp);
            }
            if (root._count == x)
                out.printf("Good\n");
            else if (root._count < x)
                out.printf("Bad\n");
            else
                out.printf("Average\n");
        }
    }
}
// O(T * N * logN)
