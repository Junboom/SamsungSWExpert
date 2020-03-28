package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution7236_저수지의물의총깊이구하기_서울10반_이준범 {

	public static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1},
								 { 0, -1},			{ 1, 1},
								 { 1, -1}, { 1, 0}, { 1, 1}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input7236.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			int N = Integer.parseInt(br.readLine());
			char[][] lake = new char[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					lake[i][j] = st.nextToken().charAt(0);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (lake[i][j] == 'W') {
						int cnt = 0;
						for (int d = 0; d < dir.length; d++) {
							int ii = i + dir[d][0];
							int jj = j + dir[d][1];
							if (0 <= ii && ii < N && 0 <= jj && jj < N && lake[ii][jj] == 'W')
								cnt++;
						}
						if (Answer < cnt)
							Answer = cnt;
					}
				}
			}
			if (Answer == 0)
				Answer++;
			bw.write("#" + test_case + " " + Answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}
