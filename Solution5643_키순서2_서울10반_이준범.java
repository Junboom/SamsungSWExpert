package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution5643_키순서2_서울10반_이준범 {
	
	public static int ans;
	public static int n, m;
	public static boolean[][] order;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5643.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine().trim());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			ans = 0;
			n = Integer.parseInt(br.readLine().trim());
			m = Integer.parseInt(br.readLine().trim());
			order = new boolean[n+1][n+1];
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine().trim());
				int fir = Integer.parseInt(st.nextToken());
				int sec = Integer.parseInt(st.nextToken());
				order[fir][sec] = true;
			}
			
			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					if (i == k)
						continue;
					for (int j = 1; j <= n; j++) {
						if (j == k || j == i)
							continue;
						if (order[i][k] && order[k][j])
							order[i][j] = true;
					}
				}
			}
			
			for (int i = 1; i <= n; i++) {
				int cnt = 0;
				for (int j = 1; j <= n; j++) {
					if (order[i][j])	cnt++;
					if (order[j][i])	cnt++;
				}
				if (cnt == n-1)
					ans++;
			}
			
			bw.write("#" + test_case + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
