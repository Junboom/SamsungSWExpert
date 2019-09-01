package com.ssafy.algo;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6808 {
	
	public static int max;
	
	public static int pac(int num) {
		int result = 1;
		for (int i = num; i > 1; i--)
			result *= i;
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input6808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		max = pac(9);
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int Answer = 0;
			int[] myCards = new int[9];
			for (int i = 0; i < 9; i++)
				myCards[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(myCards);
			System.out.println(Arrays.toString(myCards));
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (9 <= idx)
					break;
				if (i == myCards[idx]) {
					idx++;
					Answer += pac(i - idx);
				}
			}
			
			System.out.println("#" + test_case + " " + Answer + " " + (max-Answer));
		}
		
		br.close();
	}
	
}
