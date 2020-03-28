package com.ssafy.algo;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution2806_NQueen_서울10반_이준범 {
	
	public static int N;
	public static int[] col;
	public static int cnt;
	
	public static boolean promising(int i) {
		for (int j = 0; j < i; j++) {
			if (col[j] == col[i] || Math.abs(col[i] - col[j]) == i - j)
				return false;
		}
		return true;
	}
	
	public static void nqueen(int i) {
		if (i == N)
			cnt++;
		else {
			for (int j = 0; j < N; j++) {
				col[i] = j;
				if (promising(i))
					nqueen(i + 1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2806.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			cnt = 0;
			N = sc.nextInt();
			col = new int[N];
			nqueen(0);
			System.out.println("#" + test_case + " " + cnt);
		}
		
		sc.close();
	}
	
}
