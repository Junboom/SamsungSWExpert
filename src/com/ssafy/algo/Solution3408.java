package com.ssafy.algo;

import java.io.*;

public class Solution3408 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3408.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			long n = Long.parseLong(br.readLine());
			long ans = n*n;
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case)
			  .append(" ").append((ans+n)/2)
			  .append(" ").append(ans)
			  .append(" ").append(ans+n)
			  .append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
