package com.ssafy.algo;

import java.io.*;

public class Solution2005_파스칼의삼각형_서울10반_이준범 {
	
	public static int max;
	
	public static void pascal(int[] triangle, int top) {
		if (max < top)
			return;
		
		int[] line = new int[top];
		for (int i = 0; i < top; i++) {
			if (i == 0 || i == top-1)	line[i] = 1;
			else						line[i] = triangle[i-1] + triangle[i];
			System.out.print(line[i] + " ");
		}
		System.out.println();
		pascal(line, top+1);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2005.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case);
			max = Integer.parseInt(br.readLine());
			pascal(new int[1], 1);
		}
		
		br.close();
	}
	
}
