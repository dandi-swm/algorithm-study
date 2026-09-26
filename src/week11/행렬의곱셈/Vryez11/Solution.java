package week11.행렬의곱셈.Vryez11;

public class Solution {

    /**
     *
     * [프로그래머스] 행렬의 곱셈
     *
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12949
     * 문제 난이도: Lv2
     * 풀이 시간: 5분
     * 풀이 근거: 수민아 고맙다..
     */
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] result = new int[arr1.length][arr2[0].length];
        int multSum = 0;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {

                    multSum += arr1[i][k] * arr2[k][j];
                }
                result[i][j] = multSum;
                multSum = 0;
            }
        }

        return result;
    }
}
