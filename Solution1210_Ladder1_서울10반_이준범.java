package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution1210_Ladder1_서울10반_이준범 {
	public static int T, N, Answer, ladder[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1210.txt"));
		Scanner sc = new Scanner(System.in);
		
		while (T < 10) {
			T = sc.nextInt();
			N = 100;
			ladder = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {
				if (ladder[N-1][i] == 2)
					Answer = i;
			}
			for (int i = N-2; i >= 0; i--) {
				for (int j = -1; j <= 1; j+=2) {
					while (0 <= Answer + j && Answer + j < N && ladder[i][Answer+j] == 1) {
						ladder[i][Answer+j] = 0;
						Answer += j;
					}
				}
			}
			System.out.println("#" + T + " " + Answer);
		}	
		sc.close();
	}
}
