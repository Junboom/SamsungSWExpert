package com.ssafy.algo;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution1954_달팽이숫자_서울10반_이준범 {
	
	public static int T, N, Answer;
	public static int ia[][];
	public static int dir[][] = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
	
	public static void permutation(int i, int j, int change) {
		if (N * N < Answer)
			return;
		ia[i][j] = Answer++;
		switch (change) {
		case 0:
			System.out.println("i= " + i + " j= " + j);
			if (N <= j + 1 || ia[i][j+1] != 0)	change++;
			break;
		case 1:
			if (N <= i + 1 || ia[i+1][j] != 0)	change++;
			break;
		case 2:
			if (j - 1 < 0 || ia[i][j-1] != 0)	change++;
			break;
		case 3:
			if (i - 1 < 0 || ia[i-1][j] != 0)	change = 0;
			break;
		default:
			break;
		}
		permutation(i + dir[change][0], j + dir[change][1], change);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1954.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			Answer = 1;
			N = sc.nextInt();
			ia = new int[N][N];
			
			System.out.println("#" + test_case);
			permutation(0, 0, 0);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(ia[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
	
}
