package Programmers;

public class 신규아이디추천 {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String new_id = "asdfgagdg";
		
		//1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
		new_id = new_id.toLowerCase();
		
		//2단계  new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
		// id = id.replaceAll("[^_-.a-z0-9]","")
		String id = "";
		for(int i = 0; i < new_id.length(); i++) {
			char ch = new_id.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
				id += String.valueOf(ch);
			} else if(ch >= '0' && ch <= '9') {
				id += String.valueOf(ch);
			} else if(ch == '.' || ch == '-' || ch == '_') {
				id += String.valueOf(ch);
			}
		}
		
		//3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.		
		//id = id.replaceAll("^[.]{2,}", ".")
		for(int i = 0; i < id.length(); i++) {
			if(id.charAt(i) == '.') {
				int j = i+1;
				String dot = ".";

				while(j != id.length() && id.charAt(j) == '.') {
					dot += ".";
					j++;
				}

				if(dot.length() > 1)
					id = id.replace(dot, ".");
			}
		}
		
		//4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		//-> id = id.replaceAll("^[.]|[.]$", "")
		if(id.startsWith(".") ) {
			id = id.substring(1, id.length());
		} else if(id.endsWith(".")) {
			id = id.substring(0, id.length()-1);
		}
		
		//5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		if(id.length()==0) {
			id+= "a";
		}
		
		//6단계 new_id의 길이가 16자 이상이면,
		if(id.length()>=16) {
			id = id.substring(0,id.length()-1);
		}
		//마지막이 .이라면 삭제
		if(id.endsWith(".")) {
			id = id.substring(0,id.length()-1);
		}
		
		//7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
		while(id.length()<=2) {
			id += id.charAt(id.length()-1);
		}
	}

}
