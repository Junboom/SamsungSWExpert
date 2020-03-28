package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution3456 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3456.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			int[] square = new int[101];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++)
				square[Integer.parseInt(st.nextToken())]++;
			for (int i = 1; i <= 100; i++) {
				if (square[i] == 1 || square[i] == 3)
					Answer = i;
			}
			bw.write("#" + test_case + " " + Answer + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
