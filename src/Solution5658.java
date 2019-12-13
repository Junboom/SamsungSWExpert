package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Solution5658 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5658.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int len = n / 4;
			Set<Integer> set = new HashSet<>();
			StringBuilder sb = new StringBuilder().append(br.readLine());
			sb.append(sb.substring(0, len-1));
			for (int i = 0; i < n; i++)
				set.add(Integer.parseInt(sb.substring(i, i+len), 16));
			List<Integer> list = new ArrayList<>(set);
			Collections.sort(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			bw.write("#" + test_case + " " + list.get(k-1) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
