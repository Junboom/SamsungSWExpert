package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2007_패턴마디의길이_서울10반_이준범 {
	
	public static int T, N, Answer;
	public static StringBuilder text;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2007.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			Answer = 10;
			String text = sc.next();
			for (int i = 2; i < 10; i++) {
				if (text.substring(0, i).equals(text.substring(i, i*2))) {
					Answer = i;
					break;
				}
			}
			System.out.println("#" + tc + " " + Answer);
		}
		
		sc.close();
	}

}
