package com.ssafy.algo;

import java.io.*;
 
public class Solution1266Ex {
	
    static double[] comb = new double[19];
    static int[] notsosu = new int[] {0,1,4,6,8,9,10,12,14,15,16,18};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        makingComb();
        for (int test = 1; test <= T; test++) {
            String[] s = br.readLine().split(" ");
            double a = (double)(Integer.parseInt(s[0])) / 100.0;
            double b = (double)(Integer.parseInt(s[1])) / 100.0;
            double a_answer = 0;
            double b_answer = 0;
            for(int i = 0; i < notsosu.length; i++) {
                int tmp = notsosu[i];
                 
                a_answer += comb[tmp] * Math.pow(a, tmp) * Math.pow(1 - a, 18 - tmp);
                b_answer += comb[tmp] * Math.pow(b, tmp) * Math.pow(1 - b, 18 - tmp);
                 
            }
             
            double result = 1-(a_answer * b_answer);
            System.out.printf("#%d %.6f\n", test, result);
                     
             
        }
    }
     
    static void makingComb() {
        comb[0] = 1;
        for(int i = 1; i < 19; i++) {
            comb[i] = comb[i-1] * (19-i) / i;
        }
         
    }
 
}
