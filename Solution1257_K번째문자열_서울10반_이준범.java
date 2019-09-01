package com.ssafy.algo;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1257_K번째문자열_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1257.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int K = Integer.parseInt(br.readLine());
			String s = br.readLine();
			Set<String> set = new HashSet<>();
			for (int i = 0; i < s.length(); i++) {
				for (int j = i+1; j <= s.length(); j++)
					set.add(s.substring(i, j));
			}
			List<String> list = new ArrayList<>(set);
			list.sort(new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					return s1.compareTo(s2);
				}
			});
			String Answer = "none";
			if (K < list.size())
				Answer = list.get(K-1);
			System.out.println("#" + test_case + " " + Answer);
		}
		
		br.close();
	}
	
}
