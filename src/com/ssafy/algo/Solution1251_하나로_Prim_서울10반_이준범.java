package com.ssafy.algo;

import java.io.*;

public class Solution1251_하나로_Prim_서울10반_이준범 {
	
	public static int N;
	public static long[][] Graph;
	public static long[] Weight;
	public static double E;
	
	public static long prim() {
		Weight[0] = 0;
		for (int i = 1; i < N; i++)
			Weight[i] = -1;
		
		for (int k = 1; k < N; k++) {
			long minWeight = Long.MAX_VALUE;
			int minVertax = 0;
			for (int i = 0; i < N; i++) {
				if (Weight[i] < 0) continue;
				for (int j = 0; j < N; j++) {
					if (Weight[j] >= 0)	continue;
					if (Graph[i][j] < minWeight) {
						minVertax = j;
						minWeight = Graph[i][j];
					}
				}
			}
			Weight[minVertax] = minWeight;
		}
		
		long sumCost = 0;
		for (int i = 0; i < N; i++)
			sumCost += Weight[i];
		return Math.round(sumCost * E);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			Graph = new long[N][N];
			Weight = new long[N];
			String[] x = br.readLine().split(" ");
			String[] y = br.readLine().split(" ");
			E = Double.parseDouble(br.readLine());
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j) {
						Graph[i][j] = (long)(Math.pow(Integer.parseInt(x[i])-Integer.parseInt(x[j]), 2) +
								Math.pow(Integer.parseInt(y[i])-Integer.parseInt(y[j]), 2));
					}
				}
			}
			System.out.println("#" + test_case + " " + prim());
		}
		
		br.close();
	}
	
}
