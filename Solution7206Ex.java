package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution7206Ex {
	
	public static int Answer;
	
	public static void cut(String num, int len, int cnt) {
		if (len == 1) {
			if (Answer < cnt)
				Answer = cnt;
			return;
		}
		
		for (int i = 1; i < len; i++) {
			int mul = 0;
			int fir = Integer.parseInt(num.substring(0, i));
			int sec = Integer.parseInt(num.substring(i, len));
			mul = fir * sec;
			cut(""+mul, (""+mul).length(), cnt+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input7206.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			Answer = 0;
			String num = br.readLine();
			int len = num.length();
			cut(num, len, 0);
			bw.write("#" + test_case + " " + Answer + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
