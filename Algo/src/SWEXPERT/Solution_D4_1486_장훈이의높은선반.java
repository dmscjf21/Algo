package SWEXPERT;

import java.util.Scanner;

public class Solution_D4_1486_장훈이의높은선반 {
	
	static int T,N,B;
	static int[] H;
	static int answer;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <=T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			H = new int[N];
			
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				H[i] = sc.nextInt();				
			}
			
			nPr(0,0);
			System.out.println("#"+tc+" "+answer);
		}
	}

	private static void nPr(int start, int sum) {
		if(start==N) {
			if(sum>= B) {
				answer = Math.min(answer, sum-B);
			}
			
			return;
		}
		
		nPr(start+1, sum+H[start]);
		
		nPr(start+1,sum);
	}

}
