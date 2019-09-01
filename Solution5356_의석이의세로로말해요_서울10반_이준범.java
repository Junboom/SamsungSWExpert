package com.ssafy.algo;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution5356_의석이의세로로말해요_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5356.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] s = new String[5];
			char[][] c = new char[5][15];
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < 5; i++) {
				s[i] = sc.nextLine();
				for (int j = 0; j < s[i].length(); j++) {
					c[i][j] = s[i].charAt(j);
				}
			}
			
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 5; j++) {
					if (s[j].length() > i)
						sb.append(c[j][i] + "");
				}
			}
			
			System.out.println("#" + test_case + " " + sb);
		}
		
		sc.close();
	}
	
}
