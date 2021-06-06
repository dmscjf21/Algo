package Baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class 상어초등학교_21608 {
	
	static int N;
	static int[][] map;
	static int[] dI = {-1,1,0,0}; //상하좌우
	static int[] dJ = {0,0,-1,1};		
	static HashSet[][] info;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		info = new HashSet[N+1][N+1];
		answer=0;
		//입력
		for (int i = 1; i <= N*N; i++) {
			int num = sc.nextInt();
			HashSet<Integer> hs = new HashSet<>();
			for (int j = 0; j < 4; j++) {
				hs.add(sc.nextInt());
			}
			//자리배정
			allocate(num,hs);
		}
		sc.close();
		
	
		//만족도 조사
	
		satisfaction();

		
		//print();
		System.out.println(answer);
	}

	private static void satisfaction() {
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <=N; j++) {
				int count =0;
				for (int d = 0; d < 4; d++) {
					int nextI  = i+dI[d];
					int nextJ = j+dJ[d];
					if(!check(nextI,nextJ))continue;
					if(info[i][j].contains(map[nextI][nextJ])) {
						count++;
					}
				}
				answer+=(count==0?0:Math.pow(10,count-1));
			}
			
		}

	}

//	private static void print() {
//		for (int i = 1; i <=N; i++) {
//			for (int j = 1; j <=N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
//	}

	private static void allocate(int num,HashSet<Integer> hs) {
		int Maxempty=-1;
		int Maxfavorite=-1;
		int saveI=0;
		int saveJ=0;
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <=N; j++) {							
				//빈자리라면
				if(map[i][j]==0) {
					int empty=0;
					int favorite=0;	
					//주변 체크
					for (int d = 0; d <4; d++) {
						int nextI = i+dI[d];
						int nextJ = j+dJ[d];
						if(!check(nextI,nextJ))continue;
						//비어있다면
						if(map[nextI][nextJ]==0) {
							empty++;
						}
						//비어있지않다면
						if(hs.contains(map[nextI][nextJ])) {
							favorite++;
						}
					}
					//자리 저장하기
					if(favorite>Maxfavorite) {
						Maxfavorite =favorite;
						saveI= i;
						saveJ =j;
						Maxempty =empty;
					}
					else if(favorite==Maxfavorite) {
						if(empty>Maxempty) {
							saveI = i;
							saveJ = j;
							Maxempty=empty;
						}
					}
				
				}
				
			}
		}
		//System.out.println(n+"번쨰 : i : "+saveI+" j : "+saveJ);
		map[saveI][saveJ]= num;	
		info[saveI][saveJ]=hs;
	}

	private static boolean check(int i, int j) {
		if(i<1|| j<1 || i>N || j>N)return false;
		return true;
	}

}
