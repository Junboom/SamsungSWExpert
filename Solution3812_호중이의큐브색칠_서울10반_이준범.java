package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution3812_호중이의큐브색칠_서울10반_이준범 {
	
	public static void facet(long[] color, long[] tmp1, long[] tmp2, int xyz, int abc, int n, long sum1, long sum2) {
		long sum = 0;
		for (int i = 0; i < n; i++)
			sum += color[i];
		sum1 = sum * ((xyz-abc-1) / n);
		sum2 = sum * (abc / n);
		
		for (int i = 1; i <= (xyz-abc-1)%n; i++) {
			for (int j = 0; j < n; j++)
				tmp1[(j+i)%n] += color[j];
		}
		for (int i = 1; i <= abc%n; i++) {
			for (int j = 0; j < n; j++)
				tmp2[(j+i)%n] += color[j];
		}
		for (int i = 0; i < n; i++)
			color[i] += tmp1[i];
		for (int i = 0; i < n; i++)
			color[i] += tmp2[i];
		
		for (int i = 0; i < n; i++) {
			color[i] += sum1;
			color[i] += sum2;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3812.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			long[] color = new long[n];
			color[0] = 1;
			facet(color, new long[n], new long[n], x, a, n, 0, 0);
			facet(color, new long[n], new long[n], y, b, n, 0, 0);
			facet(color, new long[n], new long[n], z, c, n, 0, 0);
			
			StringBuilder ans = new StringBuilder();
			ans.append("#").append(test_case);
			for (int i = 0; i < n; i++)
				ans.append(" ").append(color[i]);
			ans.append("\n");
			bw.write(ans.toString());
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
