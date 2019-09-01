package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution5648_원자소멸시뮬레이션 {
	
	public static int ans, n, nn;
	public static int[][] atom;
	public static boolean[] v;
	public static int[][] dir = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} };
	
	public static void bfs(int f, int r, int[][] q) {
		while (nn != 0) {
			for (int i = 0; i < n; i++) {
				if (!v[i]) {
					atom[i][0] += dir[atom[i][2]][0];
					atom[i][1] += dir[atom[i][2]][1];
				}
			}
			for (int i = 0; i < n; i++) {
				if (!v[i]) {
					if (atom[i][0] < -1000 || 1000 < atom[i][0] || atom[i][1] < -1000 || 1000 < atom[i][1]) {
						v[i] = true;
						nn--;
					}
					for (int j = i+1; j < n; j++) {
						if (atom[i][0] == atom[j][0] && atom[i][1] == atom[j][1] && !v[j]) {
							q[++r][0] = j;
							q[r][1] = atom[j][3];
						}
					}
					if (f != r) {
						v[i] = true;
						ans += atom[i][3];
						nn--;
					}
					while (f != r) {
						v[q[++f][0]] = true;
						ans += q[f][1];
						nn--;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			ans = 0;
			n = Integer.parseInt(br.readLine());
			nn = n;
			atom = new int[n][4];
			v = new boolean[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++)
					atom[i][j] = Integer.parseInt(st.nextToken());
			}
			bfs(-1, -1, new int[1000*1000][2]);
			bw.write("#" + test_case + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
