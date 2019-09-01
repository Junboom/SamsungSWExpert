package com.ssafy.algo;

import java.io.*;
import java.util.Scanner;

public class Solution3809 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3809.txt"));
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 1;
			int N = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++)
				sb.append(sc.nextInt());
			int len = 1;
			int div = 10;
			for (int i = 0; i <= sb.length()-len; i++) {
				if (sb.substring(i, i+len).equals(""+Answer)) {
					if ((++Answer) / div == 1) {
						len++;
						div *= 10;
					}
					i = -1;
				}
			}
			
			if (Answer == 1)	Answer = 0;
			bw.write("#" + test_case + " " + Answer + "\n");
			bw.flush();
		}
		
		bw.close();
		sc.close();
	}
	
}
