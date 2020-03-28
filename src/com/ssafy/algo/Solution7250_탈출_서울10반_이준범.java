package com.ssafy.algo;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7250_탈출_서울10반_이준범 {
	
	public static int ans, n, m, k, idx;
	public static char[][] map_s, map_v;
	public static Queue<int[]> q[];
	public static int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void bfs() {
		loop:while (true) {
			if (q[idx].isEmpty()) {
				if (idx == 1)
					break;
				idx = (idx+1) % 3;
				continue;
			}
			
			int[] temp = q[idx].poll();
			int i = temp[0];
			int j = temp[1];
			int c = temp[2];
			int kk = 0;
			if (idx == 1)
				kk = temp[3];
			
			for (int d = 0; d < dir.length; d++) {
				int ii = i + dir[d][0];
				int jj = j + dir[d][1];
				if (0 <= ii && ii < n && 0 <= jj && jj < m && map_s[ii][jj] != 'X') {
					if (idx == 0) {												// 불
						if (map_s[ii][jj] != 'F' && map_s[ii][jj] != 'W' && map_s[ii][jj] != 'E') {
							q[idx].offer(new int[] {ii, jj, c+1});
							map_s[ii][jj] = 'F';
						}
					}
					else if (idx == 1) {										// 스캇
						if (map_s[ii][jj] == 'A') {
							q[idx].offer(new int[] {ii, jj, c+1, k});
							map_s[ii][jj] = 'S';
						}
						else if (map_s[ii][jj] == 'W' && 0 < kk) {
							q[idx].offer(new int[] {ii, jj, c+1, kk-1});
						}
						else if (map_s[ii][jj] == 'E') {
							ans = c + 2;
							break loop;
						}
					}
					else if (idx == 2) {										// 악당
						if (map_v[ii][jj] == 'A') {
							q[idx].offer(new int[] {ii, jj, c+1});
							map_v[ii][jj] = 'V';
						}
						else if (map_v[ii][jj] == 'E') {
							break loop;
						}
					}
				}
			}
			
			if (q[idx].isEmpty() || q[idx].peek()[2] != c)
				idx = (idx+1) % 3;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input7250.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for (int t_c = 1; t_c <= t; t_c++) {
			ans = -1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			idx = 0;
			map_s = new char[n][m];
			map_v = new char[n][m];
			q = new Queue[3];
			for (int qq = 0; qq < q.length; qq++)
				q[qq] = new LinkedList<>();
			
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < m; j++) {
					char temp = s.charAt(j);
					map_s[i][j] = temp;
					map_v[i][j] = temp;
					switch (map_s[i][j]) {
					case 'F':
						q[0].offer(new int[] {i, j, ans});
						break;
					case 'S':
						q[1].offer(new int[] {i, j, ans, k});
						break;
					case 'V':
						q[2].offer(new int[] {i, j, ans});
						break;
					}
				}
			}
			bfs();
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t_c).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
