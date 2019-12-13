package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1861_정사각형방_서울10반_이준범 {
	
	public static int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			int Max = 0;
			int N = Integer.parseInt(br.readLine());
			int[][] room = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					room[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int ans = 0;
			int cnt = 1;
			boolean first = true;
			int I = 0;
			int J = 0;
			for (int i = 0; i < N; i++) {
				loop:for (int j = 0; j < N; j++) {
					if (first) {
						ans = room[i][j];
						first = false;
						I = i;
						J = j;
					}
					
					for (int n = 0; n < dir.length; n++) {
						int ii = i + dir[n][0];
						int jj = j + dir[n][1];
						if (0 <= ii && ii < N && 0 <= jj && jj < N) {
							if (room[i][j] + 1 == room[ii][jj]) {
								i = ii;
								j = jj-1;
								cnt++;
								continue loop;
							}
						}
					}
					
					if (Max < cnt || (Max == cnt && ans < Answer)) {
						Answer = ans;
						Max = cnt;
					}
					ans = 0;
					cnt = 1;
					first = true;
					i = I;
					j = J;
				}
			}

			System.out.println("#" + test_case + " " + Answer + " " + Max);
		}
		
		br.close();
	}
	
}
