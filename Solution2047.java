package com.ssafy.algo;

import java.io.*;

public class Solution2047 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2047.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String change = "";
		for (int i = 0; i < s.length(); i++) {
			int c;
			if ('a' <= s.charAt(i) && s.charAt(i) <= 'z')	c = s.charAt(i) - 32;
			else											c = s.charAt(i);
			change += (char)c;
		}
		System.out.println(change);
		br.close();
	}
	
}
