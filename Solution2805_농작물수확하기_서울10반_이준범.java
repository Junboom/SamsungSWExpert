package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution2805_농작물수확하기_서울10반_이준범 {
	public static int T, N, Answer, parm[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2805.txt"));
		Scanner sc = new Scanner(System.in);
		T = Integer.parseInt(sc.nextLine());
		
		for (int tc = 1; tc <= T; tc++) {
			Answer = 0;
			N = Integer.parseInt(sc.nextLine());
			parm = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String str = sc.nextLine();
				for (int j = 0; j < N; j++) {
					parm[i][j] = str.charAt(j) - '0';
				}
			}
			
			int temp = 0;
			int flag = 1;
			for (int i = 0; i < N; i++) {
				for (int j = N/2 - temp; j <= N/2 + temp; j++) {
					Answer += parm[i][j];
					if (j == N - 1)
						flag = -1;
				}
				temp += flag;
			}
			
			System.out.println("#" + tc + " " + Answer);
		}	
		sc.close();
	}
}
