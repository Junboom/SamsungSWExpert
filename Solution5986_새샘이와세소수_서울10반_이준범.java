package com.ssafy.algo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution5986_새샘이와세소수_서울10반_이준범 {
	
	public static int Answer, N;
	public static List<Integer> list;
	
	public static void prime() {
		list.add(2);
		loop:for (int i = 3; i < 1000; i++) {
			if (i % 2 == 0)
				continue;
			for (int j = 2; j < i; j++) {
				if (i % j == 0)
					continue loop;
			}
			list.add(i);
		}
	}
	
	public static void comb(int before, int count, int primeSum) {
		if (count > 2) {
			if (primeSum == N)
				Answer++;
			return;
		}
		
		for (int i = before; i < list.size(); i++) {
			if (N < primeSum+list.get(i))
				return;
			comb(i, count+1, primeSum+list.get(i));
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5986.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		prime();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			Answer = 0;
			N = Integer.parseInt(br.readLine());
			comb(0, 0, 0);
			System.out.println("#" + test_case + " " + Answer);
		}
		
		br.close();
	}
	
}
