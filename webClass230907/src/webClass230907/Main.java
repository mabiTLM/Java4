package webClass230907;

public class Main {
	public static void main(String[] args) {
//		Exception e;
		// error => 문제 발생 시 해당 문제를 다른 방식으로 처리한다.
		// 예외 처리
		// 인덱스 버퍼 없을 때 << 개발할 때
		// 로그인 할 때 없는 아이디, 비밀번호 틀림, 전화번호 입력할 때 8개 숫자만 입력
		// if 입력 뭘 받았냐? => 제대로 입력이 안되면 "다시 입력해라"
		// Exception => 컴파일, 런타임을 진행하면서 에러가 발생했다 또는 발생할 확률이 있다.

		try {
			ExceptionTest.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {			
			throw new Exception("예외처리중");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
