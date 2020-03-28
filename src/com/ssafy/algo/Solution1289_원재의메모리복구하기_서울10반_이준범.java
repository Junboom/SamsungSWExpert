package com.ssafy.algo;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution1289_원재의메모리복구하기_서울10반_이준범 {
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input1289.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			char[] c = sc.next().toCharArray();
			
			for (int i = 0; i < c.length; i++) {
				if (c[i] == '1') {
					for (int j = i; j < c.length; j++) {
						if (c[j] == '0')	c[j] = '1';
						else				c[j] = '0';
					}
					Answer++;
				}
			}
			
			System.out.println("#" + test_case + " " + Answer);
		}
		
		sc.close();
		
	}
}
