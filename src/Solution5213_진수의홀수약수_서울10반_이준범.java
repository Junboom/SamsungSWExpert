package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution5213_진수의홀수약수_서울10반_이준범 {
	
	public static int N = 1000000;
	public static long[] sumArr = new long[N+1];
	public static long[] Answer = new long[N+1];
	
	public static void sum() {
		for (int i = 1; i <= N; i+=2) {
			for (int j = i; j <= N; j+=i)
				sumArr[j] += i;
		}
		for (int i = 1; i <= N; i++)
			Answer[i] = Answer[i-1] + sumArr[i];
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5213.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sum();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println("#" + test_case + " " + (Answer[end]-Answer[start-1]));
		}
		
		br.close();
	}
	
}
