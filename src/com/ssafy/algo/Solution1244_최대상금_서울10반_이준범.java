package com.ssafy.algo;

import java.io.*;

public class Solution1244_최대상금_서울10반_이준범 {
	
	public static int n, index[];
	
	public static void swap(int i1, int i2) {
		int temp = index[i1];
		index[i1] = index[i2];
		index[i2] = temp;
	}
	
	public static String max(String s) {
		int sl = s.length();
		index = new int[sl];
		int[] change = new int[sl];
		int next = 0;
		
		for (int i = 0; i < sl; i++)
			index[i] = s.charAt(i) - '0';
		for (int i = 0; i < n+next; i++) {
			int max = 0, mi = 0;
			for (int j = i; j < sl; j++) {
				if (max <= index[j]) {
					max = index[j];
					mi = j;
				}
			}
			if (i < sl) {
				if (index[i] == max)
					next++;
				change[i] = max;
				swap(i, mi);
			}
			else
				swap(sl-1, sl-2);
		}
		if (n < sl) {
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					if (index[sl-j-1] < index[sl-i-1] && change[i] == change[j])
						swap(sl-i-1, sl-j-1);
				}
			}
		}
		
		s = new String();
		for (int i = 0; i < sl; i++)
			s += index[i] + "";
		return s;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1244.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] input = br.readLine().split(" ");
			StringBuffer sb = new StringBuffer();
			sb.append(input[0]);
			n = Integer.parseInt(input[1]);
			System.out.println("#" + test_case + " " + max(sb.toString()));
		}
		br.close();
	}
	
}
