package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Solution3378_스타일리쉬들여쓰기_서울10반_이준범 {
	
	public static StringBuilder ans;
	public static int[][] open;
	public static int[][] what = { {'(', '{', '['}, {')', '}', ']'} };
	public static List<int[]> val;
	public static String line;
	
	public static void search(int[] arr) {
		for (int j = 0; j < line.length(); j++) {
			for (int w = 0; w < 3; w++) {
				if (line.charAt(j) == what[0][w])	arr[w]++;
				if (line.charAt(j) == what[1][w])	arr[w]--;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3378.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			ans = new StringBuilder();
			ans.append("#").append(test_case);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			open = new int[p+1][4];
			val = new ArrayList<>();
			for (int i = 0; i < p; i++) {
				line = br.readLine();
				for (int j = 0; j < line.length(); j++) {
					if (line.charAt(j) != '.') {
						for (int w = 0; w < 3; w++)
							open[i+1][w] = open[i][w];
						open[i][3] = j;
						break;
					}
				}
				search(open[i+1]);
			}
			for (int i = 1; i <= 20; i++) {
				for (int j = 1; j <= 20; j++) {
					loop:for (int k = 1; k <= 20; k++) {
						for (int ii = 1; ii <= p; ii++) {
							if (open[ii][0]*i + open[ii][1]*j + open[ii][2]*k != open[ii][3])
								continue loop;
						}
						val.add(new int[] {i, j, k});
					}
				}
			}
			
			int sum = 0;
			int[] whatN = new int[3];
			for (int i = 0; i < q; i++) {
				line = br.readLine();
				// 여기서 사실 RCS 값 계산
				// whatN이 가지고 있는 RCS에 대한 값이 있는데 얘를 리스트에 있는 모든 값과 곱해줘서
				// 전부 다 같으면 그 결과값을 append 해주면 되고, 하나라도 다른 값이 있으면 모호하므로 -1을 append 해주면 된다.
				if (!val.isEmpty())
					sum = val.get(0)[0]*whatN[0] + val.get(0)[1]*whatN[1] + val.get(0)[2]*whatN[2];
				for (int j = 1; j < val.size(); j++) {
					if (sum != val.get(j)[0]*whatN[0] + val.get(j)[1]*whatN[1] + val.get(j)[2]*whatN[2]) {
						sum = -1;
						break;
					}
				}
				ans.append(" ").append(sum);
				search(whatN);
			}
			
			bw.write(ans.append("\n").toString());
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
