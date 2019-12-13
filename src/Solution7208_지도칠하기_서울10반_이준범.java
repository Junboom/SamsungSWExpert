package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution7208_지도칠하기_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input7208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			int N = Integer.parseInt(br.readLine());
			int[] color = new int[N];
			boolean[] colorCheck = new boolean[N];
			int[] map = new int[N*N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				color[i] = Integer.parseInt(st.nextToken());
				colorCheck[color[i]-1] = true;
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i*N+j] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				int[] stack = new int[N];
				int top = -1;
				for (int j = i+1; j < N; j++) {
					if (map[i*N+j] == 1)
						stack[++top] = j;
				}
				loop:while (0 <= top) {
					int temp = stack[top--];
					if (color[temp] != color[i])
						continue;
					
					for (int c = 0; c < N; c++) {
						if (!colorCheck[c]) {
							colorCheck[c] = true;
							color[temp] = color[c] + 1;
							Answer++;
							break loop;
						}
					}
				}
			}
			
			bw.write("#" + test_case + " " + Answer + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
