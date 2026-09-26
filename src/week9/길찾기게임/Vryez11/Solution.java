package week9.길찾기게임.Vryez11;

import java.util.*;

public class Solution {

    /**
     *
     * [프로그래머스] 길 찾기 게임
     *
     * 문제 난이도: Lv3
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42892
     * 풀이 시간: 못풀었습니다..
     * 풀이 근거: 처음한 아이디어는 Root 노드에서 left, right 를 통해 이진 트리를 구성하는 거였는데 이를 어떻게 할지 아이디어가 없었는데 생각해보니, insert로 하면 됐었던...
     */
    public int[][] solution(int[][] nodeinfo) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nodeinfo.length; i++) {
            map.put(nodeinfo[i][0], i + 1);
        }

        Arrays.sort(nodeinfo, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        Node root = new Node(
                nodeinfo[0][0],
                map.get(nodeinfo[0][0])
        );

        for (int i = 1; i < nodeinfo.length; i++) {
            Node node = new Node(
                    nodeinfo[i][0],
                    map.get(nodeinfo[i][0])
            );

            insert(root, node);
        }

        int[][] answer = new int[2][nodeinfo.length];

        preorder(root, answer[0], new int[]{0});
        postorder(root, answer[1], new int[]{0});

        return answer;
    }

    private void insert(Node root, Node node) {

        Node current = root;

        while (true) {

            if (node.x < current.x) {

                if (current.left == null) {
                    current.left = node;
                    return;
                }

                current = current.left;

            } else {

                if (current.right == null) {
                    current.right = node;
                    return;
                }

                current = current.right;
            }
        }
    }

    private void preorder(Node node, int[] result, int[] idx) {

        if (node == null) return;

        result[idx[0]++] = node.idx;

        preorder(node.left, result, idx);
        preorder(node.right, result, idx);
    }

    private void postorder(Node node, int[] result, int[] idx) {

        if (node == null) return;

        postorder(node.left, result, idx);
        postorder(node.right, result, idx);

        result[idx[0]++] = node.idx;
    }

    static class Node {

        Node left;
        Node right;

        int x;
        int idx;

        Node(int x, int idx) {
            this.x = x;
            this.idx = idx;
        }
    }
}
