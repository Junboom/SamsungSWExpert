package com.ssafy.algo;

import java.io.*;

public class Solution1240_단순2진암호코드_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1240.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0, Check = 0, sw = 0;
			String[] nm = br.readLine().split(" ");
			String[] ts = { "1011000", "1001100", "1100100", "1011110", "1100010",
							"1000110", "1111010", "1101110", "1110110", "1101000" };
			
			for (int i = 0; i < Integer.parseInt(nm[0]); i++) {
				if (sw == 1) {
					br.readLine();
					continue;
				}
				StringBuilder sb = new StringBuilder();
				sb.append(br.readLine()).reverse();
				
				for (int j = 0; j < Integer.parseInt(nm[1]); j++) {
					if (sb.charAt(j) == '1') {
						String[] s = new String[8];
						
						for (int k = 0; k < s.length; k++) {
							s[k] = sb.substring(j+k*7, j+k*7+7);
							
							for (int n = 0; n < ts.length; n++) {
								if (s[k].equals(ts[n])) {
									if (k % 2 == 0)		Check += n;
									else				Check += n * 3;
									Answer += n;
									break;
								}
							}
						}
						if (Check % 10 != 0)
							Answer = 0;
						sw = 1;
						break;
					}
				}
			}

			System.out.println("#" + test_case + " " + Answer);
		}
		
		br.close();
	}
	
}
