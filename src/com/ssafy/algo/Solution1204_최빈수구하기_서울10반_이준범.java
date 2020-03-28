package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution1204_최빈수구하기_서울10반_이준범 {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input1204.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] score = new int[10][1000];
		
		int N;
		do {
			int Answer = 1, max = 1, _max = 0;
			N = sc.nextInt();
			for (int j = 0; j < 1000; j++) {
				score[N-1][j] = sc.nextInt();
			}
			for (int j = 999; j >= 0; j--) {
				for (int k = 0; k < j; k++) {
					if (score[N-1][k] > score[N-1][k+1]) {
						int temp = score[N-1][k];
						score[N-1][k] = score[N-1][k+1];
						score[N-1][k+1] = temp;
					}
				}
			}
			for (int j = 0; j < 999; j++) {
				if (score[N-1][j] == score[N-1][j+1]) {
					max++;
				}
				else {
					if (Answer <= max) {
						Answer = max;
						_max = score[N-1][j];
					}
					max = 1;
				}
			}
			Answer = _max;
			System.out.println("#" + N + " " + Answer);
		} while (N < T);
		
		sc.close();

	}

}
