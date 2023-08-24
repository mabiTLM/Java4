package Public_Private_0824;

public class Main 
{
	public static void main(String[] args)
	{
//		Phone myPhone = new Phone("임"); //추상화해버려서 호출할수 없다.
//		String myPhoneNumber; //저장된 위치만 다르다
//		myPhone.number = "010-";
//		System.out.println(myPhone.number);
//		
////		myPhone.owner; private불가능
//		System.out.println(myPhone.getOwner());
//		
//		System.out.println(myPhone.operator);
////		System.out.println(Phone.model);
		
		GalaxyPhone myPhone1 = new GalaxyPhone("임","010");
		System.out.println(myPhone1.getOwner());
		System.out.println(GalaxyPhone.MANUFACTURER);
		System.out.println(IPhone.MANUFACTURER);
		
		IPhone myPhone2 = new IPhone("임","010");
		myPhone2.installApp("카톡");
		
		Phone[] myPhones = new Phone[] {myPhone1, myPhone2};
		//자식클래스들을 부모클래스에 담은 배열을 만들 수 있다.
		myPhones[0].installApp("카메라");
		myPhones[1].installApp("카메라");
		//타입변환 업캐스팅
		
		((GalaxyPhone)myPhones[0]).installApp("카메라");
		//다운캐스팅 예제, 예제 일 뿐 이렇게 쓰지말것
		
		//((GalaxyPhone)myPhone2).installApp("카메라");
		//부모도 자식도 아니라서 성립되지 않는다.
		

	}
}
