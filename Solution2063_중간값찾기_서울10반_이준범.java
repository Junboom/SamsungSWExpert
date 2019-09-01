package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2063_중간값찾기_서울10반_이준범 {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input2063.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] ia = new int[N];
		for (int n = 0; n < N; n++)
			ia[n] = sc.nextInt();
		
		// Arrays.sort(ia);
		for (int j = N-1; j >= 0; j--) {
			for (int k = 0; k < j; k++) {
				if (ia[k] > ia[k+1]) {
					int temp = ia[k];
					ia[k] = ia[k+1];
					ia[k+1] = temp;
				}
			}
		}
		
		System.out.println(ia[N/2]);
		sc.close();

	}

}
