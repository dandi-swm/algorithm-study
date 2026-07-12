package week1.불량사용자.Vryez11;

import java.util.*;

public class Solution {

    /**
     *
     * 프로그래머스 불량사용자
     *
     * 문제 난이도 : Lv3
     * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/64064
     * 풀이 시간 : 40분
     * 풀이 근거 : 문자열 검증 -> Map 만들기 -> 만든 Map으로 백트래킹을 통해 Set 구하기
     */

    public int solution(String[] user_id, String[] banned_id) {

        Map<String, List<String>> banned_map = new HashMap<>();
        for (String bannedId : banned_id) {

            if (banned_map.containsKey(bannedId)) {
                continue;
            }

            for (String userId : user_id) {
                if (isValidId(userId, bannedId)) {
                    banned_map.computeIfAbsent(bannedId, k -> new ArrayList<>())
                            .add(userId);
                }
            }
        }

        Set<Set<String>> results = new HashSet<>();
        dfs(0, banned_id, banned_map, new HashSet<>(), results);
        return results.size();
    }

    private boolean isValidId(String userId, String bannedId) {

        if (userId.length() != bannedId.length()) {
            return false;
        }

        char[] userArr = userId.toCharArray();
        char[] bannedArr = bannedId.toCharArray();
        for (int i = 0; i < userId.length(); i++) {
            if (bannedArr[i] == '*') {
                continue;
            }

            if (userArr[i] != bannedArr[i]) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int idx, String[] banned_id, Map<String, List<String>> banned_map, Set<String> used, Set<Set<String>> results) {

        if (idx == banned_id.length) {
            results.add(new HashSet<>(used));
            return;
        }

        for (String candidate : banned_map.get(banned_id[idx])) {
            if (used.contains(candidate)) {
                continue;
            }

            used.add(candidate);
            dfs(idx + 1, banned_id, banned_map, used, results);
            used.remove(candidate);
        }
    }
}
