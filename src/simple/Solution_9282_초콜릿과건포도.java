package simple;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_9282_초콜릿과건포도 {

    public static int ans, n, m;
    public static int[][] a;
    public static boolean[] nv, mv;

    public static int div1(int loc) {
        int sum = 0;
        int i = loc;
        int j = loc + 1;

        while (0 < i   && !nv[i-1]) --i;
        while (j < n-1 && !nv[j]  ) ++j;

        for (int ii = i; ii <= j; ++ii) {
            for (int jj = 0; jj < m; ++jj) {
                sum += a[ii][jj];
            }
        }

        return sum;
    }

    public static int div2(int loc) {
        int sum = 0;
        int i = loc;
        int j = loc + 1;

        while (0 < i   && !mv[i-1]) --i;
        while (j < m-1 && !mv[j]  ) ++j;

        for (int ii = 0; ii < n; ++ii) {
            for (int jj = i; jj <= j; ++jj) {
                sum += a[ii][jj];
            }
        }

        return sum;
    }

    public static void rec(int cnt, int sum) {
        if (ans < sum)
            return;
        if (cnt == n + m - 2) {
            ans = ans > sum ? sum : ans;
            return;
        }

        for (int i = 0; i < n-1; ++i) {
            if (!nv[i]) {
                nv[i] = true;
                rec(cnt + 1, sum + div1(i));
                nv[i] = false;
            }
        }
        for (int j = 0; j < m-1; ++j) {
            if (!mv[j]) {
                mv[j] = true;
                rec(cnt + 1, sum + div2(j));
                mv[j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= TC; ++tc) {
            ans = 987654321;
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            a = new int[n][m];
            for (int i = 0; i < n; ++i) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < m; ++j) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            nv = new boolean[n-1];
            mv = new boolean[m-1];

            rec(0, 0);
            System.out.println("#" + tc + " " + ans);
        }
    }

}
