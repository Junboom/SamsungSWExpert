package com.ssafy.algo;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution1222_계산기1_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1222.txt"));
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int Answer = 0;
			int N = sc.nextInt();
			String S = sc.next();
			int[] stack = new int[N];
			int top = -1;
			
			for (int i = 0; i < N; i++) {
				switch (S.charAt(i)) {
				case '+':
					Answer += stack[top--];
					break;
				default:
					stack[++top] = S.charAt(i) - '0';
					break;
				}
			}
			Answer += stack[top];

			System.out.println("#" + test_case + " " + Answer);
		}
		
		sc.close();
	}
	
}
