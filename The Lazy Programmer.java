import java.util.*;
import java.io.*;
class Job implements Comparable<Job>{
     
    public int a,b,d;
    public int compareTo(Job j){
        return this.d - j.d;
    }
    Job(){
        a = b = d = 0;
    }
}
class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;
  
    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }
  
    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
  
    public int nextInt() {
        return Integer.parseInt(next());
    }
  
    public double nextDouble() {
        return Double.parseDouble(next());
    }
}
class Main {
    static final int MAX = 100005;
    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);
         
        int t,N;
        t = sc.nextInt();
         
        for(int k = 0 ; k < t; k++)
        {
            PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
 
                @Override
                public int compare(Job o1, Job o2) {
                    return o2.a - o1.a;
                }
            });
            N = sc.nextInt();
            Job J[] = new Job[MAX];
            for(int i =0; i  < N; i++){
                J[i] = new Job();
                J[i].a = sc.nextInt();
                J[i].b = sc.nextInt();
                J[i].d = sc.nextInt();
            }
            Arrays.sort(J,0,N);
            double sum_min = 0;
            int time = 0 ;
            for(int i = 0; i < N;i++){
                time += J[i].b;
                pq.add(J[i]);
                while (time > J[i].d)
                {
                    Job top = pq.poll();
                    if (top.b > time - J[i].d)
                    {
                        sum_min += (time - J[i].d) * 1.0 / top.a;
                        top.b -= time - J[i].d;
                        pq.add(top);
                        time = J[i].d;
                    }
                    else
                    {
                        sum_min += top.b * 1.0 / top.a;
                        time -= top.b;
                        top.b = 0;
                    }
                }
            }
            System.out.printf("%.2f\n", sum_min);
        }
    }
}
//O(t*NlogN)O(t∗NlogN)
