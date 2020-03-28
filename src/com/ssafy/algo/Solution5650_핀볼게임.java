package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Solution5650_핀볼게임 {
	
	public static int turn(int d, int n, int s, int w, int e) {
		switch (d) {
		case 0:		d = n;	break;
		case 1:		d = s;	break;
		case 2:		d = w;	break;
		case 3:		d = e;	break;
		}
		return d;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5650.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
		int t = Integer.parseInt(br.readLine().trim());
		
		for (int t_c = 1; t_c <= t; t_c++) {
			int ans = 0;
			int n = Integer.parseInt(br.readLine().trim());
			int[][] map = new int[n+2][n+2];
			int[][][] worm = new int[11][2][2];
			boolean[] worm_v = new boolean[11];
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (6 <= map[i][j]) {
						if (worm_v[map[i][j]]) {
							worm[map[i][j]][1][0] = i;
							worm[map[i][j]][1][1] = j;
						}
						else {
							worm[map[i][j]][0][0] = i;
							worm[map[i][j]][0][1] = j;
							worm_v[map[i][j]] = true;
						}
					}
				}
			}
			for (int i = 0; i < n+2; i++) {
				map[0][i] = 5;
				map[i][0] = 5;
				map[n+1][i] = 5;
				map[i][n+1] = 5;
			}
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][j] != 0)
						continue;
					for (int d = 0; d < dir.length; d++) {
						int ii = i;
						int jj = j;
						int dd = d;
						loop:for (int c = 0; ; c++) {
							do {
								ii += dir[dd][0];
								jj += dir[dd][1];
								if (ii == i && jj == j) {
									ans = (ans < c) ? c : ans;
									break loop;
								}
							} while (map[ii][jj] == 0);
								 if (map[ii][jj] == 1)	dd = turn(dd, 1, 3, 0, 2);
							else if (map[ii][jj] == 2)	dd = turn(dd, 3, 0, 1, 2);
							else if (map[ii][jj] == 3)	dd = turn(dd, 2, 0, 3, 1);
							else if (map[ii][jj] == 4)	dd = turn(dd, 1, 2, 3, 0);
							else if (map[ii][jj] == 5)	dd = turn(dd, 1, 0, 3, 2);
							else if (map[ii][jj] >= 6) {
								int[] tmp0 = worm[map[ii][jj]][0];
								int[] tmp1 = worm[map[ii][jj]][1];
								if (tmp0[0] == ii && tmp0[1] == jj) {
									ii = tmp1[0];
									jj = tmp1[1];
								}
								else {
									ii = tmp0[0];
									jj = tmp0[1];
								}
								c--;
							}
							else if (map[ii][jj] == -1) {
								ans = (ans < c) ? c : ans;
								break;
							}
						}
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t_c).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
