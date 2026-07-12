package week1.귤고르기.Vryez11;

import java.util.*;

class Solution {

    // 귤 고르기
    public int solution(int k, int[] tangerine) {

        Map<Integer, Integer> fruitMap = new HashMap<>();
        for (int idx : tangerine) {
            fruitMap.put(idx, fruitMap.getOrDefault(idx, 0) + 1);
        }

        PriorityQueue<Fruit> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : fruitMap.entrySet()) {
            pq.add(new Fruit(entry.getKey(), entry.getValue()));
        }

        int ans = 0;

        while (!pq.isEmpty() && k > 0) {
            Fruit now = pq.poll();
            k -= now.count;
            ans++;
        }

        return ans;
    }

    static class Fruit implements Comparable<Fruit>{

        int idx;
        int count;

        public Fruit(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }

        @Override
        public int compareTo(Fruit o) {
            return Integer.compare(o.count, this.count);
        }
    }
}