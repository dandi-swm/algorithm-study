package week9.길찾기게임.twalla;

import java.util.*;

/*
## ✏️ [프로그래머스] 길 찾기 게임

📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/42892

⏱️ 풀이 시간
40분

✅ 풀이 근거
주어진 2차원 배열로 트리를 만들고 해당 트리를 전위 순회, 후위 순회하는 문제!
트리를 만드는게 좀 까다로웠는데, y값에 따라 부모/자식이 결정되기에 y를 기준으로 map을 만들고 정렬해줘서 만들었다.

*/

public class Solution {

    int N;
    List<Integer> preList, postList;

    // 전위 순회: 루트 -> 왼 -> 오
    void preOrder(Node node) {

        if (preList.size() == N) {
            return;
        }

        preList.add(node.index);

        if (node.leftChild != null) {
            preOrder(node.leftChild);
        }

        if (node.rightChild != null) {
            preOrder(node.rightChild);
        }

    }

    // 후위 순회: 왼 -> 오 -> 루트
    void postOrder(Node node) {

        if (postList.size() == N) {
            return;
        }

        if (node.leftChild != null) {
            postOrder(node.leftChild);
        }

        if (node.rightChild != null) {
            postOrder(node.rightChild);
        }

        postList.add(node.index);
    }

    public int[][] solution(int[][] nodeinfo) {

        N = nodeinfo.length;

        Map<Integer, List<Node>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];

            if (map.containsKey(y)) {
                map.get(y).add(new Node(i + 1, x));
            } else {
                map.put(y, new ArrayList<>());
                map.get(y).add(new Node(i + 1, x));
            }
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, Collections.reverseOrder());

        // 트리 만들기
        Node root = null;
        for (int key : keySet) {
            for (Node child : map.get(key)) {

                if (root == null) {
                    root = child;
                    continue;
                }

                Node curNode = root;
                while (true) {
                    if (child.x < curNode.x) {
                        if (curNode.leftChild == null) {
                            curNode.leftChild = child;
                            break;
                        } else {
                            curNode = curNode.leftChild;
                            continue;
                        }
                    } else {
                        if (curNode.rightChild == null) {
                            curNode.rightChild = child;
                            break;
                        } else {
                            curNode = curNode.rightChild;
                            continue;
                        }
                    }
                }
            }
        }

        preList = new ArrayList<>();
        preOrder(root);

        postList = new ArrayList<>();
        postOrder(root);

        int[][] answer = new int[2][N];

        for (int i = 0; i < N; i++) {
            answer[0][i] = preList.get(i);
            answer[1][i] = postList.get(i);
        }

        return answer;
    }
}

class Node {
    int index;
    int x;
    Node leftChild = null;
    Node rightChild = null;

    public Node(int index, int x) {
        this.index = index;
        this.x = x;
    }
}
