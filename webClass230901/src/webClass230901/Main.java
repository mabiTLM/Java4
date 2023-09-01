package webClass230901;

public class Main {
	public static void main(String[] args) throws Exception {
//		Week week = Week.FRIDAY;
////		week = 1; 열거형 타입으로 정의한 변수는 해당 열거형의 데이터만 입력할 수 있다.
//		week = Week.SUNDAY;
//		switch(week) {
//			case SUNDAY:
//				System.out.println("일요일이다! 일찍자라");
//				break;
//		}
		
		int num = 1;
		int studentNum = 1; // 카멜형 student number
		int StudentNum = 1; // 파스칼형 카멜형 + 첫 문자 대문자
		int student_num = 1; // 스네이크형
		// int student-num = 1; // 케밥형
		// int IntStudentNum = 1; // 헝가리안 표기법 << 이렇게 쓰는 사람이 있으면 뒤통수를 때리면 된다.
		System.out.println(num);
		
		StringTest stringTest = new StringTest();
		stringTest.stringTest();
		
		StrBuilderTest.strBuilderTest();
		MathTest.test();
		Wrapper.test();
		DateTest.test();
	}
}
