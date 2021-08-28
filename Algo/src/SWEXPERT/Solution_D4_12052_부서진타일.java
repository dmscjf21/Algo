package SWEXPERT;

import java.util.*;

public class Solution_D4_12052_부서진타일 {
	
	static char[][] map;
	static boolean[][] visited;
	static int T,N,M;
	static int[] dI = {0,1,1};
	static int[] dJ = {1,0,1};
	static Queue<Point> qu;
	static String answer;
	static class Point{
		int i,j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T= sc.nextInt();
		for (int tc = 1; tc <=T; tc++) {
			N= sc.nextInt();
			M= sc.nextInt();
			map= new char[N][M];
			visited = new boolean[N][M];
			qu = new LinkedList<>();
			answer ="YES";
			
			for (int i = 0; i < N; i++) {
				map[i]= sc.next().toCharArray();
			}
			
			a:for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]=='#' && !visited[i][j]) {
						qu.add(new Point(i,j));
						answer = search();
						if(answer =="NO")break a;
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}

	private static String search() {
		
			Point cur = qu.poll();
			for (int d = 0; d < 3; d++) {
				int nextI = cur.i+ dI[d];
				int nextJ = cur.j+dJ[d];
				if(!check(nextI,nextJ)) {
					qu.clear();
					return "NO";
				}
				if(map[nextI][nextJ] !='#') {
					qu.clear();
					return "NO";
				}
				else if(map[nextI][nextJ]=='#') {
					visited[nextI][nextJ]=true;
				}
	
		}
		return "YES";
	}

	private static boolean check(int nextI, int nextJ) {
		if(nextI<N && nextJ <M)return true;
		return false;
	}

}
