package com.ssafy.algo;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Solution2819_격자판의숫자이어붙이기_서울10반_이준범 {

	public static int N = 4;
	public static int[] pan;
	public static Set<Integer> set;
	
	public static void move(String s, int i, int j, int cnt) {
		if (cnt == 7) {
			set.add(Integer.parseInt(s));
			return;
		}
		if (i < 0 || j < 0 || N <= i || N <= j)
			return;
		
		move(s+pan[i*N+j], i+1, j, cnt+1);
		move(s+pan[i*N+j], i, j+1, cnt+1);
		move(s+pan[i*N+j], i-1, j, cnt+1);
		move(s+pan[i*N+j], i, j-1, cnt+1);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2819.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			pan = new int[N*N];
			set = new HashSet<>();
			for (int i = 0; i < N; i++) {
				String[] num = br.readLine().split(" ");
				for (int j = 0; j < N; j++)
					pan[i*N+j] = Integer.parseInt(num[j]);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					move(new String(), i, j, 0);
			}
			System.out.println("#" + test_case + " " + set.size());
		}
		
		br.close();
	}
	
}
