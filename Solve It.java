import java.io.*;
import java.util.*;

class Main {

    static final double eps = 1e-8;

    public static double f(double p , double q , double r , double s , double t , double u , double x) {
        return (p * Math.exp(-x) + q * Math.sin(x)
                + r * Math.cos(x) + s * Math.tan(x) + t * x * x + u);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        double p , q , r , s , t , u;

        while (in.hasNext()) {
            p = in.nextDouble();
            q = in.nextDouble();
            r = in.nextDouble();
            s = in.nextDouble();
            t = in.nextDouble();
            u = in.nextDouble();
            double lo = 0.000;
            double hi = 1.000;
            if (f(p , q , r , s , t , u , 1.0) > 1e-9 || p + r + u < 0) {
                System.out.println("No solution");
                continue;
            }
            double res = -1;
            for (int i = 0; i <= 1000; i++) {
                double x = (lo + hi) / 2.0;
                double F = f(p , q , r , s , t , u , x);

                if (F > 0)
                    lo = x;
                else
                    hi = x;
            }
            System.out.printf("%.4f\n", lo);
        }

        return;
    }
}
//O(T⋅log(1e6))
