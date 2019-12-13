import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution8383_숫자선물 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int t_c = 1; t_c <= t; t_c++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String n = st.nextToken();
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n.length(); i++) {
				int nn = n.charAt(i) - '0';
				if (nn < x && nn < y)
					continue;
				int max = x > y ? x : y;
				if (max <= nn) {
					sb.append(max);
				}
				else {
					sb.append(nn >= x ? x : y);
				}
			}
			
			
			System.out.println("#" + t_c + " " + ((sb.toString().equals("") || sb.toString().equals("0")) ? -1 : sb.toString()));
		}
	}
}
