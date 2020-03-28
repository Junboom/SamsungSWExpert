package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution5656_벽돌깨기_서울10반_이준범 {
	
	public static int ans, n, h, w;
	public static int[][] tet;
	public static int[][] dir = { {-1, 0}, {0, -1}, {0, 1}, {1, 0} };
	
	public static void copyArray(int[][] a, int[][] b) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++)
				b[i][j] = a[i][j];
		}
	}
	
	public static void boom(int i, int j, int[][] copy) {
		int ce = copy[i][j];
		copy[i][j] = 0;
		for (int c = 1; c < ce; c++) {
			for (int d = 0; d < dir.length; d++) {
				int ii = i + dir[d][0]*c;
				int jj = j + dir[d][1]*c;
				if (0 <= ii && ii < h && 0 <= jj && jj < w && copy[ii][jj] != 0)
					boom(ii, jj, copy);
			}
		}
	}
	
	public static void down(int[][] copy) {
		for (int j = 0; j < w; j++) {
			for (int i = h-1; i > 0; i--) {
				if (copy[i][j] == 0) {
					for (int k = i-1; k >= 0; k--) {
						if (copy[k][j] != 0) {
							copy[i][j] = copy[k][j];
							copy[k][j] = 0;
							break;
						}
					}
				}
			}
		}
	}
	
	public static void count(int[][] copy) {
		int tmp = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (copy[i][j] != 0)
					tmp++;
			}
		}
		ans = (ans > tmp) ? tmp : ans;
	}
	
	public static void drop(int c, int[][] copy) {
		if (ans == 0)
			return;
		if (c == 0) {
			count(copy);
			return;
		}

		for (int j = 0; j < w; j++) {
			// 열이 j일때 떨어질 수 있는 행 찾고 새로운 클론배열 만들어서 걔를 boom 해주고 down해주고 새로 재귀를 호출해준다.
			int[][] copy2 = new int[h][w];
			copyArray(copy, copy2);
			for (int i = 0; i < h; i++) {
				if (copy[i][j] != 0) {
					boom(i, j, copy2);
					break;
				}
			}
			down(copy2);
			drop(c-1, copy2);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			ans = 987654321;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			tet = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++)
					tet[i][j] = Integer.parseInt(st.nextToken());
			}
			drop(n, tet);
			bw.write("#" + test_case + " " + (ans=(ans==987654321)?0:ans) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
