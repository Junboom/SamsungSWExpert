package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution5550 {
	
	static int T, Answer;
	static char[] croak = { 'c', 'r', 'o', 'a', 'k' };
	static char[] changeCroak;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("Solution5550.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		sc.nextLine();
		
		for (int i = 1; i <= T; i++) {
			Answer = 0;
			String inputCroak = sc.nextLine();
			
			if (inputCroak.length() % 5 == 0) {
				changeCroak = new char[inputCroak.length()];
				for (int j = 0; j < inputCroak.length(); j++) {
					changeCroak[j] = inputCroak.charAt(j);
				}
				
				for (int j = 0; j < changeCroak.length; j++) {
					if (changeCroak[j] == croak[0]) {
						int croakNum = 0;
						for (int k = j; k < changeCroak.length; k++) {
							if (changeCroak[k] == croak[croakNum % 5]) {
								changeCroak[k] = 0;
								croakNum++;
							}
						}
						Answer++;
					}
					// System.out.print(changeCroak[j]);
				}
			}
			
			for (int j = 0; j < changeCroak.length; j++) {
				if (changeCroak[j] != 0) {
					Answer = -1;
					break;
				}
			}
			
			System.out.println("#" + i + " " + Answer);
		}
		
		sc.close();
		
	}
}
