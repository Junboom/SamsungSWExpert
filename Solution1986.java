package com.ssafy.algo;

import java.io.*;

public class Solution1986 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1986.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			int N = Integer.parseInt(br.readLine());
														Answer = (N+1) / 2;
			if (N % 2 == 0)								Answer *= -1;
			System.out.println("#" + test_case + " " + 	Answer);
		}
		
		br.close();
	}
	
}
