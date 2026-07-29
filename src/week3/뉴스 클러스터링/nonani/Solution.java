/*
## ✏️ [프로그래머스] 뉴스 클러스터링
📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/17677

⏱️ 풀이 시간
30분
✅ 풀이 근거
항상 두글자에 알파벳만 해야하니까 26진수라고 생각하면 좀 깔끔하게 처리할 수 있을 것이라고 생각했다.
a -> 0, b -> 1, ... , 'z' -> 25
예를 들어 ab = 26 * 0 + 1 = 1
        zz = 26 * 26 + 25 = 701
그래서 배열 길이가 int[701] 이면 이제 해당 두글자 알파벳이 등장하면 26진수로 변환해서 해당 배열의 인덱스를 증가시키는 방식을 쓰면
깔끔한 형태로 문제를 해결할 수 있었다.

*/

class Solution {
    static final int MAX = 26 * 26 + 25;
    static final int NUM = 65536;
    public int solution(String str1, String str2) {
        int answer = 0;


        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        int num1 = getIntersection(str1, str2);
        int num2 = getUnion(str1, str2);

        if(num1 == 0 && num2 == 0)
            return NUM;

        return num1 * NUM / num2;
    }

    private int getUnion(String str1, String str2) {
        int result = 0;
        int[] cnt1 = getCount(str1);
        int[] cnt2 = getCount(str2);

        for(int i=0;i<MAX;i++) {
            result += Math.max(cnt1[i], cnt2[i]);
        }

        return result;
    }

    private int getIntersection(String str1, String str2) {
        int result = 0;
        int[] cnt1 = getCount(str1);
        int[] cnt2 = getCount(str2);

        for(int i=0;i<MAX;i++) {
            result += Math.min(cnt1[i], cnt2[i]);
        }

        return result;
    }

    private int[] getCount(String str) {
        int[] cnt = new int[MAX];

        for(int i=1;i<str.length();i++) {
            int prev = str.charAt(i-1) - 'a';
            int cur = str.charAt(i) - 'a';
            if(isAlphabet(prev) && isAlphabet(cur)) {
                cnt[prev * 26 + cur]++;
            }
        }
        return cnt;
    }

    private boolean isAlphabet(int c) {
        // System.out.println(c);
        return c >= 0 && c <= 26;
    }
}