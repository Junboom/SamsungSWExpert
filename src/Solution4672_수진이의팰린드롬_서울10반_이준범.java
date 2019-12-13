package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution4672_수진이의팰린드롬_서울10반_이준범 {
	
	public static int[] sum = { 0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55 };
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input4672.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			int ans = 0;
			String words = br.readLine().trim();
			int[] word = new int[26];
			for (int i = 0; i < words.length(); i++)
				word[words.charAt(i)-'a']++;
			for (int i = 0; i < 26; i++)
				ans += sum[word[i]];
			bw.write("#" + test_case + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
