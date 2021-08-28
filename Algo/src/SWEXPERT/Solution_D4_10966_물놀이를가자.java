package SWEXPERT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_10966_물놀이를가자 {

	static char[][] map;
	static int T, N, M;
	static int answer;
	static int[] dI = { 0, 0, -1, 1 };
	static int[] dJ = { -1, 1, 0, 0 }; // 좌우상하
	static boolean[][] visited;
	static Queue<Point> qu;

	static class Point {
		int i, j, count;

		public Point(int i, int j, int count) {
			super();
			this.i = i;
			this.j = j;
			this.count = count;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();

			// 초기화
			map = new char[N][M];
			visited = new boolean[N][M];
			qu = new LinkedList<>();
			answer = 0;

			for (int i = 0; i < N; i++) {
				map[i] = sc.next().toCharArray();	
			}
			
			for (int i = 0; i < N; i++) {			
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'L') {
			
						visited[i][j] = true;
						qu.offer(new Point(i, j, 0));
					    BFS();						
					}
					visited = new boolean[N][M];
				}
			}
			//print();
		
			System.out.println("#" + t + " " + answer);
		}
		sc.close();
	}

	private static void BFS() {
		while (!qu.isEmpty()) {
			Point now = qu.poll();

			for (int d = 0; d < 4; d++) {
				int nextI = now.i + dI[d];
				int nextJ = now.j + dJ[d];
				if (!check(nextI, nextJ)) continue;				
			
				if (!visited[nextI][nextJ] && map[nextI][nextJ]=='L') {
					visited[nextI][nextJ] = true;
	
					qu.offer(new Point(nextI, nextJ, now.count + 1));
				}
				else if(!visited[nextI][nextJ] && map[nextI][nextJ]=='W') {					
					answer += now.count+1;
					qu.clear();
					return;
				}		

			}

		}

	}

	
	private static boolean check(int nextI, int nextJ) {
		if(nextI >=0 && nextJ >=0 && nextI<N && nextJ<M)return true;
		return false;
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
