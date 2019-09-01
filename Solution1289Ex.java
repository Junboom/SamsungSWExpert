package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution1289Ex {

	public static int [] mechange(int [] memory, int n, int ZorO) {
		for (int i = n; i < memory.length; i++) {
			memory[i] = ZorO;
		}
		
		return memory;
	}
	
	public static boolean same(int [] memory, int [] temp) {
		for (int i = 0; i < temp.length; i++) {
			if(memory[i] != temp[i]) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("res/input1289.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		int answer = 0;
		
		for (int test_case = 0; test_case < T; test_case++) {
			answer = 0;
			
			char [] cahrarr = sc.nextLine().toCharArray();
			int [] memory = new int [cahrarr.length];
			int [] temp = new int [cahrarr.length];
			
			for (int i = 0; i < memory.length; i++) {
				memory[i] = (int) (cahrarr[i] - '0');
			}
			
			for (int i = 0; i < temp.length; i++) {
				if(same(memory, temp)) break;
				
				if(temp[i] != memory[i]) {
					temp = mechange(temp, i, memory[i]);
					answer++;
					
//					System.out.println("#" + (answer+1) + "번째");
//					System.out.println(Arrays.toString(memory));
//					System.out.println(Arrays.toString(temp));
				}
			}
			
			System.out.println("#" + (test_case + 1) + " " + answer);
		}
		
		sc.close();

	}

}
