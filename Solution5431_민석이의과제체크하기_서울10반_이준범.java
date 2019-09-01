package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;
  
class Solution5431_민석이의과제체크하기_서울10반_이준범 {
    public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input5431.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
          
        for (int test_case = 1; test_case <= T; test_case++) {
            int cMax = sc.nextInt();
            int cSub = sc.nextInt();
            int[] c = new int[cSub];
            for (int i = 0; i < cSub; i++)
                c[i] = sc.nextInt();
            StringBuilder sb = new StringBuilder("#");
            sb.append(test_case);
              
            for (int i = 1; i <= cMax; i++) {
                boolean exist = false;
                for (int j =0; j < cSub; j++) {
                    if (i == c[j])
                        exist = true;
                }
                if (!exist) {
                    sb.append(" ");
                    sb.append(i);
                }
            }
              
            System.out.println(sb.toString());
        }
          
        sc.close();
          
    }
}
