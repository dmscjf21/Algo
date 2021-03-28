package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 로봇청소기_14503 {

	static int N, M, answer;
	static int[][] map;
	static int[] dI = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dJ = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static Point point;
	static Queue<Point> qu;
	
	static class Point{
		int i,j,dir,cnt;

		public Point(int i, int j, int dir,int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.dir = dir;
			this.cnt = cnt;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		answer =0;
		
		point = new Point(sc.nextInt(), sc.nextInt(), sc.nextInt(),0);
		qu = new LinkedList<>();
		qu.offer(point);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		while(!qu.isEmpty()) {
			Point now = qu.poll();
	
			int dir=0;
			int nextI=0;
			int nextJ=0;
			//현재자리 청소
			if(!visited[now.i][now.j]) {
				visited[now.i][now.j]= true;			
				answer++;
			}			
			//사방이 벽 or 청소한 공간이라면
			if(now.cnt==4) {
				dir = (now.dir+2)%4;
				nextI = now.i+dI[dir];
				nextJ = now.j+dJ[dir];
			
				//범위밖으로 나가지 않는다면
				if(check(nextI,nextJ)) {
					//벽이아니라면
					if(map[nextI][nextJ]==0) {
						qu.offer(new Point(nextI,nextJ,now.dir,0));
					}
					//후진하는 곳이 벽이라면 정지
					else {
						break;
					}
				}
				//범위밖으로 나간다면
				else {
					break;
				}		
				continue;
			}	
			
			
			//현재위치에서 왼쪽이 청소 안되어있다면? 
			//i)방향바꾸기
			dir = (now.dir-1);
			if(dir<0)dir =3;
			nextI = now.i+dI[dir];
			nextJ = now.j+dJ[dir];
	
			//범위밖으로 나가지 않는다면
			if(check(nextI,nextJ)) {
				//빈공간이라면(a)
				//그쪽으로 이동			
				if(!visited[nextI][nextJ] && map[nextI][nextJ]==0) {
					qu.offer(new Point(nextI,nextJ,dir,0));
				}
				//청소를했거나 벽이라면(b)
				//방향만 전환
				else if(visited[nextI][nextJ] || map[nextI][nextJ]==1) {
					qu.offer(new Point(now.i,now.j,dir,now.cnt+1));
				}
			}
			//범위밖으로 나간다면 방항만 바꿔주기
			else {
				qu.offer(new Point(now.i,now.j,dir,now.cnt+1));
			}
		}
		
		System.out.println(answer);
		
	}

	private static boolean check(int nextI, int nextJ) {
		if(nextI >=0 && nextJ >=0 && nextI<N && nextJ<M)return true;
		return false;
	}


}
