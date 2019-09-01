package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1868_파핑파핑지뢰찾기_서울10반_이준범 {

	public static int Answer, N;
	public static char[] map;
	public static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1},
								 { 0, -1},			{ 0, 1},
								 { 1, -1}, { 1, 0}, { 1, 1}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1868.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			Answer = 0;
			N = Integer.parseInt(br.readLine());
			map = new char[N*N];
			int stack[] = new int[N*N];
			int top = -1;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++)
				sb.append(br.readLine().trim());
			map = sb.toString().toCharArray();
			
			for (int n = 0; n < N*N; n++) {
				if (map[n] == '.') {
					int dotSum = 0;
					for (int d = 0; d < dir.length; d++) {
						int ii = n/N + dir[d][0];
						int jj = n%N + dir[d][1];
						if (0 <= ii && ii < N && 0 <= jj && jj < N && map[ii*N+jj] == '*')
							dotSum++;
					}
					if (dotSum == 0) {
						stack[++top] = n;
						
						while (0 <= top) {
							int curr = stack[top--];
							map[curr] = '0';
							
							for (int d = 0; d < dir.length; d++) {
								int ii = curr/N + dir[d][0];
								int jj = curr%N + dir[d][1];
								if (0 <= ii && ii < N && 0 <= jj && jj < N && map[ii*N+jj] == '.') {
									dotSum = 0;
									for (int dd = 0; dd < dir.length; dd++) {
										int iii = ii + dir[dd][0];
										int jjj = jj + dir[dd][1];
										if (0 <= iii && iii < N && 0 <= jjj && jjj < N && map[iii*N+jjj] == '*')
											dotSum++;
									}
									map[ii*N+jj] = (char)('0' + dotSum);
									if (dotSum == 0)
										stack[++top] = ii*N + jj;
								}
							}
						}
						Answer++;
					}
				}
			}
			
			for (int n = 0; n < N*N; n++) {
				if (map[n] == '.')
					Answer++;
			}
			bw.write("#" + test_case + " " + Answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}
