import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution8049_폭탄감식반 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		char[] bomb1 = { 'F', 'F', 'M', 'C', 'M' };
		char[] bomb2 = { 'F', 'C', 'M', 'F' };
		
		loop:for (int t_c = 1; t_c <= t; t_c++) {
			char[] bomb = br.readLine().toCharArray();
			System.out.print("#" + t_c + " ");
			
			int i = 0;
			while (i < bomb.length) {
				if (bomb[i] == 'F') {
					if (bomb[i+1] == 'F') {
						++i;
						for (int j = 1; j <= 5; j++) {
							if (j == 5) {
								if (i < bomb.length && bomb[i] == 'M') {
									++i;
									--j;
								}
							}
							else {
								if (bomb[i] == bomb1[j]) {
									++i;
								}
								else if (j == 2 && bomb[i] == 'F') {
									++i;
									--j;
								}
	 							else {
									System.out.println("NOTHING!");
									continue loop;
								}
							}
						}
					}
					else if (bomb[i+1] == 'C') {
						++i;
						for (int j = 1; j < 4; j++) {
							if (j == 2 && bomb[i] == 'C') {
								++i;
								--j;
							}
							else if (bomb[i] == bomb2[j]) {
								++i;
							}
							else {
								System.out.println("NOTHING!");
								continue loop;
							}
						}
					}
					else {
						System.out.println("NOTHING!");
						continue loop;
					}
				}
				else {
					System.out.println("NOTHING!");
					continue loop;
				}
			}
			System.out.println("DETECTED!");
		}
		
	}

}
