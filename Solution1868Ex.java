package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1868Ex {

	public static int Answer, N;
	public static char[] map;
	public static boolean[] visited;
	public static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1},
								 { 0, -1},			{ 1, 1},
								 { 1, -1}, { 1, 0}, { 1, 1}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1868.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			Answer = 0;
			N = Integer.parseInt(br.readLine());
			map = new char[N*N];
			visited = new boolean[N*N];
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++)
				sb.append(br.readLine());
			map = sb.toString().toCharArray();
			for (int n = 0; n < N*N; n++) {
				if (map[n] == '.') {
					int sum = 0;
					for (int d = 0; d < dir.length; d++) {
						int ii = n/N + dir[d][0];
						int jj = n%N + dir[d][1];
						if (0 <= ii && ii < N && 0 <= jj && jj < N && map[ii*N+jj] == '*')
							sum++;
					}
					map[n] = (char)(sum + '0');
					if (map[n] != '0')
						visited[n] = true;
				}
			}
			
			for (int n = 0; n < N*N; n++) {
				if (map[n] == '*')
					continue;
				else if (map[n] == '0') {
					int cnt = 0;
					for (int d = 0; d < dir.length; d++) {
						int ii = n/N + dir[d][0];
						int jj = n%N + dir[d][1];
						if (0 <= ii && ii < N && 0 <= jj && jj < N && visited[ii*N+jj]) {
							cnt++;
						}
					}
					if (cnt == 0)
						Answer++;
					visited[n] = true;
				}
				else {
					int cnt = 0;
					for (int d = 0; d < dir.length; d++) {
						int ii = n/N + dir[d][0];
						int jj = n%N + dir[d][1];
						if (0 <= ii && ii < N && 0 <= jj && jj < N && map[ii*N+jj] == '0')
							cnt++;
					}
					if (cnt == 0)	// 팔방 모두 0이 아님
						Answer++;
				}
			}
			
			bw.write("#" + test_case + " " + Answer + "\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	
}
