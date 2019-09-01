package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution7234_안전기지_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input7234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int[][] map = new int[N+1][N+1];
			for (int b = 0; b < B; b++) {
				st = new StringTokenizer(br.readLine());
				int pos1 = Integer.parseInt(st.nextToken());
				int pos2 = Integer.parseInt(st.nextToken());
				for (int i = pos1-2; i <= pos1+2; i++) {
					if (1 <= i && i <= N && i != pos1)
						map[i][pos2]++;
				}
				for (int j = pos2-2; j <= pos2+2; j++) {
					if (1 <= j && j <= N && j != pos2)
						map[pos1][j]++;
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (Answer < map[i][j])
						Answer = map[i][j];
				}
			}
			bw.write("#" + test_case + " " + Answer + "\n");
			bw.flush();
		}
		
		bw.close();
		br.close();
	}
	
}
