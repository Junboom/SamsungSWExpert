package com.ssafy.algo;

import java.io.*;

public class Solution4408_자기방으로돌아가기_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input4408.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int[] visited = new int[200];
			int Answer = 0;
			int N = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				String[] ioRoom = br.readLine().split(" ");
				int start = (Integer.parseInt(ioRoom[0])-1) / 2;
				int end = (Integer.parseInt(ioRoom[1])-1) / 2;
				if (start > end) {
					int temp = start;
					start = end;
					end = temp;
				}
				for (int j = start; j <= end; j++) {
					visited[j]++;
					if (Answer < visited[j])
						Answer = visited[j];
				}
			}
			System.out.println("#" + test_case + " " + Answer);
		}
		
		br.close();
	}
	
}
