package com.ssafy.algo;

import java.io.*;

public class Solution6718 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input6718.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			double num = Double.parseDouble(br.readLine());
			if		(num < 100.0)		Answer = 0;
			else if	(num < 1000.0)		Answer = 1;
			else if (num < 10000.0)		Answer = 2;
			else if (num < 100000.0)	Answer = 3;
			else if (num < 1000000.0)	Answer = 4;
			else						Answer = 5;
			System.out.println("#" + test_case + " " + Answer);
		}
		
		br.close();
	}
	
}
