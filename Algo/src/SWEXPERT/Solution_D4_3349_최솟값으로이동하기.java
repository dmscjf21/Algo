package SWEXPERT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_3349_최솟값으로이동하기 {
	
	static int T ,W,H,N,answer;
	
	static Queue<Point> qu;
	static class Point{
		int i,j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
	
		for (int tc = 1; tc <= T; tc++) {			
			W = sc.nextInt();
			H = sc.nextInt();
			N = sc.nextInt();
			init();
			for (int i = 0; i < N; i++) {
				qu.offer(new Point(sc.nextInt(),sc.nextInt()));
			}
			solution();
			System.out.println("#"+tc+" "+answer);
			
		}
	}

	private static void solution() {
		for (int i = 1; i < N; i++) {			
			Point start = qu.poll();
			Point end = qu.peek();
			while(start.i!=end.i||start.j!=end.j) {
				if(end.i>start.i && end.j>start.j) {
					start.i++;
					start.j++;
					answer++;
				}
				else if(end.i<start.i && end.j<start.j) {
					start.i--;
					start.j--;
					answer++;
				}
				else if(end.i>start.i) {
					start.i++;
					answer++;
				}
				else if(end.i<start.i) {
					start.i--;
					answer++;
				}
				else if(end.j>start.j) {
					start.j++;
					answer++;
				}
				else if(end.j<start.j) {
					start.j--;
					answer++;
				}
			}
		}
		
	}

	public static void init() {
		qu = new LinkedList<>();
		answer= 0;
	}

}
