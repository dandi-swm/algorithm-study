package week1.캐시.Vryez11;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     *
     * [프로그래머스] 캐시
     *
     * 문제 난이도 : Lv2
     * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17680
     * 풀이 시간 : 20분
     * 풀이 근거 : LRU -> 가장 오랫동안 사용하지 않은 데이터를 먼저 제거하는 교체 알고리즘
     */

    public int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0) return cities.length * 5;

        int ans = 0;

        List<String> cache = new ArrayList<>();

        for (String city : cities) {

            city = city.toLowerCase();

            if (cache.contains(city)) {
                ans += 1;
                cache.remove(city);
                cache.add(city);
            } else {
                ans += 5;

                if (cache.size() == cacheSize)
                    cache.remove(0);

                cache.add(city);
            }
        }

        return ans;
    }
}
