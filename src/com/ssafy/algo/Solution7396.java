package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Solution7396 {
	
	public static StringBuffer ans;
	public static int n, m, cnt;
	public static char[][] word;
	public static int front, rear;
	public static int[][] queue;
	public static int[][] dir = { {0, 1}, {1, 0} };
	
	public static void bfs() {
		while (front != rear) {
			int[] tmp = queue[++front];
			int i = tmp[0];
			int j = tmp[1];
			int dd = tmp[2];
			int c = tmp[4];
			if (c == cnt) {
				char min = 'z';
				for (int k = 0; k < front; k++) {
					if (queue[k][3] < min) {
						i = queue[k][0];
						j = queue[k][1];
						min = (char)queue[k][4];
					}
				}
				ans.append(min);
				
				front = rear = -1;
				queue[++rear] = new int[] { i+dir[dd][0], j+dir[dd][1], 0, 0, word[i][j] };
			}
			for (int d = 0; d < dir.length; d++) {
				int ii = i + dir[d][0];
				int jj = j + dir[d][1];
				if (ii < n && jj < m)
					queue[++rear] = new int[] { ii, jj, d, c+1, word[ii][jj] };
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input7396.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			ans = new StringBuffer();
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			word = new char[n][m];
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < m; j++)
					word[i][j] = line.charAt(j);
			}
			cnt = 1;
			front = rear = -1;
			queue = new int[n*m][5];
			queue[++rear] = new int[] { 0, 0, 0, 0, word[0][0] };
			bfs();
			bw.write("#" + test_case + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
