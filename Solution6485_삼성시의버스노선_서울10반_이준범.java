package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution6485_삼성시의버스노선_서울10반_이준범 {

	public static int[] busStop;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input6485.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			busStop = new int[5001];
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				for (int j = start; j <= end; j++)
					busStop[j]++;
			}

			StringBuilder sb = new StringBuilder();
			int P = Integer.parseInt(br.readLine());
			for (int c = 0; c < P; c++)
				sb.append(" ").append(busStop[Integer.parseInt(br.readLine())]);
			System.out.println("#" + test_case + sb.toString());
		}

		br.close();
	}

}
