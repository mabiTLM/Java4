package webClass0904;



//제네릭 메서드는 호출되는 시점에 실제 제네릭 타입을 지정한다.
//1. 제네릭 타입변수명이 1개일때
//접근 지정자 <T> T 메서드 이름(T t)
//2.두개일 경우
//접근 지정자 <T, V> T 메서드 이름(T t,V v)

//3.매개변수에만 제네릭이 사용된 경우
// 접근 지정자<T> void 메서드 이름(T t){}

//4.리턴타입에만 사용된 경우
//접근 지정자<T> T 메서드 이름(int a){}

class GenericMethod{
	public <T> T method(T t)
	{
		return t;
	}
	
	public <T> boolean method2(T t1,T t2)
	{
		return t1.equals(t2);//타입이 안정해져있기에 최상위 클래스인 Object것만 쓸수 있다.
	}
	
	public <K,V> void method3(K k, V v)
	{
		System.out.println(k+ " : "+v);
	}
}

class A{
	public <T> void method(T t)
	{
		System.out.println(t.equals("안녕"));
		//정의시점에서 어떤 타입인지 알수도 없고 자바의 모든 클래스는 Object클래스가 최상위 이므로
		//어떤 제약도 받지 않는 Object내장 메서드만 사용가능하다.
		//System.out.println(t.length()); 이런건 안된다.

	}
}

public class Generic01 {
	
	public static <T> void Swap(T[] array, int index1, int index2)//어떤 형태든 바꿀 수 있다.
	{
		T temp = array[index1];
		array[index1]=array[index2];
		array[index2]=temp;
	}
	
	public static void main(String[] args)
	{
		GenericMethod gm = new GenericMethod();
		
		String str1 = gm.<String>method("안녕");
		
		String str2 = gm.method("안녕2");//입력매게변수값으로 유추가 가능하면 참조를 빼도된다.
		
		System.out.println(str1);
		System.out.println(str2);
		
		boolean b1=gm.method2(2.5, 2.5);
		
		System.out.println(b1);
		
		gm.<String,Integer>method3("국어", 10);
		gm.method3("수학",20);
	}

}
