package com.ssafy.algo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution3752_가능한시험점수_서울10반_이준범 {
	
	public static int Answer, N, max;
	public static int[] score;
	public static boolean[] check;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3752.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			Answer = 1;
			N = Integer.parseInt(br.readLine());
			score = new int[N];
			max = 0;
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				score[n] = Integer.parseInt(st.nextToken());
				max += score[n];
			}
			check = new boolean[max+1];
			check[0] = true;
			for (int n = 0; n < N; n++) {
				for (int m = max; m >= 0; m--) {
					if (check[m]) {
						if (!check[m+score[n]])
							Answer++;
						check[m+score[n]] = true;
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
