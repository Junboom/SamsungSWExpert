package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution3499 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3499.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			String[] words = new String[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				words[i] = st.nextToken();
			for (int i = 0; i < N/2; i++) {
				sb.append(" ").append(words[i]);
				sb.append(" ").append(words[(N+1)/2+i]);
			}
			if (N % 2 == 1)
				sb.append(" ").append(words[N/2]);
			bw.write("#" + test_case + sb.toString() + "\n");
			bw.flush();
		}
		
		bw.close();
		br.close();
	}
	
}
