package webClass0831;

public class EqualsTest {
	String name;
	int num;
	EqualsTest(int num, String name)
	{
		this.num=num;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
//		if(obj instanceof EqualsTest) //instanceof 연산자 앞에붙은게 위에 타입을 가졌나?
//		{
//			if(num == ((EqualsTest)obj).num && ((EqualsTest)obj).name.equals(name))//스트링이 참조형이지만 비교가능하다.
//				{
//				return true;
//				}
//			
//		}
//		
//		
//		if(obj instanceof EqualsTest&&((EqualsTest)obj).name.equals(name))
//		{
//			return true;
//			}
		if(!(obj instanceof EqualsTest)) return false;
		
		if(!((EqualsTest)obj).name.equals(name)) return false;
		
		if(num != ((EqualsTest)obj).num) return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		return num + name.hashCode();
	}
	
	@Override
	public String toString()//문자열로 바꿔줌
	{
		return "제 이름은 " + name + "입니다. 나이는 " + num + "살 입니다." ;
	}

}
