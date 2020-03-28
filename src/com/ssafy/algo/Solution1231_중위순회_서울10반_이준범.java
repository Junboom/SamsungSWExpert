package com.ssafy.algo;

import java.io.*;

public class Solution1231_중위순회_서울10반_이준범 {
	
	private static int N;
	private static String[] Answer;
	
	private static void inorder(int i) {
		if (i <= N) {
			inorder(2*i);
			System.out.print(Answer[i]);
			inorder(2*i+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1231.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			N = Integer.parseInt(br.readLine());
			Answer = new String[N+1];
			for (int i = 1; i <= N; i++) {
				String[] line = br.readLine().split(" ");
				Answer[i] = line[1];
			}
			System.out.print("#" + test_case + " ");
			inorder(1);
			System.out.println();
		}
	}
	
}
