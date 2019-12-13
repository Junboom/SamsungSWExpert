package com.ssafy.algo;

import java.io.*;

public class Solution1873_상호의배틀필드_서울10반_이준범 {
	
	public static int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	public static char[] seeArr = { '^', 'v', '<', '>' };
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] inputIJ = br.readLine().split(" ");
			int I = Integer.parseInt(inputIJ[0]);
			int J = Integer.parseInt(inputIJ[1]);
			char[][] ground = new char[I][J];
			int tankI = 0, tankJ = 0;						// 탱크 위치
			int see = 0;									// 바라보는 방향
			boolean shoot = false;							// 슛을 쐈는지
			for (int i = 0; i < I; i++) {
				String line = br.readLine();
				ground[i] = line.toCharArray();
				for (int s = 0; s < seeArr.length; s++) {
					if (line.contains(""+seeArr[s])) {
						tankI = i;
						tankJ = line.indexOf(seeArr[s]);
						see = s;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String goLine = br.readLine();
			for (int go = 0; go < N; go++) {
				switch (goLine.charAt(go)) {
				case 'U':	see = 0;		break;
				case 'D':	see = 1;		break;
				case 'L':	see = 2;		break;
				case 'R':	see = 3;		break;
				case 'S':	shoot = true;	break;
				}
				
				// 슛, 이동
				int ii = tankI + dir[see][0];
				int jj = tankJ + dir[see][1];
				if (0 <= ii && ii < I && 0 <= jj && jj < J) {
					if (shoot) {												// 슛을 쐈으면 뿌시고 continue
						do {
							if (ground[ii][jj] == '*') {
								ground[ii][jj] = '.';
								break;
							}
							else if (ground[ii][jj] == '#')
								break;

							ii += dir[see][0];
							jj += dir[see][1];
						} while (0 <= ii && ii < I && 0 <= jj && jj < J);
					}
					else if (ground[ii][jj] == '.') {							// 슛을 쏘지 않았다면 이동
						ground[tankI][tankJ] = '.';
						tankI = ii;
						tankJ = jj;
					}
				}
				shoot = false;
			}
			ground[tankI][tankJ] = seeArr[see];
			
			// 출력
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < I; i++) {
				String finalLine = "";
				for (int j = 0; j < J; j++)
					finalLine += ground[i][j];
				System.out.println(finalLine);
			}
		}
		
		br.close();
	}
	
}
