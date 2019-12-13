package com.ssafy.algo;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution6730 {
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input6730.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int max = 0, min = 0;
			int N = sc.nextInt();
			int[] difficulty = new int[N];
			for (int i = 0; i < N; i++) {
				difficulty[i] = sc.nextInt();
			}
			
			for (int i = 1; i < N; i++) {
				if (difficulty[i-1] < difficulty[i])
					if (max < difficulty[i] - difficulty[i-1])
						max = difficulty[i] - difficulty[i-1];
				if (difficulty[i-1] > difficulty[i])
					if (min < difficulty[i-1] - difficulty[i])
						min = difficulty[i-1] - difficulty[i];
			}

			System.out.println("#" + test_case + " " + max + " " + min);
		}
		
		sc.close();
		
	}
}
