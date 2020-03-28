package com.ssafy.algo;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution1217_거듭제곱_서울10반_이준범 {
	
	public static int power(int base, int exponent) {
		if (exponent == 0)	return 1;
		if (exponent == 1)	return base;
		if (exponent % 2 == 0) {
			int newbase = power(base, exponent/2);
			return newbase * newbase;
		}
		else {
			int newbase = power(base, (exponent-1)/2);
			return newbase * newbase * base;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1217.txt"));
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			int b = sc.nextInt();
			int e = sc.nextInt();

			System.out.println("#" + T + " " + power(b, e));
		}
		
		sc.close();
	}
	
}
