package com.ssafy.algo;

import java.util.*;
 
public class Solution3289Ex {
    public static int cal;
    public static int[] p;
    //public static Queue<Integer> queue;
     
    public static void makeset(int x) {
        for(int i=0;i<=x;i++) {
            p[i]=i;
        }
    }
    public static int findset(int x) {//findset은 기본적으로 a이하의 int값만
        //부모찾는 과정이라고 생각하면 된다.
        if(x==p[x]) return x;
        else return p[x]=findset(p[x]);
        //그냥 return findset(p[x])하면 시간초과난다.
        //왜냐 findset(p[x])하게 되면 계속 findset여러번 하게 해준다.

    }//집합이 제일 위거나 자기 자신 밖에 없다.
    //1의 부모가 1, 2의 부모가 2
    //findset해주면 1을 인덱스 
    //계속 부모 찾아가는 과정
    public static void union(int x, int y) {
        p[findset(y)]=findset(x);
    }
    public static void main(String[] args){//throws Exception {
        //System.setIn(new FileInputStream("res/input3289.txt"));
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=1;i<=T;i++) {
            int n=sc.nextInt();
            //구현 실력을 늘리기 위해
            //1.스트링빌더
            //2. 입력 사이사이에 출력
            //3.큐 사용
            StringBuilder stringBuilder=new StringBuilder();
            p=new int[n+1];
            makeset(n);
            int m=sc.nextInt();
            //queue=new LinkedList<>();
            //int count=0;
            for(int j=0;j<m;j++) {
                cal=sc.nextInt();
                int a=sc.nextInt();
                int b=sc.nextInt();
                if(cal==0) {
                    union(a,b);
                }
                else {
                    //count++;
                    //queue.add((findset(a)==findset(b))? 1:0);
                    //삼항 연산자
                    stringBuilder.append((findset(a)==findset(b))? 1:0);
                     
                }
            }
            System.out.println("#"+i+" "+stringBuilder);
        }
         
    }
 
}