package com.ssafy.algo;

import java.io.*;

public class Solution3459_승자예측하기_서울10반_이준범 {

	public static String[] Answer = { "Alice", "Bob" };
	public static long N, mul;
	public static int idx;
	public static boolean sw;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3459.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Long.parseLong(br.readLine());
			mul = 1;
			idx = 1;
			sw = true;
			
			for (long l = 1; l < Long.MAX_VALUE; l += mul) {
				if (N <= l)
					break;

				idx = (idx == 0) ? 1 : 0;
				if (sw)
					mul *= 4;
				sw = !sw;
			}
			bw.write("#" + test_case + " " + Answer[idx] + "\n");
			bw.flush();
		}

		bw.close();
		br.close();
	}

}
