import java.io.*;
import java.util.ArrayList;
 
public class Solution7586 {
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for (int t_c = 1; t_c <= T; t_c++) {
            int ans = 0;
            int N = Integer.parseInt(br.readLine());
            char[][] room = new char[N][N];
            for (int i = 0; i < N; i++)
                room[i] = br.readLine().toCharArray();
            ArrayList<int[]> carpets = new ArrayList<>();
             
            for (int i = 0; i < N; i++) {
                loop1:for (int j = 0; j < N; j++) {
                    loop2:for (int h = 1; h <= N; h++) {
                        for (int w = 1; w <= N; w++) {
                            if (w*h == 1 || i+h > N || j+w > N)
                                continue;
                             
                            int ii = 0;
                            int jj = 0;
                            for (ii = i; ii < i+h; ii++) {
                                if (room[ii][j] == 'W')
                                    continue loop1;
                                for (jj = j; jj < j+w; jj++) {
                                    if (room[ii][jj] == 'W')
                                        continue loop2;
                                }
                            }
                            if (ii == i+h && jj == j+w)
                                carpets.add(new int[] {i, j, h, w});
                        }
                    }
                }
            }
             
            for (int i = 0; i < carpets.size(); i++) {
                loop3:for (int j = i+1; j < carpets.size(); j++) {
                    int[] c1 = carpets.get(i);
                    int[] c2 = carpets.get(j);
                     
                    for (int k = c1[0]; k < c1[0]+c1[2]; k++) {
                        for (int l = c2[0]; l < c2[0]+c2[2]; l++) {
                            if (k == l) {
                                for (int m = c1[1]; m < c1[1]+c1[3]; m++) {
                                    for (int n = c2[1]; n < c2[1]+c2[3]; n++) {
                                        if (m == n)
                                            continue loop3;
                                    }
                                }
                            }
                        }
                    }
                    ++ans;
                }
            }
             
            System.out.println("#" + t_c + " " + ans%10007);
        }
         
    }
     
}
