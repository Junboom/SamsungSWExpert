package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution5432_쇠막대기자르기_서울10반_이준범 {

	public static char[] stack = new char[100000];
	public static int top = -1;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5432.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int Answer = 0;
			String stick = sc.next();
			
			for (int i = 0; i < stick.length(); i++) {
				if (stick.charAt(i) == '(')
					push(stick.charAt(i));
				else {
					if (stick.charAt(i-1) == ')')	Answer++;		// 막대 닫힘
					else							Answer += top;	// 레이저
					pop();
				}
			}
			
			System.out.println("#" + tc + " " + Answer);
		}
		
		sc.close();
	}
	
	public static boolean push(char value) {
		if (top >= stack.length)
			return false;
		stack[++top] = value;		// push()
		return true;
	}
	
	public static int pop() {
		if (top == -1)
			return -1;				// isEmpty()
		return stack[top--];		// pop()
	}

}
