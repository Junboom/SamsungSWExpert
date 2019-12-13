package com.ssafy.algo;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution4615 {
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input4615.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int B = 0, W = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] board = new int[N][N];
			int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
			board[N/2-1][N/2-1] = 2;
			board[N/2][N/2] = 2;
			board[N/2-1][N/2] = 1;
			board[N/2][N/2-1] = 1;
			
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int who = sc.nextInt();
				int _x = x - 1;
				int _y = y - 1;
				board[_x][_y] = who;
				
				for (int j = 0; j < 4; j++) {
					_x += dir[j][0];
					_y += dir[j][1];
					
					if (_x >= 0 && _y >= 0 && _x < N && _y < N) {
						if (board[_x][_y] != 0 && board[_x][_y] != who) {
							j--;
							board[_x][_y] = who;
							continue;
						}
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(board[i][j] + " ");
						 if (board[i][j] == 1)	B++;
					else if (board[i][j] == 2)	W++;
				}
				System.out.println();
			}

			System.out.println("#" + test_case + " " + B +  " " + W);
		}
		
		sc.close();
		
	}
}
