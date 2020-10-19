import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
 
public class Main {
    static final int MAX = 10000 + 5;
    static class Car {
        int id, arriveTime;
         
        public Car(int _id, int _arriveTime) {
            this.id = _id;
            this.arriveTime = _arriveTime;
        }
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        int res[] = new int[MAX];
         
        while (Q-- > 0) {
            Queue<Car> qSide[] = new Queue[2];
            qSide[0] = new LinkedList<>();
            qSide[1] = new LinkedList<>();
             
            int n = sc.nextInt();
            int t = sc.nextInt();
            int m = sc.nextInt();
             
            for (int i = 1; i <= m; i++) {
                int arrived = sc.nextInt();
                String atBank = sc.next();
                 
                if (atBank.equals("left")) {
                    qSide[0].add(new Car(i, arrived));
                }
                else {
                    qSide[1].add(new Car(i, arrived));
                }
            }
             
            int curSide = 0, curTime = 0, nextTime;
            int waiting = (!qSide[0].isEmpty() ? 1 : 0) + (!qSide[1].isEmpty() ? 1 : 0);
             
            while (waiting > 0) {
                if (waiting == 1) {
                    nextTime = (qSide[0].isEmpty() ? qSide[1].peek().arriveTime : qSide[0].peek().arriveTime);
                }
                else {
                    nextTime = Math.min(qSide[0].peek().arriveTime, qSide[1].peek().arriveTime);
                }
                 
                curTime = Math.max(curTime, nextTime);
                int carried = 0;
                 
                while (!qSide[curSide].isEmpty()) {
                    Car car = qSide[curSide].peek();
                    if (car.arriveTime <= curTime && carried < n) {
                        res[car.id] = curTime + t;
                        carried++;
                        qSide[curSide].remove();
                    }
                    else {
                        break;
                    }
                }
                 
                curTime += t;
                curSide = 1 - curSide;
                waiting = (!qSide[0].isEmpty() ? 1 : 0) + (!qSide[1].isEmpty() ? 1 : 0);
            }
             
            for (int i = 1; i <= m; i++) {
                System.out.println(res[i]);
            }
                 
            if (Q > 0) {
                System.out.println();
            }
        }
    }
}
//O(T∗M)
