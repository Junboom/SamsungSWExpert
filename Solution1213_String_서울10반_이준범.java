package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution1213_String_서울10반_이준범 {
	
	public static int T, Answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1213.txt"));
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			T = sc.nextInt();
			Answer = 0;
			String search = sc.next();
			String text = sc.next() + " ";
			Answer = text.split(search).length - 1;
//			for (int i = 0; i < text.length()-search.length(); i++) {
//				if (text.charAt(i) == search.charAt(0)) {
//					int j;
//					for (j = 1; j < search.length(); j++) {
//						if (text.charAt(i+j) != search.charAt(j))
//							break;
//					}
//					if (j == search.length())
//						Answer++;
//				}
//			}
			System.out.println("#" + tc + " " + Answer);
		}
		
		sc.close();
	}

}
