// ✏️ 프로그래머스 섬 연결하기

// 📶 문제 난이도
// Level 3

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/42861

// ⏱️ 풀이 시간
// 20분

// ✅ 풀이 근거
// 모든 노드를 연결하는 최소 비용! 크루스칼로 해결!

import java.util.*;

class Solution {
    
    int N, M;
    int[] parent;
    
    void union(int u, int v) {
        
        int fu = find(u);
        int fv = find(v);
        
        if (fu != fv) {
            parent[fv] = fu;
        }
    }

    int find(int u) {
        if (parent[u] == u) {
            return u;
        }
        
        return parent[u] = find(parent[u]);
    }
    
    public int solution(int n, int[][] costs) {
        
        N = n;
        M = costs.length;
        
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
    
        for (int i = 0; i < M; i++) {
            pq.add(new Node(costs[i][0], costs[i][1], costs[i][2]));
        }
        
        int answer = 0;
        while (!pq.isEmpty()) {
            
            Node cur = pq.poll();
            
            if (find(cur.u) == find(cur.v)) {
                continue;
            }
            
            union(cur.u, cur.v);
            answer += cur.cost;
        }
        return answer;
    }
}

class Node implements Comparable<Node> {
    int u;
    int v;
    int cost;
    
    public Node(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}