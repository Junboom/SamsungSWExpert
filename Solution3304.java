package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution3304 {
	
	public static int Answer;
	public static String word1, word2;
	public static int len1, len2;
	public static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3304.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			word1 = st.nextToken();
			word2 = st.nextToken();
			len1 = word1.length();
			len2 = word2.length();
			dp = new int[len1+1][len2+1];
			for (int i = 1; i <= len1; i++) {
				for (int j = 1; j <= len2; j++) {
					dp[i][j] = (word1.charAt(i-1) == word2.charAt(j-1)) ?
							dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			bw.write("#" + test_case + " " + dp[len1][len2] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
