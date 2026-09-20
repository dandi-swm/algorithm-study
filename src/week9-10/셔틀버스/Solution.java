/*
## ✏️ [프로그래머스] [1차] 셔틀버스
📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/17678

✅ 풀이 근거
크루를 도착 시각 순으로 정렬하고 버스를 한 대씩 굴리며 앞에서부터 최대 m명씩 태운다.
막차에 자리가 남으면 막차 출발 시각에 오면 되고,
막차가 꽉 차면 막차에 탄 마지막 사람보다 1분 일찍 와서 자리를 뺏어야 한다.
*/

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] times = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            times[i] = getTime(timetable[i]);
        }
        Arrays.sort(times);

        int idx = 0; // 아직 버스를 못 탄 크루 중 제일 앞사람
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int busTime = getTime("09:00") + i * t;
            int boarded = 0;

            while (idx < times.length && boarded < m && times[idx] <= busTime) {
                idx++;
                boarded++;
            }

            if (i == n - 1) {
                if (boarded < m) {
                    answer = busTime; // 자리 남음
                } else {
                    answer = times[idx - 1] - 1; // 꽉 참 → 마지막 탑승자보다 1분 일찍
                }
            }
        }

        return getTime(answer);
    }

    private int getTime(String time) {
        String[] s = time.split(":");

        int hour = Integer.parseInt(s[0]);
        int minute = Integer.parseInt(s[1]);

        return hour * 60 + minute;
    }

    private String getTime(int value) {
        int hour = value / 60;
        int minute = value % 60;

        return String.format("%02d:%02d", hour, minute);
    }
}
