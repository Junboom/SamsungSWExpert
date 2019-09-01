package com.ssafy.algo;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution1209_Sum_서울10반_이준범 {
	
	public static int T, N, Answer, ia[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1209.txt"));
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			T = sc.nextInt();
			Answer = 0;
			N = 100;
			ia = new int[N+1][N+1];
			int iaLast = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ia[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ia[j][N] += ia[i][j];
					ia[N][j] += ia[j][i];
				}
				ia[N][N] += ia[i][i];
				iaLast += ia[i][N-1-i];
			}
			
			for (int i = 0; i < N; i++) {
				if (ia[i][N] > Answer) Answer = ia[i][N];
				if (ia[N][i] > Answer) Answer = ia[N][i];
			}
			if (ia[N][N] > Answer)	Answer = ia[N][N];
			if (iaLast > Answer)	Answer = iaLast;

			System.out.println("#" + test_case + " " + Answer);
		}
		sc.close();
	}
	
}
