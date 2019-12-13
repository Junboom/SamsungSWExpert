import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8107 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t_c = 1; t_c <= T; t_c++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int[][] classTime = new int[N][2];
			int[][] pathTime = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					classTime[i][j] = Integer.parseInt(st.nextToken());
				}
			}			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					pathTime[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dpClassTime = new int[N+1][N+1];
			int[][] dpWholeTime = new int[N+1][N+1];
			int ss = s;
			
			for (int i = s; i <= s+N; i++) {
				int k = i % N;
				k += 1;
				
				for (int j = 1; j <= N; j++) {
					dpClassTime[k][j] = dpClassTime[ss][k];
					dpWholeTime[k][j] = dpWholeTime[ss][k];
					if (dpWholeTime[k][j] + pathTime[ss-1][j-1] <= classTime[ss][j]) {
						dpClassTime[k][j] += classTime[ss][1] -
								(dpWholeTime[ss][j] < classTime[ss][0] ? classTime[ss][0] : dpWholeTime[ss][j]);
						dpWholeTime[k][j] += classTime[ss][1];
					}
				}
			}
			
			System.out.println();
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					System.out.print(dpClassTime[i][j] + " ");
				}
				System.out.println();
			}
			
			System.out.println("#" + t_c + " " + dpClassTime[N][N]);
		}
	}

}
