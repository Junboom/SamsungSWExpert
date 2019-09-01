package com.ssafy.algo;

import java.io.*;

public class Solution4301 {
	
	public static int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input4301.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			String[] arr = br.readLine().split(" ");
			int J = Integer.parseInt(arr[0]);
			int I = Integer.parseInt(arr[1]);
			int[][] field = new int[I][J];
			
			for (int i = 0; i < I; i++) {
				for (int j = 0; j < J; j++) {
					if (field[i][j] == -1)
						continue;
					
					field[i][j] = 1;
					Answer++;
					for (int k = 0; k < dir.length; k++) {
						int ii = i + dir[k][0] * 2;
						int jj = j + dir[k][1] * 2;
						
						if (0 <= ii && ii < I && 0 <= jj && jj < J)
							field[ii][jj] = -1;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + Answer);
		}
		br.close();
	}
	
}
