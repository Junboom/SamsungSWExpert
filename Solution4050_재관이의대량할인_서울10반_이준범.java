package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Solution4050_재관이의대량할인_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input4050.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			int ans = 0;
			int n = Integer.parseInt(br.readLine());
			List<Integer> cloth = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				cloth.add(Integer.parseInt(st.nextToken()));
			Collections.sort(cloth, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			for (int i = 0; i < cloth.size(); i++) {
				if (i % 3 == 2)
					continue;
				ans += cloth.get(i);
			}
			bw.write("#" + test_case + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
