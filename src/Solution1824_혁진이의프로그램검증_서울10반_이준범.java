package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1824_혁진이의프로그램검증_서울10반_이준범 {
	
	public static String ans;
	public static int r, c, d;
	public static boolean gol;
	public static char[][] pro;
	public static boolean[] v;
	public static int[][] dir = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };
	
	public static void rec(int i, int j, int mem) {
		if (i == r)		i = 0;
		if (j == c) 	j = 0;
		if (i == -1)	i += r;
		if (j == -1)	j += c;
		if (v[(mem*4*r*c)+(d*r*c)+(i*c)+j])
			return;
		v[(mem*4*r*c)+(d*r*c)+(i*c)+j] = true;
		
		switch (pro[i][j]) {
		case '0':	case '1':	case '2':	case '3':	case '4':
		case '5':	case '6':	case '7':	case '8':	case '9':
					mem = pro[i][j] - '0';				break;
		case '+':	mem = (mem==15) ? 0 : ++mem;		break;
		case '-':	mem = (mem==0) ? 15 : --mem;		break;
		case '<':	d = 0;								break;
		case '>':	d = 1;								break;
		case '^':	d = 2;								break;
		case 'v':	d = 3;								break;
		case '_':	d = (mem==0) ? 1 : 0;				break;
		case '|':	d = (mem==0) ? 3 : 2;				break;
		case '?':
			for (int dd = 0; dd < dir.length; dd++)
				rec(i+dir[d=dd][0], j+dir[d][1], mem);	return;
		case '@':	ans = "YES";						return;
		}
		
		rec(i+dir[d][0], j+dir[d][1], mem);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1824.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			ans = "NO";
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = 1;	// 처음 방향 오른쪽
			gol = false;
			pro = new char[r][c];
			v = new boolean[16*4*r*c];	// mem, d, i, j
			for (int i = 0; i < r; i++) {
				pro[i] = br.readLine().toCharArray();
				for (int j = 0; j < c; j++) {
					if (pro[i][j] == '@')
						gol = true;
				}
			}
			
			if (gol)	rec(0, 0, 0);
			
			bw.write("#" + test_case + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
