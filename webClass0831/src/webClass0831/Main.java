package webClass0831;

public class Main {//extends Object 항상 오브젝트라는 클래스를 상속받고있다.
	public static void main(String[] args) throws Exception
	{ //왜 안바뀔까
		//클래스는 무조건 인스턴스를 만들어야 한다? Y / N
		//클래스는 우리가 이름을 지을 때, 명명할 때 어떻게 한다?
		//=>첫 char가 대문자다.
		//String, System, Math
		//위에처럼 알아서 가져다 사용하는 것들을 기본 모듈이라고 얘기할 수 있다.
		//java.lang에서 가져온다.
		//Scanner << java.util에 포함되어있다.
		//위와 같이 다운받거나 설치하지 않은 모듈들을 표준 모듈이라고 한다.
		//java.lang << 어떤 것들이 포함되어 있을까?
		//Object, System, String, StringBuilder, Math, Class
		
		//우리는 항상 Object를 써왔다.
		//Object는 최상위 클래스이다.
		
//		Object obj = new Object();
		Main main = new Main();
//		main. 오브젝트를 포함하는걸 볼 수 있다.
		
		EqualsTest et1 = new EqualsTest(1,"test");
		EqualsTest et2 = new EqualsTest(1,"test");
		EqualsTest et3 = et1;
		EqualsTest2 et4 = new EqualsTest2("test");
		System.out.println(et1.equals(et2));//주소를 가져온 상태라 다르게 인식한다.
		System.out.println(et1.equals(et3));
		System.out.println(et1.equals(et4));
		
		System.out.println("aaa"=="aaa");//자바에서 처리해줘서 같다
		
		System.out.println(et1.hashCode());
		System.out.println(et2.hashCode());
		System.out.println(et1.name.hashCode()); //hashCode 내용물을 가지고 메모리 주소를 만든다.
		System.out.println(et2.name.hashCode());
		
		System.out.println(et1.toString());
		System.out.println(et2.toString());
		
		RecordTest recordTest=new RecordTest(1,"test");//로그인만들기
		RecordTest recordTest2=new RecordTest(1,"test");
		
		System.out.println(recordTest.num());
		System.out.println(recordTest2.hashCode());
		System.out.println(recordTest2.name());
		System.out.println(recordTest.toString());
		System.out.println(recordTest2.toString());
		System.out.println(recordTest2.equals(recordTest));
		
		//위가 전부 Object
		
		//System
		System.out.print(""); // out은 콘솔창에 출력한다.
		System.out.println("");//ln = line 한줄을 출력한다.
		
		//System.in; // 키보드를 입력받는다.
//		int keyInput = 0;
//		while(true)
//		{
//			keyInput = System.in.read();
//			
//			System.out.println(keyInput);
//			break;
//		}
		//System.currentTimeMillis(); //현재 시간을 ms 단위로 받아온다.
		//System.out.println(System.nanoTime()); // 나노 단위의 현재 시간을 받아온다.
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
		//0년이 아니라 1970년을 기준으로 시간을 체크한다. 용량을 많이 소모하니 밀리세컨드단위로 저장한다.
		//GMT 그리니치 시간 : 영국이 GMT + 0 / 한국 GMT + 9
		//UTC, ms 단위
		//Date type 영국에 아직도 돌아가고있는 컴퓨터가 시간을 체크하고 있다.
//		System.exit(0);
		
		System.out.println("Java Version : " + System.getProperty("java.sepcification.version"));
		System.out.println("JDK Directory : " + System.getProperty("java.home"));
		System.out.println("OS : " + System.getProperty("os.name"));
		System.out.println("user : " + System.getProperty("user.name"));
		System.out.println("user Directory : " + System.getProperty("user.home"));
		System.out.println("directory : " + System.getProperty("user.dir"));
	}

}

class EqualsTest2 {
	String name;
	EqualsTest2(String name)
	{
		this.name = name;
	}
}