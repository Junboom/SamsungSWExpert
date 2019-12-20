package simple;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_8822_홀수중간값피라미드1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t_c = 1; t_c <= T; ++t_c) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            sb.append("#").append(t_c);
            if (X == 1 || X == 2*N-1)   sb.append(" 0\n");
            else                        sb.append(" 1\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
