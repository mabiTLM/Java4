package webClass230907;

public class ExceptionTest {
	public static void test() throws Exception
	{
		try {
			//가장 기본적인 예외처리 방법
			//try catch finally : 어떤 언어든지 다있다. 그리고 다 똑같다.
			int[] arr = new int[] {1};
			System.out.println(arr[1]);
			
		}catch(Exception e) {//업캐스팅ArrayIndexOutOfBoundsException
			
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
		finally {// 별 의미는 없다.
			System.out.println("무조건 실행");
		}
		
		new ExceptionTest().printLength(null);
	}
	
	public void printLength(String str)
	{
		int result = str.length();
		System.out.println("str's length is"+result);
	}

}
