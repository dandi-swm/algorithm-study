package week8.할인행사.Vryez11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     *
     * [프로그래머스] 할인 행사
     *
     * 문제 난이도: Lv2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131127
     * 풀이 시간: 15분
     * 풀이 근거: 위시리스트를 List로 관리하고 쇼핑 카트에 10개씩 담으면서 isSignup으로 위시리스트가 다 담겼는지 확인하는 로직을 구현했습니다.
     */
    public int solution(String[] want, int[] number, String[] discount) {

        int ans = 0;

        List<Hope> hopeList = new ArrayList<>();
        for (int i = 0; i < want.length; i++) {

            hopeList.add(new Hope(want[i], number[i]));
        }

        Map<String, Integer> cart = new HashMap<>();
        for (int i = 0; i < discount.length; i++) {

            if (i < 9) {
                cart.put(discount[i], cart.getOrDefault(discount[i], 0) + 1);
                continue;
            }

            if (i == 9) {
                cart.put(discount[i], cart.getOrDefault(discount[i], 0) + 1);
                ans = isSignup(cart, hopeList)? ans + 1: ans;
                continue;
            }

            cart.put(discount[i- 10], cart.get(discount[i - 10]) - 1);
            cart.put(discount[i], cart.getOrDefault(discount[i], 0) + 1);
            ans = isSignup(cart, hopeList)? ans + 1: ans;
        }

        return ans;
    }

    boolean isSignup(Map<String, Integer> cart, List<Hope> hopeList) {

        for (Hope hope : hopeList) {

            if (!cart.containsKey(hope.want)) {
                return false;
            }

            if (cart.get(hope.want) < hope.count) {
                return false;
            }
        }

        return true;
    }

    static class Hope {

        public String want;
        public int count;

        private Hope(String want, int count) {

            this.want = want;
            this.count = count;
        }
    }
}
