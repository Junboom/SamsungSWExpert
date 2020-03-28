package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution4366_정식이의은행업무_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input4366.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			int ans = 0;
			StringBuilder n1 = new StringBuilder().append(br.readLine());
			StringBuilder n2 = new StringBuilder().append(br.readLine());
			boolean next = true;
			
			for (int i = 1; i < n1.length(); i++) {
				StringBuilder tmp1 = new StringBuilder(n1);
				if (tmp1.toString().charAt(i) == '0')	tmp1.setCharAt(i, '1');
				else									tmp1.setCharAt(i, '0');
				
				StringBuilder tmp2 = new StringBuilder(n2);
				if (tmp2.toString().charAt(0) == '1')	tmp2.setCharAt(0, '2');
				else									tmp2.setCharAt(0, '1');
				
				int num1 = Integer.parseInt(tmp1.toString(), 2);
				int num2 = Integer.parseInt(tmp2.toString(), 3);
				if (num1 == num2) {
					ans = num1;
					next = false;
					break;
				}
			}
			
			if (next) {
				loop:for (int i = 1; i < n1.length(); i++) {
					StringBuilder tmp1 = new StringBuilder(n1);
					if (tmp1.toString().charAt(i) == '0')	tmp1.setCharAt(i, '1');
					else									tmp1.setCharAt(i, '0');
					
					for (int j = 1; j < n2.length(); j++) {
						StringBuilder tmp2 = new StringBuilder(n2);
						for (int k = 0; k < 2; k++) {
								 if (tmp2.toString().charAt(j) == '0')	tmp2.setCharAt(j, '1');
							else if (tmp2.toString().charAt(j) == '1')	tmp2.setCharAt(j, '2');
							else										tmp2.setCharAt(j, '0');
							
							int num1 = Integer.parseInt(tmp1.toString(), 2);
							int num2 = Integer.parseInt(tmp2.toString(), 3);
							if (num1 == num2) {
								ans = num1;
								break loop;
							}
						}
					}
				}
			}
			
			bw.write("#" + test_case + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
