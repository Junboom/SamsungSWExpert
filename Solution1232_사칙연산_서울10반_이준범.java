package com.ssafy.algo;

import java.io.*;

public class Solution1232_사칙연산_서울10반_이준범 {
	
	static class Node {
		String value;
		int left;
		int right;
		
		public Node(String value, int left, int right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		public Node(String value) {
			this(value, 0, 0);
		}
	}
	
	public static int N;
	public static Node[] node;
	
	public static int tree(int i) {
		switch (node[i].value) {
		case "+":	return tree(node[i].left) + tree(node[i].right);
		case "-":	return tree(node[i].left) - tree(node[i].right);
		case "*":	return tree(node[i].left) * tree(node[i].right);
		case "/":	return tree(node[i].left) / tree(node[i].right);
		default:	return Integer.parseInt(node[i].value);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1232.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			N = Integer.parseInt(br.readLine());
			node = new Node[N+1];
			for (int i = 1; i <= N; i++) {
				String[] calc = br.readLine().split(" ");
				if (calc.length == 4)	node[i] = new Node(calc[1], Integer.parseInt(calc[2]), Integer.parseInt(calc[3]));
				else					node[i] = new Node(calc[1]);
			}
			System.out.println("#" + test_case + " " + tree(1));
		}
	}
	
}
