package simple;

import java.io.*;

public class Solution_8676_동현이와한결이는아이돌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int MOD = 1000000007;
        int T = Integer.parseInt(br.readLine());
        for (int t_c = 1; t_c <= T; ++t_c) {
            char[] S = br.readLine().toCharArray();
            int[] s = new int[7];
            for (char ch : S) {
                switch (ch) {
                    case 'S':   s[0] = (s[0] + 1) % MOD;
                                s[3] = (s[3] + s[2]) % MOD; break;
                    case 'A':   s[1] = (s[1] + s[0]) % MOD; break;
                    case 'M':   s[2] = (s[2] + s[1]) % MOD; break;
                    case 'U':   s[4] = (s[4] + s[3]) % MOD; break;
                    case 'N':   s[5] = (s[5] + s[4]) % MOD; break;
                    case 'G':   s[6] = (s[6] + s[5]) % MOD; break;
                }
            }
            System.out.println("#" + t_c + " " + s[6]);
        }
    }
}
