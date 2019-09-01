package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1238_Contact_서울10반_이준범 {
	
	public static int ans, N;
	public static int[][] graph;
	public static int[] queue;
	public static int front, rear;
	public static int[] v;
	
	public static void bfs() {
		while (front != rear) {
			int temp = queue[++front];
			for (int j = 1; j <= 100; j++) {
				if (graph[temp][j] != 0 && v[j] == 0) {
					queue[++rear] = j;
					v[j] = v[temp] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			graph = new int[101][101];
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N/2; n++) {
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				graph[i][j] = 1;
			}
			queue = new int[N];
			front = rear = -1;
			v = new int[101];
			
			queue[++rear] = start;
			bfs();
			int max = 0;
			for (int i = 1; i <= 100; i++) {
				if (max <= v[i]) {
					max = v[i];
					ans = i;
				}
			}
			
			bw.write("#" + test_case + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
