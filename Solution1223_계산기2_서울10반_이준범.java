package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution1223_계산기2_서울10반_이준범 {

	public static char[] stack1 = new char[100];
	public static int[] stack2 = new int[100];
	public static int top = -1;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1223.txt"));
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int Answer = 0;
			StringBuilder sb = new StringBuilder();
			int N = sc.nextInt();
			String s = sc.next();
			
			for (int i = 0; i < N; i++) {
				char c = s.charAt(i);
				if ('0' <= c && c <= '9')
					sb.append(c);
				else if (c == ')') {
					char t;
					while ((t = stack1[top--]) != '(') {
						sb.append(t);
					}
				}
				else {
					while (getIcp(c) <= getIsp()) {
						char t = stack1[top--];
						sb.append(t);
					}
					stack1[++top] = c;
				}
			}
			while (top != -1) {
				sb.append(stack1[top--]);
			}
			
			top = -1;
			for (int i = 0; i < sb.length(); i++) {
				char c = sb.charAt(i);
				if ('0' <= c && c <= '9')
					stack2[++top] = c - '0';
				else {
					int n2 = stack2[top--];
					int n1 = stack2[top--];
					int n = 0;
					switch (c) {
					case '+':	n = n1 + n2;	break;
					case '-':	n = n1 - n2;	break;
					case '*':	n = n1 * n2;	break;
					case '/':	n = n1 / n2;	break;
					}
					stack2[++top] = n;
				}
			}
			Answer = stack2[top--];

			System.out.println("#" + test_case + " " + Answer);
		}
		
		sc.close();
	}
	
	public static int getIcp(char c) {
		switch (c) {
		case '+':	case '-':	return 1;
		case '*':	case '/':	return 2;
		case '(':				return 3;
		}
		return 0;
	}
	
	public static int getIsp() {
		char c = (top == -1) ? '(' : stack1[top];
		switch (c) {
		case '+':	case '-':	return 1;
		case '*':	case '/':	return 2;
		case '(':				return 0;
		}
		return 0;
	}

}
