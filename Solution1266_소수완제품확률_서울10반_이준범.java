package com.ssafy.algo;

import java.io.*;

public class Solution1266_소수완제품확률_서울10반_이준범 {
	
	public static int n = 18;
	public static int[] prime = new int[] { 2, 3, 5, 7, 11, 13, 17 };
	
	public static double nCr(int n, int r) {
		if (n < r)		return 0;
		if (r == 0)		return 1.0;
		return nCr(n-1, r-1) + nCr(n-1, r);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1266.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] prob = br.readLine().split(" ");
			double a = Double.parseDouble(prob[0]) / 100.0;
			double b = Double.parseDouble(prob[1]) / 100.0;
			double A = 0;
			double B = 0;
			
			for (int i = 0; i < prime.length; i++) {
				int r = prime[i];
				A += nCr(n, r) * Math.pow(a, r) * Math.pow(1.0-a, n-r);
				B += nCr(n, r) * Math.pow(b, r) * Math.pow(1.0-b, n-r);
			}

			double Answer = 1 - ((1-A) * (1-B));
			System.out.printf("#%d %.6f\n", test_case, Answer);
		}
		
		br.close();
	}
	
}
