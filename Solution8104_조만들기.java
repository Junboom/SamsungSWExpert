import java.io.*;
import java.util.StringTokenizer;

public class Solution8104_조만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int t_c = 1; t_c <= t; t_c++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			System.out.print("#" + t_c);
			if (n % 2 == 0) {
				int ans = (1 + n * k) * (n >> 1);
				for (int i = 0; i < k; i++) {
					System.out.print(" " + ans);
				}
			}
			else {
				int ans = (1 + (n-1) * k) * (n >> 1);
				for (int i = (n-1)*k+1; i <= n*k; i++) {
					System.out.print(" " + (ans+i));
				}
			}
			System.out.println();
		}
	}

}
