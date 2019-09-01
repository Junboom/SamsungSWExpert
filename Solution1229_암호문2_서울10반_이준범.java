package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution1229_암호문2_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1229.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String[] line = br.readLine().split(" ");
			List<String> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(line[i]);
			}
			br.readLine();
			String[] pass = br.readLine().split(" ");

			for (int i = 0; i < pass.length; i++) {
				switch (pass[i]) {
				case "I":
					for (int j = 0; j < Integer.parseInt(pass[i+2]); j++)
						list.add(Integer.parseInt(pass[i+1]) + j, pass[i+3+j]);
					break;
				case "D":
					for (int j = 0; j < Integer.parseInt(pass[i+2]); j++)
						list.remove(Integer.parseInt(pass[i+1]));
					break;
				}
			}

			System.out.print("#" + test_case);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();
		}
	}
	
}
