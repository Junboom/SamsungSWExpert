package com.ssafy.algo;

import java.io.*;

public class Solution6959 {
	
	public static boolean win;
	
	public static void rec(int[] num, int maxIndex) {
		if (maxIndex <= 1)
			return;
		
		int index1 = maxIndex - 2;
		int index2 = maxIndex - 1;
		int max = num[index1] + num[index2];
		if (max / 10 == 1) {
			num[index1] = max / 10;
			num[index2] = max % 10;
		}
		else {
			num[index1] = max;
			maxIndex--;
		}
		win = !win;
		rec(num, maxIndex);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input6959.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			win = false;
			String s = br.readLine();
			int index = s.length();
			int[] num = new int[index];
			for (int i = 0; i < index; i++)
				num[i] = s.charAt(i) - '0';
			rec(num, index);
			System.out.println("#" + test_case + " " + (win ? "A" : "B"));
		}
		
		br.close();
	}
	
}
