package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1865_동철이의일분배_서울10반_이준범 {
	
	public static double ans;
	public static int n;
	public static double[][] work;
	public static boolean[] w;

	public static void dfs(int i, double temp) {
		if (i == n || temp <= ans) {
			ans = Math.max(ans, temp);
			return;
		}
		
		for (int j = 0; j < n; j++) {
			if (!w[j]) {
				w[j] = true;
				dfs(i+1, temp*work[i][j]);
				w[j] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1865.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			ans = 0;
			n = Integer.parseInt(br.readLine());
			work = new double[n][n];
			w = new boolean[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					String s = st.nextToken();
					work[i][j] = (s.length() == 3) ? 1.0 :
								 (s.length() == 2) ? Double.parseDouble("0." + s) :
									 				 Double.parseDouble("0.0" + s);
				}
			}
			dfs(0, 1);
			bw.write("#" + test_case + " " + String.format("%.6f", ans*100) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
