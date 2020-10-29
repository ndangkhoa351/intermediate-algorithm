import java.util.*;
import java.io.*;
  
class Main {
    public static void main(String[] args) throws Exception {
        FastInput in = new FastInput(System.in);
        int t, n, m;
        long temp;
        t = in.nextInt();
        while (t-- > 0) {
            TreeSet s = new TreeSet();
            n = in.nextInt();
            m = in.nextInt();
            for (int i = 0; i < n; i++) {
                temp = in.nextLong();
                s.add(temp);
            }
            for (int i = 0; i < m; i++) {
                temp = in.nextLong();
                if (s.contains(temp))
                    System.out.println("YES");
                else
                    System.out.println("NO");
                s.add(temp);
            }
        }
    }
}
  
class FastInput
{
    final private int BUFFER_SIZE = 1 << 16;
  
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;
  
    public FastInput(InputStream in)
    {
        din = new DataInputStream(in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }
  
    public long nextLong() throws Exception
    {
        long ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = c == '-';
        if (neg) c = read();
        do
        {
         ret = ret * 10 + c - '0';
         c = read();
        } while (c > ' ');
        if (neg) return -ret;
        return ret;
    }
  
    //reads in the next string
    public String next() throws Exception
    {
        StringBuilder ret =  new StringBuilder();
        byte c = read();
        while (c <= ' ') c = read();
        do
        {
            ret = ret.append((char)c);
            c = read();
        } while (c > ' ');
        return ret.toString();
    }
  
    public int nextInt() throws Exception
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = c == '-';
        if (neg) c = read();
        do
        {
            ret = ret * 10 + c - '0';
            c = read();
        } while (c > ' ');
        if (neg) return -ret;
        return ret;
    }
  
    private void fillBuffer() throws Exception
    {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) buffer[0] = -1;
    }
  
    private byte read() throws Exception
    {
        if (bufferPointer == bytesRead) fillBuffer();
        return buffer[bufferPointer++];
    }
}
//O(T * M * log(N + M))
