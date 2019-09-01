package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution6913 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input6913.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			int per = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int cnt = 0;
				for (int j = 0; j < M; j++) {
					if (st.nextToken().equals("1"))
						cnt++;
				}
				if (Answer < cnt) {
					Answer = cnt;
					per = 0;
				}
				if (Answer == cnt)
					per++;
			}

			System.out.println("#" + test_case + " " + per + " " + Answer);
		}
		
		br.close();
	}
	
}
