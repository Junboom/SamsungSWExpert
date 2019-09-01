package com.ssafy.algo;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution2817_부분수열의합_서울10반_이준범 {
	
	public static int T, N, K, Answer, sum, ia[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2817.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			Answer = 0;
			N = sc.nextInt();
			K = sc.nextInt();
			ia = new int[N];
			for (int i = 0; i < N; i++) {
				ia[i] = sc.nextInt();
			}
			
			for (int i = 1; i <= (1<<N); i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1<<j)) > 0)
						sum += ia[j];
				}
				if (sum == K)
					Answer++;
			}

			System.out.println("#" + test_case + " " + Answer);
		}
		sc.close();
	}
	
}
