package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution3975 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3975.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String Answer = "";
			int[] win = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++)
				win[i] = Integer.parseInt(st.nextToken());
			if (win[0] * win[3] > win[1] * win[2])		Answer = "ALICE";
			else if (win[0] * win[3] < win[1] * win[2])	Answer = "BOB";
			else										Answer = "DRAW";
			bw.write("#" + test_case + " " + Answer + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
