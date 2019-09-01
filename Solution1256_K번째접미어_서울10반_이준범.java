package com.ssafy.algo;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution1256_K번째접미어_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1256.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int K = Integer.parseInt(br.readLine());
			String s = br.readLine();
			String[] sa = new String[s.length()];
			List<String> l = new ArrayList<>();
			for (int i = 0; i < s.length(); i++) {
				sa[i] = s.substring(i);
				l.add(sa[i]);
			}
			l.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			System.out.println("#" + test_case + " " + l.get(K-1));
		}
		
		br.close();
	}
	
}
