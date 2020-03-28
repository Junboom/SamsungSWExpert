package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Solution4014_활주로건설_서울10반_이준범 {
	
	public static int ans, n, x;
	public static int[][] map;
	public static int[][] ver;
	
	public static boolean check(int[] line) {
		int c = 1;
		for (int i = 1; i < n; i++) {
			if (Math.abs(line[i-1]-line[i]) > 1)
				return false;

			if (line[i-1] < line[i]) {
				if (c < x)
					return false;
				c = 1;
			}
			else if (line[i-1] > line[i]) {
				for (int j = i+1; j < i+x; j++) {
					if (n <= j || line[j] != line[i])
						return false;
				}
				i += x - 1;
				c = 0;
			}
			else	c++;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input4014.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			ver = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					ver[j][i] = map[i][j];
				}
				if (check(map[i]))	ans++;
			}
			for (int i = 0; i < n; i++)
				if (check(ver[i]))	ans++;
			bw.write("#" + test_case + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
