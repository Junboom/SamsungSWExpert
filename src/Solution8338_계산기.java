import java.io.*;
import java.util.StringTokenizer;

public class Solution8338_계산기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for (int t_c = 1; t_c <= t; t_c++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ans = Integer.parseInt(st.nextToken());
			for (int i = 1; i < n; i++) {
				int num = Integer.parseInt(st.nextToken());
				ans = (num<=1) ? ans+num : ans*num;
			}
			
			System.out.println("#" + t_c + " " + ans);
		}

	}

}
