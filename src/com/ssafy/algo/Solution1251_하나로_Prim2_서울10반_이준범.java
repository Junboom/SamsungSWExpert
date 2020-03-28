package com.ssafy.algo;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1251_하나로_Prim2_서울10반_이준범 {
	
	public static int N;
	public static long[][] Graph;
	public static double E;
	
	public static long prim() {
		Queue<long[]> pq = new PriorityQueue<long[]>(new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[0], o2[0]);
			}
		});
		
		boolean[] visited = new boolean[N];
		visited[0] = true;
		for (int next = 0; next < N; next++)
			pq.offer(new long[] { Graph[0][next], next });
		
		long sumCost = 0;
		while (!pq.isEmpty()) {
			long[] currArr = pq.poll();
			int curr = (int)currArr[1];
			long weight = currArr[0];
			
			if (visited[curr])	continue;
			visited[curr] = true;
			sumCost += weight;
			
			for (int next = 0; next < N; next++)
				pq.offer(new long[] { Graph[curr][next], next });
		}
		return Math.round(sumCost * E);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			Graph = new long[N][N];
			String[] x = br.readLine().split(" ");
			String[] y = br.readLine().split(" ");
			E = Double.parseDouble(br.readLine());
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j) {
						Graph[i][j] = (long)(Math.pow(Integer.parseInt(x[i])-Integer.parseInt(x[j]), 2) +
								Math.pow(Integer.parseInt(y[i])-Integer.parseInt(y[j]), 2));
					}
				}
			}
			System.out.println("#" + test_case + " " + prim());
		}
		
		br.close();
	}
	
}
