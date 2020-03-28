package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;
 
class Solution1208_Flatten_서울10반_이준범 {
    public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input1208.txt"));
        Scanner sc = new Scanner(System.in);
        int T = 10;
         
        for (int test_case = 1; test_case <= T; test_case++) {
            int Answer = 0;
            int max = 0, min = 0;
            int up = 0, down = 0;
            int upTemp = 0, downTemp = 0;
            int[] boxCount = new int[101];
             
            boxCount[0] = sc.nextInt();             // Index0= 덤프 횟수
            for (int i = 1; i <= 100; i++) {
                boxCount[sc.nextInt()]++;           // Index1= 1층의 개수(~ Index100)
            }
             
            for (int i = 100; i > 0; i--) {
                upTemp += boxCount[i];                        // 해당 층의 뺄 박스
                up += boxCount[i] + upTemp;                 // 기존 뺄 박스+해당 층의 뺄 박스
                if (up > boxCount[0]) {
                    max = i - 1;
                    break;
                }
            }
            for (int i = 1; i <= 100; i++) {
                downTemp += boxCount[i];                    // 해당 층의 채울 박스
                down += boxCount[i] + downTemp;         // 기존 채울 박스+해당 층의 채울 박스
                if (down > boxCount[0]) {
                    min = i + 1;
                    break;
                }
            }
            Answer = max - min;
             
            System.out.println("#" + test_case + " " + Answer);
        }
         
        sc.close();
         
    }
}
