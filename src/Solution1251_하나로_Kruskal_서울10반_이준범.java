package com.ssafy.algo;

import java.io.*;
import java.util.Arrays;

class Edge implements Comparable<Edge> {
	int u;
	int v;
	long cost;
	
	Edge(int u, int v, long cost) {
		this.u = u;
		this.v = v;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return Long.compare(this.cost, o.cost);
	}
}

public class Solution1251_하나로_Kruskal_서울10반_이준범 {
	
	public static int N;
	public static Edge[] EdgeArr;
	public static int[] Parent;
	public static double E;
	
	public static int findSet(int v) {
		if (v == Parent[v])	return v;
		return Parent[v] = findSet(Parent[v]);
	}
	
	public static long kruskal() {
		Arrays.sort(EdgeArr);
		for (int i = 0; i < N; i++)
			Parent[i] = i;
		long sumCost = 0;
		long selectCnt = 0;
		
		for (int i = 0; i < EdgeArr.length; i++) {
			int u = EdgeArr[i].u;
			int v = EdgeArr[i].v;
			if (findSet(u) == findSet(v))	continue;
			
			Parent[findSet(u)] = findSet(v);
			sumCost += EdgeArr[i].cost;
			if (++selectCnt >= N-1)			break;
		}
		return Math.round(sumCost * E);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			EdgeArr = new Edge[N*(N-1)/2];
			Parent = new int[N];
			String[] x = br.readLine().split(" ");
			String[] y = br.readLine().split(" ");
			E = Double.parseDouble(br.readLine());
			
			int EdgeCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					EdgeArr[EdgeCnt++] = new Edge(i, j,
							(long)(Math.pow(Integer.parseInt(x[i])-Integer.parseInt(x[j]), 2) +
								   Math.pow(Integer.parseInt(y[i])-Integer.parseInt(y[j]), 2)));
				}
			}
			System.out.println("#" + test_case + " " + kruskal());
		}
		
		br.close();
	}
	
}
