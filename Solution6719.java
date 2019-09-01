package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution6719 {
	
	static int T, N, K;
	static double A;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("Solution6719.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		int[] M, max, min;
		
		for (int t = 1; t <= T; t++) {
			A = 0.0;
			N = sc.nextInt();
			K = sc.nextInt();
			M = new int[N];
			max = new int[K];
			min = new int[K];
			
			for (int n = 0; n < N; n++) {
				M[n] = sc.nextInt();
			}
			
			for (int k = 0; k < K; k++) {
				for (int n = 0; n < N; n++) {
					if (max[k] <= M[n]) {
						max[k] = n;
					}
				}
				for (int n = 0; n < N; n++) {
					if (max[k] == M[n]) {
						M[n] = -1;
						break;
					}
				}
			}
			
			for (int k1 = 0; k1 < K; k1++) {
				for (int k2 = 0; k2 < K; k2++) {
					if (min[k1] > max[k2]) {
						min[k1] = max[k2];
					}
				}
				for (int n = 0; n < N; n++) {
					if (max[n] <= M[n]) {
						A = (A + M[n]) / 2.0;
					}
				}
			}
			
			System.out.println("#" + t + " " + Double.parseDouble(String.format("%.6f", A)));
		}
		
		sc.close();
	}
}
