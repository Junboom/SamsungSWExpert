package com.ssafy.algo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1808_지희의고장난계산기_서울10반_이준범 {
	
	public static int INF = 987654321;
	public static int ans, x;
	public static List<Integer> list;
	
	public static boolean canPush(int n) {
		while (0 < n) {
			int idx = n % 10;
			if (list.contains(idx))	n /= 10;
			else					return false;
		}
		return true;
	}
	
	public static void calc(int n, int cnt) {
		if (canPush(n)) {
			ans = Math.min(ans, cnt+String.valueOf(n).length()+1);
			return;
		}
		
		for (int i = n/2; i > 1; i--) {
			if (n % i == 0 && canPush(i))
				calc(n/i, cnt+String.valueOf(i).length()+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			ans = INF;
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				if (Integer.parseInt(st.nextToken()) == 1)
					list.add(i);
			}
			x = Integer.parseInt(br.readLine());
			calc(x, 0);
			bw.write("#" + test_case + " " + ((ans==INF)?-1:ans) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
