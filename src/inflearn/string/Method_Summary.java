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



	}


}

