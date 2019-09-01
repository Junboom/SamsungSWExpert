package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution1218_괄호짝짓기_서울10반_이준범 {

	public static char[] stack = new char[1000];
	public static int top = -1;
	
	public static boolean push(char value) {
		if (top >= stack.length)
			return false;
		stack[++top] = value;		// push()
		return true;
	}
	
	public static int pop() {
		if (top == -1)
			return -1;				// isEmpty()
		int value = stack[top--];	// pop()
		return value;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1218.txt"));
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int Answer = 1;
			int N = sc.nextInt();
			String str = sc.next();
			char[] open = {'(', '{', '[', '<'};
			char[] close = {')', '}', ']', '>'};
			
			for (int i = 0; i < N; i++) {
				char ch = str.charAt(i);
				for (int j = 0; j < 4; j++) {
					if (open[j] == ch) {
						push(ch);
						break;
					}
					if (close[j] == ch) {
						if (open[j] != pop())
							Answer = 0;
					}
				}
				if (Answer == 0)
					break;
			}
			
			System.out.println("#" + tc + " " + Answer);
		}
		
		sc.close();
	}

}
