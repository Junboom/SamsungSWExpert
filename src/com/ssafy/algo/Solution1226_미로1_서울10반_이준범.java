package com.ssafy.algo;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution1226_미로1_서울10반_이준범 {
	
	public static int size = 16;
	public static int[][] maze = new int[size][size];
							//우   하    좌    상
	public static int[] di = {0, 1, 0,-1};
	public static int[] dj = {1, 0,-1, 0};
	
	public static int[] stack = new int[size];
	public static int top;
	public static int Answer;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1226.txt"));
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			Answer = 0;
			top = -1;
			sc.next();
			String[] line = new String[size];
			for (int i = 0; i < size; i++) {
				line[i] = sc.next();
				for (int j = 0; j < size; j++) {
					maze[i][j] = line[i].charAt(j) - '0';
//					System.out.print(maze[i][j] + " ");
				}
//				System.out.println();
			}
			
			maze[1][1] = -1;
			solve(1, 1);
			System.out.println("#" + test_case + " " + Answer);
		}
		
		sc.close();
	}
	
	public static void solve(int i, int j) {
		stack[++top] = i * size + j;
		while (top != -1) {
			int curr = stack[top--];
			i = curr / size;
			j = curr % size;
			
			if (maze[i][j] <= 0) {
				for (int d = 0; d < 4; d++) {
					int ii = i + di[d];
					int jj = j + dj[d];
					if (maze[ii][jj] == 3) {
						Answer = 1;
						return;
					}
					if (maze[ii][jj] == 0) {
						maze[ii][jj] = maze[i][j] - 1;
						stack[++top] = ii * size + jj;
					}
				}
			}
		}
	}
	
}
