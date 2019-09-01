package com.ssafy.algo;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution5215Ex {
	
	public static int T, N, L, Answer;
	public static int sum[], add[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5215.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			Answer = 0;
			N = sc.nextInt();
			L = sc.nextInt();
			add = new int[N][2];
			sum = new int[2];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 2; j++) {
					add[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 1; i <= (1<<N); i++) {
				sum[0] = 0;
				sum[1] = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1<<j)) > 0) {
						sum[0] += add[j][0];
						sum[1] += add[j][1];
					}
				}
				if (sum[1] <= L && Answer < sum[0])
					Answer = sum[0];
			}

			System.out.println("#" + test_case + " " + Answer);
		}
		
		sc.close();
	}
	
}
