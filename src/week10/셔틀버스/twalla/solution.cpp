#include <string>
#include <vector>
#include <deque>
#include <iomanip>
#include <algorithm>

using namespace std;

/*
## ✏️ [프로그래머스] [1차] 셔틀버스

📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/17678

⏱️ 풀이 시간
1시간

✅ 풀이 근거

- 크루 도착 시각을 오름차순 정렬 후 `deque`에 삽입.
- 1회차부터 n회차 셔틀까지 각 출발 시각 이하에 온 크루들을 최대 m명씩 순차 탑승(`pop_front`).

- 만석인 경우: 마지막으로 탑승한 크루보다 1분 일찍 도착 (`last_crew_time - 1`)
- 자리가 남은 경우: 마지막 셔틀 출발 시각 정각에 도착 (`shuttle_time`)
*/

// 분 단위 -> "HH:MM" 변환
string to_time_str(int minutes) {
    stringstream ss;
    ss << setw(2) << setfill('0') << minutes / 60 << ":"
        << setw(2) << setfill('0') << minutes % 60;

    return ss.str();
}

// "HH:MM" -> 분 단위 변환
int to_minutes(string time) {
    return stoi(time.substr(0, 2)) * 60 + stoi(time.substr(3, 2));
}

string solution(int n, int t, int m, vector<string> timetable) {

    vector<int> crew_times;
    for (string time : timetable) {
        crew_times.push_back(to_minutes(time));
    }

    sort(crew_times.begin(), crew_times.end());

    deque<int> crews(crew_times.begin(), crew_times.end());

    int shuttle_time = 9 * 60; // 09:00 시작
    int last_crew_time = 0;
    int onboard_count = 0;

    for (int i = 0; i < n; i++) {
        onboard_count = 0;

        // 이번 셔틀에 탈 수 있는 인원
        while (!crews.empty()) {

            if (crews.front() > shuttle_time || onboard_count == m) {
                break;
            }

            last_crew_time = crews.front();
            crews.pop_front();
            onboard_count += 1;
        }

        // 마지막 셔틀이 아니라면 다음 셔틀 시간으로 갱신
        if (i < n - 1) {
            shuttle_time += t;
        }
    }

    int answer_min = 0;

    // 마지막 셔틀
    if (onboard_count == m) { // 만석이면 마지막 승객보다 1분 먼저
        answer_min = last_crew_time - 1;
    } else { // 만석이 아니면 셔틀 정각에 탑승
        answer_min = shuttle_time;
    }

    string answer = to_time_str(answer_min);

    return answer;
}