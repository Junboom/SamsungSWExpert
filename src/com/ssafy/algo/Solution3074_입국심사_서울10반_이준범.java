package com.ssafy.algo;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author sense
 *
 * 0에서 최대시간까지 있다.
 * 미드를 찾는다.
 * 정답인지 아닌지 확인
 * 
 *
 */

public class Solution3074_입국심사_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3074.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			long m = Integer.parseInt(st.nextToken());
			long[] t = new long[n];
			long s = 0;
			long e = 0;
			for (int i = 0; i < n; i++) {
				t[i] = Integer.parseInt(br.readLine());
				e = (e < t[i]) ? t[i] : e;
			}
			e *= m;
			
			long sum = 0, per = 0;
			while (s <= e) {
				sum = 0;
				per = (s+e) / 2;
				for (int i = 0; i < n; i++)
					sum += per / t[i];
				if		(m <= sum)	e = per - 1;
				else if (m >  sum)	s = per + 1;
			}
			
			bw.write("#" + test_case + " " + s + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
