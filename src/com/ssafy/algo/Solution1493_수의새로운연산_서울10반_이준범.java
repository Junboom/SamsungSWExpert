package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1493_수의새로운연산_서울10반_이준범 {
	
	public static int Answer, P, Q;
	public static boolean Psw, Qsw;
	public static int[] pIndex, qIndex, newIndex;
	
	public static void check() {
		int sum = 0;
		for (int i = 1; i <= 10000; i++) {
			sum += i;
			if (!Psw && !Qsw) {
				if (newIndex[0]+newIndex[1]-1 == i) {
					Answer = sum - (i-newIndex[0]);
					break;
				}
				continue;
			}
			
			if (sum >= P && Psw) {
				pIndex[1] = 1 + (sum-P);
				pIndex[0] = i - (sum-P);
				newIndex[0] += pIndex[0];
				newIndex[1] += pIndex[1];
				Psw = false;
			}
			if (sum >= Q && Qsw) {
				qIndex[1] = 1 + (sum-Q);
				qIndex[0] = i - (sum-Q);
				newIndex[0] += qIndex[0];
				newIndex[1] += qIndex[1];
				Qsw = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1493.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			Answer = 0;
			st = new StringTokenizer(br.readLine());
			P = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			Psw = true;
			Qsw = true;
			pIndex = new int[2];
			qIndex = new int[2];
			newIndex = new int[2];
			check();
			bw.write("#" + test_case + " " + Answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}
