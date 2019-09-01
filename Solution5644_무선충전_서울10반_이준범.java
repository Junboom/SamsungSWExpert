package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Solution5644_무선충전_서울10반_이준범 {
	
	public static List<Integer>[][] map;
	public static int m, a;
	public static int[] move_a, move_b;
	public static int[][] bc;
	public static int[][] dir = { {0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1} };	// 상(1), 우(2), 하(3), 좌(4)
	
	public static int go(int i_a, int j_a, int i_b, int j_b, int cnt, int ans) {
		if (cnt > m)
			return ans;
		
		int max = 0;
		if (map[i_a][j_a].isEmpty()) {
			for (int i = 0; i < map[i_b][j_b].size(); i++) {
				int ap = map[i_b][j_b].get(i);
				max = (max < bc[ap][3]) ? bc[ap][3] : max;
			}
		}
		else if (map[i_b][j_b].isEmpty()) {
			for (int i = 0; i < map[i_a][j_a].size(); i++) {
				int ap = map[i_a][j_a].get(i);
				max = (max < bc[ap][3]) ? bc[ap][3] : max;
			}
		}
		else {
			for (int i = 0; i < map[i_a][j_a].size(); i++) {
				for (int j = 0; j < map[i_b][j_b].size(); j++) {
					int ap1 = map[i_a][j_a].get(i);
					int ap2 = map[i_b][j_b].get(j);
					int val = (ap1 == ap2) ? bc[ap1][3] : bc[ap1][3]+bc[ap2][3];
					max = (max < val) ? val : max;
				}
			}
		}
		return go(i_a+dir[move_a[cnt]][0], j_a+dir[move_a[cnt]][1],
				  i_b+dir[move_b[cnt]][0], j_b+dir[move_b[cnt]][1], cnt+1, ans+max);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());		// 이동 거리
			a = Integer.parseInt(st.nextToken());		// 무선 통신 개수
			move_a = new int[m+1];
			move_b = new int[m+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++)
				move_a[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++)
				move_b[i] = Integer.parseInt(st.nextToken());
			bc = new int[a][4];
			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++)
					bc[i][j] = Integer.parseInt(st.nextToken());
			}
			map = new ArrayList[10][10];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++)
					map[i][j] = new ArrayList<>();
			}
			for (int k = 0; k < a; k++) {
				for (int i = -bc[k][2]; i <= bc[k][2]; i++) {
					for (int j = -bc[k][2]; j <= bc[k][2]; j++) {
						int ii = bc[k][1] + i - 1;
						int jj = bc[k][0] + j - 1;
						if (0 <= ii && ii < 10 && 0 <= jj && jj < 10 &&
								Math.abs(i)+Math.abs(j) <= bc[k][2])	// 다이아몬드
							map[ii][jj].add(k);
					}
				}
			}
			bw.write("#" + test_case + " " + go(0, 0, 9, 9, 0, 0) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
