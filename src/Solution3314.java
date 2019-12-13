package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution3314 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3314.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 5; i++) {
				int score = Integer.parseInt(st.nextToken());
				if (score < 40)	Answer += 40;
				else			Answer += score;
			}
			
			bw.write("#" + test_case + " " + (Answer/5) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
