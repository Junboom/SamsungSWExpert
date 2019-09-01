package com.ssafy.algo;

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class Solution1225_암호생성기_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			Queue<Integer> queue = new LinkedList<>();
			br.readLine();
			String[] code = br.readLine().split(" ");
			for (int i = 0; i < code.length; i++)
				queue.offer(Integer.parseInt(code[i]));
			
			int front, count = 0;
			while ((front = queue.poll()) - (count = ((count++)%5)+1) > 0)
				queue.offer(front - count);
			
			System.out.print("#" + test_case + " ");
			for (int q : queue)
				System.out.print(q + " ");
			System.out.println("0");
		}
	}
	
}
