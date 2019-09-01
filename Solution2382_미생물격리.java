package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Solution2382_미생물격리 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2382.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer>[][] map = new ArrayList[100][100];
		int[] v = new int[1000];
		int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
		int t = Integer.parseInt(br.readLine());
		
		for (int t_c = 1; t_c <= t; t_c++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					map[i][j] = new ArrayList<>();
			}
			int[][] be = new int[k][4];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++)
					be[i][j] = Integer.parseInt(st.nextToken());
				be[i][3] = Integer.parseInt(st.nextToken()) - 1;
			}
			while (0 < m) {
				for (int i = 0; i < k; i++) {
					if (v[i] == t_c)	continue;
					be[i][0] += dir[be[i][3]][0];
					be[i][1] += dir[be[i][3]][1];
					if (be[i][0] == 0 || be[i][1] == 0 || be[i][0] == n-1 || be[i][1] == n-1) {
						be[i][2] >>= 1;
						if (be[i][2] == 0) {
							v[i] = t_c;
							continue;
						}
						switch (be[i][3]) {
						case 0:		be[i][3] = 1;	break;
						case 1:		be[i][3] = 0;	break;
						case 2:		be[i][3] = 3;	break;
						case 3:		be[i][3] = 2;	break;
						}
					}
					map[be[i][0]][be[i][1]].add(i);
				}
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (map[i][j].size() != 0) {
							int max_idx = 0;
							int max = 0;
							int sum = 0;
							for (int b = 0; b < map[i][j].size(); b++) {
								int idx = map[i][j].get(b);
								if (max < be[idx][2]) {
									max_idx = idx;
									max = be[idx][2];
								}
								sum += be[idx][2];
							}
							for (int b = 0; b < map[i][j].size(); b++) {
								int idx = map[i][j].get(b);
								if (max_idx == idx)	be[idx][2] = sum;
								else				v[idx] = t_c;
							}
							map[i][j] = new ArrayList<>();
						}
					}
				}
				m--;
			}
			for (int i = 0; i < k; i++) {
				if (v[i] == t_c)	continue;
				ans += be[i][2];
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
