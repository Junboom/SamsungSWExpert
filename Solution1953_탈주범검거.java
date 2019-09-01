package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Solution1953_탈주범검거 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int[][] dir = { {0, 1}, {1, 0}, {0, -1}, {-1, 0}, {0, 1} };
		int t = Integer.parseInt(br.readLine());
		
		for (int t_c = 1; t_c <= t; t_c++) {
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < m; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			int[][] q = new int[n*m][3];
			int front, rear;
			front = rear = -1;
			boolean[][] v = new boolean[n][m];
			Set<Integer> pos = new HashSet<>();
			
			q[++rear][0] = r;
			q[rear][1] = c;
			q[rear][2] = l - 1;
			v[r][c] = true;
			while (front != rear) {
				int[] tmp = new int[3];
				tmp[0] = q[++front][0];
				tmp[1] = q[front][1];
				tmp[2] = q[front][2];
				pos.add(tmp[0]*m + tmp[1]);
				if (tmp[2] == 0)
					continue;
				
				int sd, ed, except;
				sd = ed = except = -1;
				switch (map[tmp[0]][tmp[1]]) {
				case 1:		sd = 0; ed = 4; except = -1;	break;
				case 2:		sd = 1; ed = 4; except =  2;	break;
				case 3:		sd = 0; ed = 3; except =  1;	break;
				case 4:		sd = 3; ed = 5; except = -1;	break;
				case 5:		sd = 0; ed = 2; except = -1;	break;
				case 6:		sd = 1; ed = 3; except = -1;	break;
				case 7:		sd = 2; ed = 4; except = -1;	break;
				}
				
				for (int d = sd; d < ed; d++) {
					if (d == except)
						continue;
					int i = tmp[0] + dir[d][0];
					int j = tmp[1] + dir[d][1];
					if (0 <= i && i < n && 0 <= j && j < m && !v[i][j]) {
						if (map[i][j] != 1) {
							if ((d == 0 || d == 4) && !(map[i][j] == 3 || map[i][j] == 6 || map[i][j] == 7))	continue;
							if (d == 1 && !(map[i][j] == 2 || map[i][j] == 4 || map[i][j] == 7))	continue;
							if (d == 2 && !(map[i][j] == 3 || map[i][j] == 4 || map[i][j] == 5))	continue;
							if (d == 3 && !(map[i][j] == 2 || map[i][j] == 5 || map[i][j] == 6))	continue;
						}
						
						q[++rear][0] = i;
						q[rear][1] = j;
						q[rear][2] = tmp[2] - 1;
						v[i][j] = true;
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t_c).append(" ").append(pos.size()).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
