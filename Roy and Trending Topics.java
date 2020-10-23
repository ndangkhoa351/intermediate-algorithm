import java.util.*;
import java.io.*;

public class Solution {
    static class Topic {
        int id;
        long old_score, new_score, change;

        public Topic(int _id, long _old_score, long _new_score) {
            id = _id;
            old_score = _old_score;
            new_score = _new_score;
            change = new_score - old_score;
        }
    };

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Topic> pq = new PriorityQueue<>(new Comparator<Topic>() {
            public int compare(Topic a, Topic b) {
                if (a.change < b.change || (a.change == b.change && a.id < b.id)) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        });

        for (int k = 0; k < n; k++) {
            int id = sc.nextInt();
            long old_score = sc.nextLong();
            long post = sc.nextLong(),          like = sc.nextLong();
            long comment = sc.nextLong(),       share = sc.nextLong();
            long new_score = post * 50 + like * 5 + comment * 10 + share * 20;
            pq.add(new Topic(id, old_score, new_score));
        }

        for (int i = 0; i < 5; i++) {
            Topic t = pq.poll();
            System.out.println(t.id + " " + t.new_score);
        }
    }
}
//O(NlogN)
