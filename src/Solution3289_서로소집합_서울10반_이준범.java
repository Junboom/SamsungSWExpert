package com.ssafy.algo;

import java.io.*;

public class Solution3289_서로소집합_서울10반_이준범 {
	
	public static int[] p;
	
	public static int Find(int x) {
		if (x == p[x])	return x;
		else			return p[x] = Find(p[x]);
	}
	
	public static void Union(int x, int y) {
		p[Find(x)] = Find(y);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3289.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			p = new int[N+1];
			for (int i = 1; i <= N; i++)
				p[i] = i;
			
			System.out.print("#" + test_case + " ");
			while (0 < M--) {
				String[] oab = br.readLine().split(" ");
				int o = Integer.parseInt(oab[0]);
				int a = Integer.parseInt(oab[1]);
				int b = Integer.parseInt(oab[2]);
				if (o == 0)	Union(a, b);
				else		System.out.print(Find(a)==Find(b) ? 1 : 0);
			}
			System.out.println();
		}
		
		br.close();
	}
	
}
