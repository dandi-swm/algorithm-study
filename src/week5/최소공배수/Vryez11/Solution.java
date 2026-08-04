package week5.최소공배수.Vryez11;

import java.util.Arrays;

public class Solution {

    /**
     * [프로그래머스] N개의 최소공배수
     *
     * 문제 난이도: Lv.2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12953
     * 풀이 시간: 10분
     * 풀이 근거: 이유는 모르겠지만, 절대 안까먹는 공식 공식 -> gcd 최대공약수 찾는 공식
     *          gcd
     *          b == 0 -> a
     *          gcd(b, a % b)
     */

    public int solution(int[] arr) {

        int mod = 1;

        for (int i = 0; i <arr.length; i++) {

            mod *= arr[i] / gcd(mod, arr[i]);
        }

        return mod;
    }

    private int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
