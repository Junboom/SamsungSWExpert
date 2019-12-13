package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution4699 {
     
    public static int T, L, K, Answer;
    public static char[] ch;
    public static int[] cost;
     
    public static int palindrome(int front, int back, int totalCost) {
        if (front > back) {
            if (Answer > totalCost)
                Answer = totalCost;
            return Answer;
        }
        if (back < 0 || front >= L)
        	return Integer.MAX_VALUE;
        if (Answer <= totalCost)
            return totalCost;
         
        totalCost = Math.min(totalCost, palindrome(front + 1, back,
                totalCost + cost[(char)(ch[front]-'a')]));
        totalCost = Math.min(totalCost, palindrome(front, back - 1,
                totalCost + cost[(char)(ch[back]-'a')]));
        if (ch[front] == ch[back])
            totalCost = Math.min(totalCost, palindrome(front + 1, back - 1, totalCost));
         
        return totalCost;
    }
     
    public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input4699.txt"));
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
         
        for (int test_case = 1; test_case <= T; test_case++) {
            Answer = Integer.MAX_VALUE;
            L = sc.nextInt();
            K = sc.nextInt();
            ch = sc.next().toCharArray();
            cost = new int[K];
            for (int i = 0; i < K; i++) {
                int cost1 = sc.nextInt();
                int cost2 = sc.nextInt();
                cost[i] = (cost1 < cost2) ? cost1 : cost2;       // 최소비용만 필요
            }
             
            palindrome(0, L - 1, 0);
             
            System.out.println("#" + test_case + " " + Answer);
        }
         
        sc.close();
    }
     
}
