package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution3143_가장빠른문자열타이핑_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3143.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			String word = st.nextToken();
			
			loop:for (int i = 0; i < line.length(); i++) {
				Answer++;
				if (line.charAt(i) == word.charAt(0)) {
					for (int j = 0; j < word.length(); j++) {
						if (line.length() <= i+j || line.charAt(i+j) != word.charAt(j))
							continue loop;
					}
					i += (word.length()-1);
				}
			}
			
			bw.write("#" + test_case + " " + Answer + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
