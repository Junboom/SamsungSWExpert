package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution5643_키순서_서울10반_이준범 {
	
	public static int ans;
	public static int n, m;
	public static boolean[][] order;
	public static boolean[] v;
	public static int front, rear;
	public static int[] queue;
	
	public static void bfsUp() {
		while (front != rear) {
			int temp = queue[++front];
			for (int i = 1; i <= n; i++) {
				if (order[temp][i] && !v[i]) {
					queue[++rear] = i;
					v[i] = true;
				}
			}
		}
	}
	
	public static void bfsDown() {
		while (front != rear) {
			int temp = queue[++front];
			for (int i = 1; i <= n; i++) {
				if (order[i][temp] && !v[i]) {
					queue[++rear] = i;
					v[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5643.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine().trim());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			ans = 0;
			n = Integer.parseInt(br.readLine().trim());
			m = Integer.parseInt(br.readLine().trim());
			order = new boolean[n+1][n+1];
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine().trim());
				int fir = Integer.parseInt(st.nextToken());
				int sec = Integer.parseInt(st.nextToken());
				order[fir][sec] = true;
			}
			queue = new int[n+1];
			
			for (int i = 1; i <= n; i++) {
				v = new boolean[n+1];
				front = rear = -1;
				queue[++rear] = i;
				bfsUp();
				queue[++rear] = i;
				bfsDown();
				if (front == n)
					ans++;
			}
			
			bw.write("#" + test_case + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
