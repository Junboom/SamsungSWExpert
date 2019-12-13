package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1860_진기의최고급붕어빵_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1860.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			String ans = "Possible";
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] sec = new int[11112];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				sec[Integer.parseInt(st.nextToken())]++;
			if (sec[0] != 0) {
				if  (m != 0)
					ans = "Impossible";
			}
			else {
				int per = 0;
				int make = 0;
				for (int i = 1; i <= 11111; i++) {
					boolean order = (i % m == 0);
					if (order && make < per) {
						ans = "Impossible";
						break;
					}
					per += sec[i];
					make += order ? k : 0;
				}
			}
			bw.write("#" + test_case + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
