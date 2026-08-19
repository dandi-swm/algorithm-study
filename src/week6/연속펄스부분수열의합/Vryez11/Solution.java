package week6.연속펄스부분수열의합.Vryez11;

public class Solution {

    /**
     *
     * [프로그래머스] 연속 펄스 부분 수열의 합
     *
     * 문제 난이도: Lv3
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/161988
     * 풀이 시간: 20분
     * 풀이 근거: 어짜피 1, -1, 1, -1, ... 과 -1, 1, -1, 1, ... 2개니까 2개의 배열을 만들어 풀면 되겠다고 생각함.
     *          이 후, 부분 수열의 최대 핪을 구하는 공식은 찾아봤습니다(ㅈㅅㅈㅅ) 시간 복잡도: O(N)
     *          current arr[1], max arr[1] 초기화 -> current = Math.max(arr[i], current[i] + arr[i]), max = Math.max(current, max)
     */
    public long solution(int[] sequence) {

        int[] pulse1Arr = new int[sequence.length];
        int[] pulse2Arr = new int[sequence.length];
        int d = 1;
        for (int i = 0; i < sequence.length; i++) {

            pulse1Arr[i] = sequence[i] * d;
            d *= (-1);
            pulse2Arr[i] = sequence[i] * d;
        }

        long pulse1Current = pulse1Arr[0];
        long pulse2Current = pulse2Arr[0];

        long pulse1Max = pulse1Arr[0];
        long pulse2Max = pulse2Arr[0];

        for (int i = 1; i < sequence.length; i++) {

            pulse1Current = Math.max(pulse1Arr[i], pulse1Current + pulse1Arr[i]);
            pulse2Current = Math.max(pulse2Arr[i], pulse2Current + pulse2Arr[i]);

            pulse1Max = Math.max(pulse1Max, pulse1Current);
            pulse2Max = Math.max(pulse2Max, pulse2Current);
        }

        return Math.max(pulse1Max, pulse2Max);
    }
}
