package com.ssafy.algo;

import java.io.*;

public class Solution1219_길찾기_서울10반_이준범 {
	
	public static int Answer, N;
	public static int[][] way;
	public static String[] s;
	
	public static void insert(int cnt) {
		if (cnt >= N)
			return;
		
		int index = Integer.parseInt(s[cnt*2]);
		if (way[index][0] == -1)	way[index][0] = Integer.parseInt(s[cnt*2+1]);
		else						way[index][1] = Integer.parseInt(s[cnt*2+1]);
		insert(cnt+1);
	}
	
	public static void find(int start) {
		if (start == -1)
			return;
		if (start == 99) {
			Answer = 1;
			return;
		}
		
		find(way[start][0]);
		find(way[start][1]);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1219.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = 0;
		
		while (test_case < 10) {
			Answer = 0;
			String[] temp = br.readLine().split(" ");
			test_case = Integer.parseInt(temp[0]);
			N = Integer.parseInt(temp[1]);
			way = new int[100][2];
			for (int i = 0; i < 100; i++) {
				way[i][0] = -1;
				way[i][1] = -1;
			}
			s = br.readLine().split(" ");
			insert(0);
			find(0);
			System.out.println("#" + test_case + " " + Answer);
		}
		
		br.close();
	}
	
}
