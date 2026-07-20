package week2.괄호회전하기.Vryez11;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Solution {

    /**
     *
     * [프로그래머스] 괄호 회전하기
     *
     * 문제 난이도: Lv2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/76502
     * 풀이 시간: 30분
     * 풀이 근거: 일단 괄호 검사 함수를 먼저 만듬 -> Queue로 쉽게 앞에 있는 것을 빼서 뒤에 넣을 수 있겠다고 생각
     */

    public int solution(String s) {

        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }
        int ans = 0;

        for (int i = 0; i < s.length() - 1; i++) {

            if (isValidBracket(queue)) {
                ans++;
            }

            queue.add(queue.poll());
        }

        return ans;
    }

    private boolean isValidBracket(Queue<Character> queue) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char bracket : queue) {

            if (bracket == '[' || bracket == '(' || bracket == '{') {
                stack.push(bracket);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            Character next = stack.peek();

            if (bracket == ']' && next != '[') {
                return false;
            }
            if (bracket == ')' && next != '(') {
                return false;
            }
            if (bracket == '}' && next != '{') {
                return false;
            }

            stack.pop();
        }

        return stack.isEmpty();
    }
}
