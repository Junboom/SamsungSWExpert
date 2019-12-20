package simple;

import java.io.*;

public class Solution_2983_두번이상등장하는문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t_c = 1; t_c <= T; ++t_c) {
            int ans = 0;
            int L = Integer.parseInt(br.readLine());
            char[] S = br.readLine().toCharArray();
            for (int l = 1; l < L; ++l) {
                int len = 0;
                for (int s = 0; s < L-l; ++s) {
                    if (S[l+s] == S[s]) {
                        if (len == 0) {
                            if (l + s + ans < L && S[l + s + ans] == S[s + ans]) {
                                s += len += ans + 1;
                                ans = ans < ++len ? len : ans;
                            }
                            else break;
                        }
                        else ans = ans < ++len ? len : ans;
                    }
                    else len = 0;
                }
            }
            System.out.println("#" + t_c + " " + ans);
        }
    }
}
