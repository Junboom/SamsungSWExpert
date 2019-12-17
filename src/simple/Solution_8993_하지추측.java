package simple;

import java.io.*;

public class Solution_8993_하지추측 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        loop:for (int t_c = 1; t_c <= T; ++t_c) {
            long N = Long.parseLong(br.readLine());
            while (N > 1) {
                if (N % 2 == 1) {
                    System.out.println("#" + t_c + " NO");
                    continue loop;
                }
                N /= 2;
            }
            System.out.println("#" + t_c + " YES");
        }
    }
}
