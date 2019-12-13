package com.ssafy.algo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution5986Ex {

	public static int[] primeArr = new int[1000];
	public static int max = 0;
	
	public static boolean isPrime(int num) {
		for (int div = 2; div < num; div++) {
			if (num % div == 0)
				return false;
		}
		return true;
	}
	
	public static void getPrime(int max) {
		primeArr[2] = 1;
		primeArr[3] = 1;
		primeArr[5] = 1;
		
		for (int odd = 7; odd <= max; odd+=2)
			comb(2, 1, 0, odd);
	}
	
	public static void comb(int before, int count, int primeSum, int prime) {
		if (3 < count) {
			if (primeSum == prime)
				primeArr[prime]++;
			return;
		}
		
		for (int i = before; i < prime-3; i++) {
			if (prime < primeSum + i)
				return;
			
			if (primeArr[i] != 0 && isPrime(prime))
				comb(i, count+1, primeSum+i, prime);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5986.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			if (max < N) {
				max = N;
				getPrime(N);
			}
			
			System.out.println("#" + test_case + " " + primeArr[N]);
		}
		
		br.close();
	}
	
}
