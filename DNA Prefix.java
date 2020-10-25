import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    Node[] child = new Node[4];
    int num;
}
class Main {
    static int ans = 0;
    static int[] d = new int[26];
    static void Add(Node Root,String s){
         Node p = Root;
         for (int i=0;i<s.length();i++){

             int next  = d[s.charAt(i)-'A']; 
             
             if (p.child[next] == null ){
                 p.child[next] = new Node();
             }
             p = p.child[next];
             p.num++;
             
             
             ans = Math.max(p.num*(i+1),ans);
         }
    } 
    static void Delete(Node u){
        for (int i=0;i<4;i++){
            if (u.child[i] != null ){
                Delete(u.child[i]);
            }
        }
        u = null;
   }
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        
        d['A'-'A'] = 0 ;
        d['C'-'A'] = 1 ;
        d['G'-'A'] = 2 ; 
        d['T'-'A'] = 3 ;
        
        int t = sc.nextInt();
        
        String s = null;
        
        for (int k=1;k<=t;k++){
            ans = 0;
            Node Root = new Node();
            int n = sc.nextInt();
        
            
            for (int i=0;i<n;i++){
                Add(Root,sc.next());
            }
            System.out.println("Case "+k+": "+ans);
            Delete(Root);
            Root = null;
        }
        System.exit(0);
    }
}
//O(T∗string_length∗N)
