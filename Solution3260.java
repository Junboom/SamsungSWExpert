package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution3260 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3260.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			String num1 = st.nextToken();
			String num2 = st.nextToken();
			int len1 = num1.length();
			int len2 = num2.length();
			int index = 1;
			int temp = 0;
			StringBuilder sb = new StringBuilder();
			while (index <= len1 || index <= len2) {
				int sum = 0;
				if (index <= len1)	sum += (num1.charAt(len1-index) - '0');
				if (index <= len2)	sum += (num2.charAt(len2-index) - '0');
				sb.append(""+(sum+temp)%10);
				if ((sum+temp) / 10 == 1)	temp = 1;
				else						temp = 0;
				index++;
			}
			if (temp == 1)	sb.append(temp);
			StringBuilder ans = new StringBuilder("#").append(test_case).append(" ").append(sb.reverse()).append("\n");
			bw.write(ans.toString());
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
