package webClass230908;

public class Main {
	public static void main(String[] args) {
		// Lambda
		//   - 람다식 : 메서드 그 자체(
		//   - 이름이 없다.
		//   - 타입은? X
		//   - ()->{}
		//   이름없고 타입없어서 (){}만 남는다.
		//   - 매개변수는 있다.
		//   - 코드
		//   - 어따 쓸까?
		//     - Functional Programming
		//     - 함수형 프로그래밍
		//     - main(()->{})
		//     - for(int i : arr){} << forEach
		//     - foreach((int i)->{i*2})
		//   - 람다식을 매개변수로 받는 매서드를 만들수 있어야 한다.
		//   - interface를 사용해서 미리 내용을 선언해둔다.
		//   - foreach((i)->{i*2}) 미리 선언했으니 타입 적을 필요업다.
		// Stream
		//   - 데이터를 쪼개서 한번에 처리할 수 있는 양으로 
		//   - 유튜브 스트리밍? => 유튜브 라이브, 녹화된 동영상, 동영상 파일을 다운 받지 않고 실시간으로 조각된 파일을 재생한다.
		//   - 하나의 데이터 => 배열, 셋, 맵 얘네는 나눌수 있다.
		//   람다식으로 내장된 메서드를 사용한다. 오버라이드도 가능
		// TodoList
		//	   - 애플리케이션 설계
//		
//		FuncTest.test();
		StreamTest.test();
	}
}
