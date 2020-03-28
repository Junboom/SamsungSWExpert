package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1494_사랑의카운슬러_서울10반_이준범 {
	
	public static long Answer;
	public static int N;
	public static int[][] pair;
	
	public static void match(int idx, int cnt1, int cnt2, long x, long y) {
		if (cnt1 + cnt2 == N) {
			if (Answer > x * x + y * y)
				Answer = x * x + y * y;
			return;
		}
		
		if (cnt1 < N/2)	match(idx+1, cnt1+1, cnt2, x+pair[idx][0], y+pair[idx][1]);
		if (cnt2 < N/2)	match(idx+1, cnt1, cnt2+1, x-pair[idx][0], y-pair[idx][1]);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1494.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			Answer = Long.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			pair = new int[N][2];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				pair[i][0] = Integer.parseInt(st.nextToken());
				pair[i][1] = Integer.parseInt(st.nextToken());
			}
			
			match(0, 0, 0, 0, 0);
			System.out.println("#" + test_case + " " + Answer);
		}
		
		br.close();
	}
	
}
