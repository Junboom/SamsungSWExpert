package com.ssafy.algo;

import java.io.*;

public class Solution5515_2016년요일맞추기_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5515.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 4;
			String[] day = br.readLine().split(" ");
			int m = Integer.parseInt(day[0]);
			int d = Integer.parseInt(day[1]);
			int date = 0;
			
			while (m > ++date) {
				if (date == 1 || date == 3 || date == 5 || date == 7 || date == 8 || date == 10)
					Answer += 31;
				else if (date == 2)
					Answer += 29;
				else
					Answer += 30;
				Answer %= 7;
			}
			Answer = (Answer + (d-1)) % 7;

			System.out.println("#" + test_case + " " + Answer);
		}
		br.close();
	}
	
}
