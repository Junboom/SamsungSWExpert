package com.ssafy.algo;

import java.io.*;

public class Solution7087 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input7087.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			int N = Integer.parseInt(br.readLine());
			char[] first = new char[N];
			for (int i = 0; i < N; i++)
				first[i] = br.readLine().charAt(0);
			
			char abc = 'A';
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (abc == first[j]) {
						Answer++;
						abc += 1;
						break;
					}
				}
				if (Answer == 0)
					break;
			}

			System.out.println("#" + test_case + " " + Answer);
		}
		
		br.close();
	}
	
}
