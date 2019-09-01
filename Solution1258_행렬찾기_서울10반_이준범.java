package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1258_행렬찾기_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1258.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			char[][] wh = new char[N][N];
			int[][] box = new int[20][2];
			int index = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					wh[i][j] = st.nextToken().charAt(0);
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (wh[i][j] != '0') {
						for (int ii = i; ii <= N; ii++) {
							if (ii == N || wh[ii][j] == '0') {
								box[index][0] = ii - i;
								break;
							}
						}
						for (int jj = j; jj <= N; jj++) {
							if (jj == N || wh[i][jj] == '0') {
								box[index][1] = jj - j;
								break;
							}
						}
						for (int ii = i; ii < i+box[index][0]; ii++) {
							for (int jj = j; jj < j+box[index][1]; jj++) {
								wh[ii][jj] = '0';
							}
						}
						j = box[index++][1];
					}
				}
			}

			StringBuilder sb = new StringBuilder();
			boolean[] sw = new boolean[index];
			for (int i = 0; i < index; i++) {
				int min = Integer.MAX_VALUE;
				int indexJ = 0;
				for (int j = 0; j < index; j++) {
					if (!sw[j] && ((box[j][0] * box[j][1] < min) ||
							(box[j][0] * box[j][1] == min && box[j][0] < box[indexJ][0]))) {
						indexJ = j;
						min = box[indexJ][0] * box[indexJ][1];
					}
				}
				sb.append(" ").append(box[indexJ][0]);
				sb.append(" ").append(box[indexJ][1]);
				sw[indexJ] = true;
			}
			System.out.println("#" + test_case + " " + index + sb.toString());
		}
		
		br.close();
	}
	
}
