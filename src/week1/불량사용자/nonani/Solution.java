/*
## ✏️ [프로그래머스] 불량 사용자
📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/64064

⏱️ 풀이 시간
1시간

✅ 풀이 근거
각 사용자와 제재 아이디 패턴의 매칭 가능 여부를 미리 구한 뒤, DFS로 가능한 조합을 만들고 비트마스크로 중복 조합을 제거한다.
*/

import java.util.*;

/*
사용자 수가 최대 8명이고 이름은 8글자를 안넘는다
무식하게
8명이고 모두 8글자 이름이고
banned된 유저도 8명이고 이름도 모두 8글자라 해보자

유저 1이 밴됐는지 확인해보자니 
banned_id 8개를 모두 비교해봐도 
8 * 8이다.
이걸 유저 8명 다 해도 8*8*8이면 연산 횟수가 아무리 많아도 2^9 = 512번


결국엔 이 문제는 조합을 구하는 문제
밴 아이디가 모두 "********", "********", ..., "********"라 해보자

그러면 최악의 경우는 8C4, 8*7*5*4 / 4! = 70 이마저도 완탐 때려도 된다.
*/
class Solution {
    static boolean[][] flag; // [a][b]  a번 유저가 밴을 당한 b번 유저일 수 있다.
    static int n, m; // 각각 n: 전체 유저 수, m : 벤 목록에 있는 유저 수
    static boolean[] visited = new boolean[2000];
    static int answer;
    public int solution(String[] user_id, String[] banned_id) {
        this.answer = 0; this.n = user_id.length; this.m = banned_id.length;
        flag = new boolean[n][m];
        
        for(int i = 0; i<user_id.length;i++) {
            String user = user_id[i];
            
            for(int j = 0; j<banned_id.length;j++) {
                String banned_user = banned_id[j];
                if(check(user, banned_user))
                    flag[i][j] = true;
            }
            
            dfs(0, 0);
        }
        
        return answer;
    }
    //flag[a][b]  a번 유저가 밴을 당한 b번 유저일 수 있다.
    private void dfs(int depth, int num) {
        if(visited[num]){
            return;
        }
        
        if(depth == m) {
            if(!visited[num]) {
                answer++;        
                visited[num] = true;
            }
            return;
        }
        for(int i=0;i<n;i++) {
            if(flag[i][depth] && (num & 1 << i) == 0)
                dfs(depth+1, num | (1 << i));
        }
    }
    
    private boolean check(String user, String banned) {
        if(user.length() != banned.length())
            return false;
        
        for(int i=0;i<banned.length();i++) {
            char c1 = banned.charAt(i);
            char c2 = user.charAt(i);
            
            if(c1 != '*' && c1 != c2)
                return false;
        }
        return true;
    }
}

/*
디버깅용
for(int j = 0; j<m;j++) 
            System.out.print("\t"+ banned_id[j]);
            System.out.println();
        for(int i = 0; i<user_id.length;i++) {
            String user = user_id[i];
            System.out.print(user +"\t");
            for(int j = 0; j<banned_id.length;j++) {
                String banned_user = banned_id[j];
                if(check(user, banned_user)) {
                    flag[i][j] = true;
                    System.out.print(1 +"\t");
                }else {
                    System.out.print(0 +"\t");
                }
            }
            System.out.println();
            
            dfs(0, 0);

*/
