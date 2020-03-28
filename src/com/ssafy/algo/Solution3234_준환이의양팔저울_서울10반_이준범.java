package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Solution3234_준환이의양팔저울_서울10반_이준범 {
	
	public static int ans;
	
	public static void rec(int[] w, boolean[] v, int r, int l, int c) {
		if (l < r)	return;
		if (c == w.length) {
			ans++;
			return;
		}
		
		for (int i = 0; i < w.length; i++) {
			if (v[i])	continue;
			v[i] = true;
			rec(w, v, r, l+w[i], c+1);
			rec(w, v, r+w[i], l, c+1);
			v[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			ans = 0;
			int n = Integer.parseInt(br.readLine());
			int[] w = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				w[i] = Integer.parseInt(st.nextToken());
			rec(w, new boolean[n], 0, 0, 0);
			bw.write("#" + test_case + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
