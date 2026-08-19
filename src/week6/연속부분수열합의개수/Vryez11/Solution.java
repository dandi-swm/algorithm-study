package week6.연속부분수열합의개수.Vryez11;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     *
     * [프로그래머스] 연속 부분 수열 합의 개수
     *
     * 문제 난이도: Lv2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131701
     * 풀이 시간: 5분
     * 풀이 근거: 이게 효율적인 풀이라고는 못하겠어서 다른 풀이가 있으면 보고 배우겠습니다!, 뭔가 집합이면 비트마스킹으로 풀 수 있지않을까? 생각해봤는데 음.......
     */

    public int solution(int[] elements) {

        Set<Integer> sumSet = new HashSet<>();

        for (int i = 0; i < elements.length; i++) {

            int temp = elements[i];
            sumSet.add(temp);

            for (int j = 1; j < elements.length; j++) {

                temp += elements[(i + j) % elements.length];
                sumSet.add(temp);
            }
        }

        return sumSet.size();
    }
}
