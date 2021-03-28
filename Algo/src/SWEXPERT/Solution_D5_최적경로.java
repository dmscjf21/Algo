package SWEXPERT;

import java.util.Scanner;

public class Solution_D5_최적경로 {
	
	static int T,N,input[],answer;
	static boolean check[];
	static Home[] home;
	static class Home{
		int x,y;

		public Home(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <=T; tc++) {
			N= sc.nextInt();
			input= new int[N+2];
			home = new Home[N+2];
			check = new boolean[N+2];
			answer= Integer.MAX_VALUE;
			for (int i = 0; i < N+2; i++) {
				home[i] = new Home(sc.nextInt(),sc.nextInt());
			}
			nCr(2,2);
			System.out.println("#"+tc+" "+answer);
		}
	}

	private static void nCr(int start, int cnt) {
		if(cnt==N+2) {
			input[0]=0;
			input[1]= 1;
			int find=0;
			for (int i = N+1; i >2; i--) {
				find += Math.abs(home[input[i-1]].x-home[input[i]].x)
						+Math.abs(home[input[i-1]].y-home[input[i]].y);			
			}
			//마지막 집에서 내 집으로
			find += Math.abs(home[input[1]].x-home[input[N+1]].x)
					+Math.abs(home[input[1]].y-home[input[N+1]].y);		
			//회사에서 첫집으로
			find += Math.abs(home[input[0]].x-home[input[2]].x)
					+Math.abs(home[input[0]].y-home[input[2]].y);		
			
			answer = Math.min(answer, find);
//			for (int i = 0; i < N+2; i++) {
//				System.out.print(input[i]+" ");
//			}
//			System.out.println();
			return;
		}
		for (int i = start; i < N+2; i++) {
			if(!check[i]) {
				input[cnt]= i;
				check[i]= true;
				nCr(start,cnt+1);
				check[i]=false;
			}			
		}		
	}

}
