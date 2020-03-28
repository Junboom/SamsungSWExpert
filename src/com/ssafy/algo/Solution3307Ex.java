package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution3307Ex {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3307.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			int N = Integer.parseInt(br.readLine());
			int[] num = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				num[i] = Integer.parseInt(st.nextToken());
			
			int[] cnt = new int[N];
			cnt[0] = 1;
			for (int i = 1; i < N; i++) {
				int max = 0;
				for (int j = 0; j < i; j++) {
					if (num[j] < num[i] && max < cnt[j])
						max = cnt[j];
				}
				cnt[i] = max + 1;
				if (Answer < cnt[i])
					Answer = cnt[i];
			}

			System.out.println("#" + test_case + " " + Answer);
		}
		
		br.close();
		
	}
}