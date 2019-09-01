package com.ssafy.algo;

import java.io.*;
import java.util.Scanner;

public class Solution4796_의석이의우뚝선산_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input4796.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int test_case = 1; test_case <= t; test_case++) {
			int ans = 0;
			int n = sc.nextInt();
			int[] m = new int[n+1];
			int cnt = 0;
			for (int i = 1; i <= n; i++)
				m[i] = sc.nextInt();
			for (int i = 2; i <= n; i++) {
				if (m[i-2] < m[i-1])
					cnt++;
				else {
					ans += (cnt - 1);
					cnt = (m[i-1] < m[i]) ? 1 : cnt;
				}
			}
			ans += (m[n-1] < m[n]) ? 0 : cnt-1;
			System.out.println("#" + test_case + " " + ans);
		}

		sc.close();
	}
	
}
