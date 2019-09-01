package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution4261_빠른휴대전화키패드_서울10반_이준범 {
	
	public static char[][] k = {{'a', 'b', 'c'}, {'d', 'e', 'f'},
								{'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
								{'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input4261.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				String w = st.nextToken();
				if (w.length() != s.length())
					continue;
				
				int cnt = 0;
				for (int j = 0; j < w.length(); j++) {
					int idx = s.charAt(j) - '2';
					for (int c = 0; c < k[idx].length; c++) {
						if (k[idx][c] == w.charAt(j))
							cnt++;
					}
				}
				if (cnt == w.length())
					ans++;
			}
			
			bw.write("#" + test_case + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
