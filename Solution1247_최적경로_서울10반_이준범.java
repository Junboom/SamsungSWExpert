package com.ssafy.algo;

import java.io.*;
import java.util.Arrays;

public class Solution1247_최적경로_서울10반_이준범 {
	
	public static int Answer, N, p[][];
	
	public static int dis(int[] s, int[] e) {
		return Math.abs(s[0] - e[0]) + Math.abs(s[1] - e[1]);
	}
	
	public static void roots(int[] roots, int before, int root, int cnt) {
		if (cnt == 1) {
			root += dis(p[0], p[before]);
			roots[before] = -1;
		}
		for (int i = 2; i < N; i++) {
			if (roots[i] == -1)		continue;
			if (Answer < root)		return;
			if (++cnt == N)		break;
			
			System.out.print(Arrays.toString(roots) + "  " + root + " " + cnt);
			System.out.println();
			root += dis(p[before], p[i]);
			roots[i] = -1;
			roots(roots, i, root, cnt);
		}
		for (int i = 2; i < N; i++) {
			if (roots[i] == 0) {
				root += dis(p[i], p[1]);
				if (root < Answer)
					Answer = root;
			}
		}
	}
			
	public static void roots(int[][] p, boolean[] check, int before, int cnt, int sum) {
		if (Answer < sum)
			return;
		if (cnt == N-2) {
			sum += dis(p[before], p[1]);
			if (sum < Answer)
				Answer = sum;
			return;
		}
		
		for (int i = 2; i < N; i++) {
			if (check[i])
				continue;
			
			check[i] = true;
			int root = sum;
			root += dis(p[before], p[i]);
			roots(p, check, i, cnt+1, root);
			check[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			Answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine()) + 2;
			String[] places = br.readLine().split(" ");
			int[][] p = new int[N][2];
			for (int i = 0; i < N; i++) {
				p[i][0] = Integer.parseInt(places[i*2]);
				p[i][1] = Integer.parseInt(places[i*2+1]);
			}
			
			int[] roots = new int[N];
			for (int i = 2; i < N; i++)
				roots(roots, i, 0, 1);
			
			boolean[] check = new boolean[N];
			roots(p, check, 0, 0, 0);
			System.out.println("#" + test_case + " " + Answer);
		}
		
		br.close();
	}
	
}
