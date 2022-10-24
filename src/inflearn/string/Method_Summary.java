package inflearn.string;

import java.util.Arrays;

public class Method_Summary {

	public static void main(String[] args) {
		String sample = "sTuDY";

		// 스트링의 문자를 배열형태로 다루고 싶을 때
		char[] chars = sample.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i] + " ");
		}
		System.out.println();


		// char타입의 문자가 대소문자, 혹은 숫자인경우 확인
		char c = '0';
		char c1 = '9';
		char a = 'a';
		char z = 'z';
		char A = 'A';
		char Z = 'Z';

		System.out.println(Character.isDigit(c));
		System.out.println(Character.isDigit(a));
		System.out.println(Character.isLowerCase(a));
		System.out.println(Character.isLowerCase(A));
		System.out.println(Character.isUpperCase(Z));
		System.out.println(Character.isUpperCase(z));


		//
		System.out.println("########################");
		String ss = "hello this is coding knowjam world";
		System.out.println("ss : " + ss);
		System.out.println("ss.indexOf(\"this\") : " + ss.indexOf("is"));
		System.out.println("ss.lastIndexOf(\"is\") : " + ss.lastIndexOf("is"));

		System.out.println("ss.substring(0, 5) : " + ss.substring(0, 5));
		System.out.println("ss.substring(0, 6) : " + ss.substring(0, 6));
		System.out.println("ss.substring(0, 7) : " + ss.substring(0, 7));
		System.out.println("ss.substring(8) : " + ss.substring(8));
		System.out.println("########################");

		// t스트링 빌더, 버퍼 리버스
		//직접뒤집기 구현방법

		char cc = 'z';
		System.out.println(Character.isAlphabetic(cc));
		System.out.println(Character.isLetter(cc));
		System.out.println("########################");

		// indexOf 사용해서 중복문자 제거하기
		// char 배열의 인덱스가 indexOf 값과 같으면 그 문자는 지금 처음 등장한 문자이므로
		// 배열의 인덱스와 indexOf의 값이 다르면 중복된 문자로 판단할 수 있음

		//
		System.out.println("ss22.equalsIgnoreCase(\"sSa\")) 를 사용한 대소문자 관계없이 비교하기");
		String ss22 = "ss";
		System.out.println(ss22.equalsIgnoreCase("sSa"));
		System.out.println(ss22.equalsIgnoreCase("aA"));
		System.out.println(ss22.equalsIgnoreCase("SS"));

		// 정규식 리플레이스, 영어만, 숫자만
		System.out.println("ss22.replaceAll() : 정규식을 사용한 리플레이스" );

		// 문자열내 특정 문자를 기준으로 가장 짧은 거리를 구할려면
		int p = Integer.MAX_VALUE;
		// 문자열의 처음 문자부터 순회 시작
		// 특정 문자를 만났을 때, p는 0이된다.
		// 이후 특정문자를 만나기 전까지 p는 1씩 증가되면서 값이 채워진다.
		// 특정문자를 만나면 다시 p는 0이된다. 이를 계속 끝까지 반복
		// 왼쪽에서 오른쪽으로 한번 순회했으면, 이제 반대로 오른쪽에서 왼쪽으로 순회
		// 순회하는건 똑같이 p가 특정문자를 만나면 0이되며, 이후 특정문자를 또 만날 때까지 1씩 증가하면서 값채우기
		// 이때 채워지는 값은 가장 짧은 거리를 구하는것이므로 Math.min(기존거리(왼쪽->오른쪽), 갱신거리(오른쪽->왼쪽))
		// Math 클래스의 최소값함수를 통해서 위처럼 계산하면 특정문자 기준으로 한 최단거리가 구해짐
		// 이걸 모르면 아마 특정문자개수만큼 반복문을 수행해야하므로, n대신 n제곱번 탐색해야함


		// 문자열 관련 문제중에서 String.length()를 반복문을 사용해서
		// 문자열의 각 문자를 순회해서 뭔가 비교하거나 검증할 때가 있을텐데
		// 항상 끝 부분에서 처리를 위해 if(현재 인덱스가 끝인가?)를 검증했는데
		// 그럴필요 없이 문자열에 마지막에 " " 빈 문자를 넣어주고 순회는 문자열길이-1 만큼 하면
		// 전부 다 순회할 수 있었음...


		// 문자열을 교체할 떄  replace 사용
		// 문자열이 이진법, 십진법, 팔진법 등등 일떄 십진법 숫자로 뽑는법 Integer.parseInt("해당진법표현숫자", "해당진법")


	}


}

