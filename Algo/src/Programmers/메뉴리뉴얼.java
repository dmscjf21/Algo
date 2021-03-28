package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
public class 메뉴리뉴얼 {

	static class Menu {
		String name;
		int count;

		Menu(String name, int count) {
			this.name = name;
			this.count = count;
		}
	}

    public static boolean[] v = new boolean[20];
    public static Map<String, Integer> map = new HashMap<String, Integer>();
    
	public static String[] solution(String[] orders, int[] course) {
		 PriorityQueue<Menu> pq = new PriorityQueue<Menu>(new Comparator<Menu>() {
	            @Override
	            public int compare(Menu arg0, Menu arg1) {
	                return Integer.compare(arg1.count, arg0.count);
	            }
	        });
		 
	        List<String> list = new ArrayList<String>();
	        for(int i=0; i<orders.length; i++) orders[i] = sortString(orders[i]);
	        for(int i=0; i<course.length; i++) {
	            for(int j=0; j<orders.length; j++) {
	                if(orders[j].length()<course[i]) continue;
	                comb("", -1, 0, course[i], orders[j]);
	            }
	            int max = Integer.MIN_VALUE;
	            for(String key : map.keySet()) {
	                int count = map.get(key);
	                if(max<=count) {
	                    max = count;
	                    pq.add(new Menu(key, count));
	                }
	            }
	            while(max!=1 && !pq.isEmpty()) {
	                Menu menu = pq.poll();
	                if(menu.count==max) list.add(menu.name);
	                else break;
	            }
	            pq.clear();
	            map.clear();
	        }
	        String[] answer = new String[list.size()];
	        for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
	        Arrays.sort(answer);
	        return answer;
	    }

	public static void main(String[] args) {
		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		int[] course = { 2, 3, 4 };
		String[] answer = solution(orders, course);
		for (int i = 0; i < answer.length; i++)
			System.out.println(answer[i]);
	}

	 public static void comb(String menu, int before, int count, int courseCount, String order) {
	        if(count>=courseCount) {
	            if(map.containsKey(menu)) map.put(menu, map.get(menu)+1);
	            else map.put(menu, 1);
	            return;
	        }
	        
	        for(int i=before+1; i<order.length(); i++) {
	            if(!v[i]) {
	                v[i] = true;
	                comb(menu+order.charAt(i), i, count+1, courseCount, order);
	                v[i] = false;
	            }
	        }
	    }

	public static String sortString(String s) {
		char[] ch = s.toCharArray();
		Arrays.sort(ch);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ch.length; i++)
			sb.append(ch[i]);
		return sb.toString();
	}
}
