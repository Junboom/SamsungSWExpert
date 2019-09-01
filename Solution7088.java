package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution7088 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input7088.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int[] calf = new int[N+1];
			for (int i = 1; i <= N; i++)
				calf[i] = Integer.parseInt(br.readLine());
			int[][] ques = new int[Q][2];
			for (int i = 0; i < Q; i++) {
				st = new StringTokenizer(br.readLine());
				ques[i][0] = Integer.parseInt(st.nextToken());
				ques[i][1] = Integer.parseInt(st.nextToken());
			}
			
			System.out.println("#" + test_case);
			for (int i = 0; i < Q; i++) {
				int[] grade = new int[4];
				for (int j = ques[i][0]; j <= ques[i][1]; j++)
					grade[calf[j]]++;
				bw.write(grade[1] + " " + grade[2] + " " + grade[3] + "\n");
			}
			bw.flush();
		}
		
		bw.close();
		br.close();
	}
	
}
