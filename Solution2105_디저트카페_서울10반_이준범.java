package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Solution2105_디저트카페_서울10반_이준범 {
	
	public static int ans, n;
	public static int[][] cafe;
	public static boolean[] num;
	public static int[][] dir = { {1, 1}, {1, -1}, {-1, -1}, {-1, 1} };
	
	public static void dfs(int init, int i, int j, int ds, int de, int cnt) {
		if (init == i*n+j && ds == 3) {
			ans = (ans < cnt) ? cnt : ans;
			return;
		}
		
		for (int d = ds; d < de; d++) {
			int ii = i + dir[d][0];
			int jj = j + dir[d][1];
			if (0 <= ii && ii < n && 0 <= jj && jj < n && !num[cafe[ii][jj]]) {
				num[cafe[ii][jj]] = true;
					 if (d == 0)	dfs(init, ii, jj, 0, 2, cnt+1);
				else if (d == 1)	dfs(init, ii, jj, 1, 3, cnt+1);
				else if (d == 2)	dfs(init, ii, jj, 2, 4, cnt+1);
				else if (d == 3)	dfs(init, ii, jj, 3, 4, cnt+1);
				num[cafe[ii][jj]] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2105.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			ans = -1;
			n = Integer.parseInt(br.readLine());
			cafe = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					cafe[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < n-2; i++) {
				for (int j = 1; j < n-1; j++) {
					num = new boolean[101];
					dfs(i*n+j, i, j, 0, 2, 0);
				}
			}
			bw.write("#" + test_case + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
