package com.ssafy.algo;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution5953 {
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/Solution5953.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 1;
			char[] s = sc.next().toCharArray();
			int[] ia = new int[s.length];
			for (int i = 0; i < s.length; i++)
				ia[i] = s[i] - '0';

			for (int j = s.length-1; j >= 0; j--) {
				for (int i = 0; i < 10; i++) {
					Answer += Math.pow(10, s.length-2-j) + i;
					if (ia[j] == i)
						break;
				}
			}

			System.out.println("#" + test_case + " " + Answer);
		}
		
		sc.close();
		
	}
}
