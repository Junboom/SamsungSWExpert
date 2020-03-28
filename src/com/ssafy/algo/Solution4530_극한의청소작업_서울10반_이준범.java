package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution4530_극한의청소작업_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input4530.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			long ans = 0, ansA = 0, ansB = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			
			int c = 1;	// 둘 다 양수
			if (a.charAt(0) == '-') {
				c = 2;	// 하나 음수
				a = a.substring(1, a.length());
			}
			if (b.charAt(0) == '-') {
				c = 3;	// 둘 다 음수
				b = b.substring(1, b.length());
			}
			
			for (int i = 0; i < a.length(); i++) {
				int n = a.charAt(i)-'0';
				if (n > 4)	n -= 1;
				ansA += n*Math.pow(9, a.length()-1-i);
			}
			for (int i = 0; i < b.length(); i++) {
				int n = b.charAt(i)-'0';
				if (n > 4)	n -= 1;
				ansB += n*Math.pow(9, b.length()-1-i);
			}
			
			switch (c) {
			case 1:		ans = ansB-ansA;	break;
			case 2:		ans = ansB+ansA-1;	break;
			case 3: 	ans = ansA-ansB;	break;
			}
			bw.write("#" + test_case + " " + ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
