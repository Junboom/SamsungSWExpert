package com.ssafy.algo;

import java.io.*;

public class Solution5607_조합_서울10반_이준범 {
	
	public static long mod = 1234567891;
	
	public static long fac(long i) {
		long temp = 1;
		for (int j = 2; j <= i; j++)
			temp = (temp * j) % mod;
		return temp;
	}
	
	public static long exp(long i, long j) {
		long temp = 1;
		do {
			if (j % 2 != 0)					// 지수가 홀수면
				temp = (temp * i) % mod;	// 나중에 곱해줄 변수에 저장.
			i = (i * i) % mod;				// 일단 제곱을 지수에서 빼주고
		} while ((j /= 2) > 1);				// 지수가 1보다 크면 계속.
		
		return (i * temp) % mod;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5607.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] num = br.readLine().split(" ");
			long N = Integer.parseInt(num[0]);
			long R = Integer.parseInt(num[1]);
			long Answer = (((fac(N) * exp(fac(N-R), mod-2)) % mod) * exp(fac(R), mod-2)) % mod;
			System.out.println("#" + test_case + " " + Answer);
		}
		br.close();
	}
	
}
