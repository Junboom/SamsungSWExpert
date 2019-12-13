package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1952_수영장_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			int[] cost = new int[4];
			int[] mon = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++)
				cost[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++)
				mon[i] = Integer.parseInt(st.nextToken());
			
			int[] dp = new int[13];
			for (int j = 1; j <= 12; j++) {
							dp[j] = dp[j-1] + ((mon[j]*cost[0] < cost[1]) ? mon[j]*cost[0] : cost[1]);
				if (3 <= j)	dp[j] = (dp[j] < dp[j-3]+cost[2]) ? dp[j] : dp[j-3]+cost[2];
			}				dp[12] = (dp[12] < cost[3]) ? dp[12] : cost[3];
			
			bw.write("#" + test_case + " " + dp[12] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
