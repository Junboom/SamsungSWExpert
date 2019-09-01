package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution7102 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input7102.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int min = Math.min(N, M) + 1;
			int inside = Math.abs(N-M);
			StringBuilder sb = new StringBuilder();
			for (int i = min; i <= min+inside; i++)
				sb.append(" ").append(i);
			bw.write("#" + test_case + sb.toString() + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
