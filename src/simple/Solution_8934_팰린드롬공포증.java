package simple;

import java.io.*;

public class Solution_8934_팰린드롬공포증 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t_c = 1; t_c <= T; ++t_c) {
            String S = br.readLine();
            int[] s = new int[3];
            int min = 987654321;
            int max = 0;

            for (int i = 0; i < S.length(); ++i)
                ++s[S.charAt(i) - 'a'];
            for (int i = 0; i < 3; ++i)
                min = min > s[i] ? s[i] : min;

            for (int i = 0; i < 3; ++i)
                s[i] -= min;
            for (int i = 0; i < 3; ++i)
                max = max < s[i] ? s[i] : max;

            if (max < 2)
                System.out.println("#" + t_c + " YES");
            else
                System.out.println("#" + t_c + " NO");
        }
    }
}
