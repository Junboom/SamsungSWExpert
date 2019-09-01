package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution3307_최장증가부분수열_서울10반_이준범 {
	
	public static int Answer, N, top;
	public static int[] num, stack;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3307.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			Answer = 0;
			N = Integer.parseInt(br.readLine());
			num = new int[N+1];
			stack = new int[N+1];
			top = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				if (stack[top] < num[i])
					stack[++top] = num[i];
				else {
					int temp = top;
					while (0 < temp && stack[--temp] > num[i]);
					stack[++temp] = num[i];
				}
				
				if (Answer < top)
					Answer = top;
			}

			System.out.println("#" + test_case + " " + Answer);
		}
		
		br.close();
		
	}
}
