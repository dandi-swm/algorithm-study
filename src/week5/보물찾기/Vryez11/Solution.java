package week5.보물찾기.Vryez11;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    /**
     * [프로그래머스] 보물 찾기
     *
     * 문제 난이도: Lv 3
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/468378
     * 풀이 시간: 2시간 (못품..)
     * 풀이 근거: 진우가 팀 코테에 독을 풀었따!
     */

    /*
    public int solution(int[] depth, int money, Function<Integer, Integer> excavate) {

        PriorityQueue<Tunnel> pq = new PriorityQueue<>((t1, t2) -> {
            int compare = Integer.compare(t1.depth, t2.depth);

            if (compare == 0) {
                compare = Integer.compare(t1.idx, t2.idx);
            }

            return compare;
        });
        Set<Integer> idxSet = new HashSet<>();

        for (int i = 0; i < depth.length; i++) {
            pq.offer(new Tunnel(i, depth[i]));
            idxSet.add(i);
        }
        int totalMoney = 0;

        while (!pq.isEmpty()) {
            Tunnel now = pq.poll();

            if (!idxSet.contains(now.idx)) {
                continue;
            }

            Integer result = excavate.apply(now.idx + 1);
            totalMoney += now.depth;

            if (result == 0) {
                return now.idx + 1;
            } else if (result == 1) {
                idxSet = idxSet.stream()
                        .filter(v -> v > now.idx)
                        .collect(Collectors.toSet());
            } else {
                idxSet = idxSet.stream()
                        .filter(v -> v < now.idx)
                        .collect(Collectors.toSet());
            }
        }

        return -1;
    }

    static class Tunnel {

        int idx;
        int depth;

        Tunnel(int idx, int depth) {
            this.idx = idx;
            this.depth = depth;
        }
    }
     */
}
