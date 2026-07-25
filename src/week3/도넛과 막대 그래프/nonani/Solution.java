/*
## ✏️ [프로그래머스] 도넛과 막대 그래프
📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/258711

⏱️ 풀이 시간
60분

✅ 풀이 근거
처음에 유니온파인드가 먼저 떠올랐는데 시작 노드를 찾기 위해서는 in-out 개수를 세야함을 알았고 그 이후에는 굳이 그룹을 묶지 않아도 규칙을 찾을 수 있겠다
싶어서 다른 풀이를 생각해봤다.
*/

import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = {0, 0, 0, 0};

        HashMap<Integer, Integer> in = new HashMap<>();
        HashMap<Integer, Integer> out = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int[] e : edges) {
            int from = e[0];
            int to = e[1];

            in.put(to, in.getOrDefault(to, 0) + 1);
            in.put(from, in.getOrDefault(from, 0));

            out.put(from, out.getOrDefault(from, 0) + 1);
            out.put(to, out.getOrDefault(to, 0));

            ArrayList<Integer> next = graph.getOrDefault(from, new ArrayList<Integer>());
            graph.put(to, graph.getOrDefault(to, new ArrayList<Integer>()));
            next.add(to);
            graph.put(from, next);
        }

        Set<Integer> keySet = in.keySet();

        int start = -1;

        for (Integer i : keySet) {

            //우선 기준 정점이 뭔지 찾는게 중요한데 기준 정점의 필수 조건은 나가는 간선만 있어야하고 들어오는 간선은 없어야한다.
            // 처음엔 위에처럼 생각했는데 생각해보니 막대그래프의 제일 아래 노드도 들어오는 간선이 0이다. 따라서 나가는 간선이 1보다 커야한다. 구분할 수 있다.
            if (in.get(i) == 0 && out.get(i) > 1) {
                start = i;
                break;
            }
        }
        answer[0] = start;
//        System.out.println(start);

        // 그 이후로 그 기준 정점으로 바로 한칸 뻗어나간 점이 어떤 모양 그래프에 해당하는지를 판별하면 될 것 같다.

        // 막대 판별은 기준 정점과 연결된 간선 외에는 in 간선이 없다.
        for (int node : graph.get(start)) {

            in.put(node, in.get(node) - 1); // 중심노드로부터 들어오는 경우 제거
            Queue<Integer> q = new ArrayDeque<>();

            q.add(node);
            HashSet<Integer> visited = new HashSet<>();
            visited.add(node);
            int flag = 1;
            while (!q.isEmpty()) {
                int cur = q.poll();
                // System.out.println(cur);
                if (out.get(cur) == 0) {
                    flag = 2;
                    break;
                } else if (in.get(cur) > 1 || out.get(cur) > 2) {
                    flag = 3;
                    break;
                }
                for (int next : graph.get(cur)) {
                    if (!visited.contains(next)) {
                        q.add(next);
                        visited.add(next);
                    }

                }
            }
            answer[flag]++;
        }

        return answer;
    }
}