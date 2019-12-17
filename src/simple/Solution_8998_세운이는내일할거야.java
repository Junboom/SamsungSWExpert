package simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8998_세운이는내일할거야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine().trim());
        for (int x = 1; x <= TC; ++x) {
            int MAX = 1000000001;
            int ans = 0;
            int N = Integer.parseInt(br.readLine().trim());
            boolean[] cnt = new boolean[MAX];
            int min = MAX;

            for (int n = 0; n < N; ++n) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                int T = Integer.parseInt(st.nextToken());
                int D = Integer.parseInt(st.nextToken());
                int s = D - T;

                for (int t = s; t < D; ++t) {
                    if (cnt[t]) ++ans;
                    else        cnt[t] = !cnt[t];
                }
                min = min > s ? s : min;
            }

            System.out.println("#" + x + " " + (min - ans));
        }
    }
}
