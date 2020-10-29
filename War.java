import java.util.Scanner;
import java.util.Map;
import java.util.TreeSet;


class DSU{
  int[] parent;
  int n;
  public DSU(int x){
    n = x;
    parent = new int[x];
    for (int i=0;i< n;i++) {
      parent[i]=i;
    }
  }
  public int find(int u){
    if (parent[u]!=u) parent[u]=find(parent[u]);
    return parent[u];
  }
  public void union(int u ,int v){
    int i = find(u);
    int j = find(v);
    if (i!=j) {
      parent[j]=i;
    }
  }
}
class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int MAX = 10000;
    int n,c,x,y;  
    n = sc.nextInt();
    DSU dsu = new DSU(20002);
    while (true) {
      c = sc.nextInt();
      x = sc.nextInt();
      y = sc.nextInt();

      if (c == 0 && x == 0 && y == 0) {
        break;
      }
      if (c == 1) {
        if (dsu.find(x) == dsu.find(y + MAX)) {
          System.out.println(-1);
          continue;
        }
      
      dsu.union(x, y);
      dsu.union(x + MAX, y + MAX);
      }
      else if (c == 2) {
        if (dsu.find(x) == dsu.find(y)) {
          System.out.println(-1);
          continue;
        }
        dsu.union(x, y + MAX);
        dsu.union(x + MAX, y);
      }
      else if (c == 3) {
        if(dsu.find(x) == dsu.find(y)){
          System.out.println(1);
        }
        else
          System.out.println(0);
      }
      else if (c == 4) {
        if(dsu.find(x) == dsu.find(y+MAX)){
          System.out.println(1);
        }
        else
          System.out.println(0);
      }
    }
  }
}
//O(n∗m)
