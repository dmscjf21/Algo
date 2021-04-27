package Baekjoon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class 숫자고르기_2668 {
	static int N;
	static int last;
	static int[] arr;
	static boolean[] check;
	static ArrayList<Integer> list;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		check = new boolean[N+1];
		 list = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			
			arr[i] = sc.nextInt();			
		}
		for (int i = 1; i <=N; i++) {
			check[i]=true;
			last = i;
			dfs(i);
			check[i]=false;
			
		}
	    Collections.sort(list);    // 작은수 부터 출력해야하므로 젖ㅇ렬
        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i);    //list들을 하나씩 출력해준다.
        }
	}

	private static void dfs(int cnt) {
		
		  if (!check[arr[cnt]]) {     //이전에 방문한 점이 아니여야한다.
			  check[arr[cnt]] = true;     // 방문했으므로 true
	            dfs(arr[cnt]);
	            check[arr[cnt]] = false; // 다음 DFS들을 위하여 false
	        }
	        if (arr[cnt] == last) {    //마지막 점이 출발점과 같다면 사이클이 완성됐으므로 리스트에 추가
	            list.add(last);
	        }
		
	}



}
