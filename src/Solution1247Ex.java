package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution1247Ex {
    
	static int min;
    static int count;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for(int t=1 ; t<=T ; t++) {
            min = 1000;
            count = 0;
            int N = Integer.parseInt(br.readLine());
            int []x = new int[N+2];
            int []y = new int[N+2];
            boolean [] bool = new boolean[N+2];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < N+2 ; i++) {
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
            }
            walking(x,y,bool,0,0,0);// x y 배열, boolean 배열 , 현재 인덱스 , 현재 카운트 , 합
            System.out.println("#"+t+" "+min);
        }
    }
    
    static void walking(int[]x ,int y[],boolean[] bool,int idx,int cnt,int sum) {
        if(sum > min) {
            return;
        }
        if(cnt == x.length-2) {
            sum += Math.abs(x[1]-x[idx]);
            sum += Math.abs(y[1]-y[idx]);
            if(min > sum) {
                min = sum;
            }
            return;
        }
         
        for(int i = 2 ; i < x.length ; i++) {
            if(!bool[i]) {
                    bool[i] = true;
                    int sum1 = sum;
                    sum1 += Math.abs(x[idx]-x[i]) + Math.abs(y[idx]-y[i]);
                    walking(x,y,bool,i,cnt+1,sum1);
                    bool[i] = false;
            }
        }
    }
}
