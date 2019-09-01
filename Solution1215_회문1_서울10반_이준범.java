package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution1215_회문1_서울10반_이준범 {
	
	public static int N, Answer;
	public static StringBuilder text;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1215.txt"));
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			Answer = 0;
			N = sc.nextInt();
			char[][] pan = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String str = sc.next();
				for (int j = 0; j < 8; j++) {
					pan[i][j] = str.charAt(j);
				}
			}
			
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8-N; j++) {
					int k;
					for (k = 0; k < N/2; k++) {
						if (pan[i][j+k] != pan[i][j+N-k-1])	break;
					}
					if (k == N/2)	Answer++;
				}
			}
			
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8-N; j++) {
					int k;
					for (k = 0; k < N/2; k++) {
						if (pan[j+k][i] != pan[j+N-k-1][i])	break;
					}
					if (k == N/2)	Answer++;
				}
			}
			
			System.out.println("#" + tc + " " + Answer);
		}
		
		sc.close();
	}

}
