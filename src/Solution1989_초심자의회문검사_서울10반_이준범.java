package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution1989_초심자의회문검사_서울10반_이준범 {

	public static int T;
	public static int Answer;
	public static StringBuilder text;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1989.txt"));
		Scanner sc = new Scanner(System.in);
		T = Integer.parseInt(sc.nextLine());
		
		for (int tc = 1; tc <= T; tc++) {
			Answer = 0;
			text = new StringBuilder(sc.nextLine());
			if (text.toString().equals(text.reverse().toString()))
				Answer = 1;
			System.out.println("#" + tc + " " + Answer);
		}
		
		sc.close();
	}

}
