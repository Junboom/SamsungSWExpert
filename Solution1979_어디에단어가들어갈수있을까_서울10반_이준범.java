package com.ssafy.algo;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution1979_어디에단어가들어갈수있을까_서울10반_이준범 {
	
	public static int T, N, K, Answer, ia[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1979.txt"));
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			Answer = 0;
			N = sc.nextInt();
			K = sc.nextInt();
			ia = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ia[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < N; i++) {
				loop:for (int j = 0; j < N; j++) {
					if (ia[i][j] == 1 && j + K - 1 < N) {
						if (j > 0 && ia[i][j-1] == 1)
							continue loop;
						for (int k = 1; k < K; k++) {
							if (ia[i][j+k] != 1)
								continue loop;
						}
						if (j + K == N)
							Answer++;
						else if (j + K < N && ia[i][j+K] != 1)
							Answer++;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				loop:for (int j = 0; j < N; j++) {
					if (ia[i][j] == 1 && i + K - 1 < N) {
						if (i > 0 && ia[i-1][j] == 1)
							continue loop;
						for (int k = 1; k < K; k++) {
							if (ia[i+k][j] != 1)
								continue loop;
						}
						if (i + K == N)
							Answer++;
						else if (i + K < N && ia[i+K][j] != 1)
							Answer++;
					}
				}
			}

			System.out.println("#" + test_case + " " + Answer);
		}
		sc.close();
	}
	
}
