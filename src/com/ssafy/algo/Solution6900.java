package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution6900 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input6900.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			String[][] lotto = new String[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				lotto[i][0] = st.nextToken();
				lotto[i][1] = st.nextToken();
			}
			String[] my = new String[M];
			for (int i = 0; i < M; i++) {
				my[i] = br.readLine();
				for (int j = 0; j < N; j++) {
					int correct = 0;
					for (int k = 0; k < 8; k++) {
						char c = lotto[j][0].charAt(k);
						if (c == '*' || c == my[i].charAt(k))
							correct++;
					}
					if (correct == 8)
						Answer += Integer.parseInt(lotto[j][1]);
				}
			}

			System.out.println("#" + test_case + " " + Answer);
		}
		
		br.close();
	}
	
}
