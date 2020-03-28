package com.ssafy.algo;

import java.io.*;

public class Solution6809 {
	
	public static int Answer, N;
	
	public static void trans(int[] e, int n) {
		if (N <= n) {
			if (Answer < e[N-1])
				Answer = e[N-1];
			return;
		}
		int range = 0;
		for (int i = 0; i < 4; i++) {
			if (n-1+i*2 < N && (range+=e[n-1+i*2]) < i+1) {
				trans(e, n+1);
				return;
			}
		}
		if (e[n] != 0 && e[n-1] > e[n]) {
			trans(e, n+1);
			return;
		}
		
		e[n] += e[n-2];
		e[n-1] -= 1;
		e[n-2] = 0;
		trans(e, n+1);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input6809.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			Answer = 0;
			N = Integer.parseInt(br.readLine());
			int[] energy = new int[N];
			int[] copy = new int[N];
			String[] energes = br.readLine().split(" ");
			for (int i = 0; i < N; i++)
				energy[i] = Integer.parseInt(energes[i]);
			System.arraycopy(energy, 0, copy, 0, N);
			
			trans(energy, 2);
			trans(copy, 3);
			System.out.println("#" + test_case + " " + Answer);
		}
		
		br.close();
	}
	
}
