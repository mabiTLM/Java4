package webClass230901;

public class Wrapper {
	public static void test() {
		// String, System, StringBuilder, Math, Record
		// Wrapper는 클래스들의 통칭이다. 원시 타입을 클래스로 묶어준다. 클래스로 감싸준다.
		// Integer(int) / Byte(byte) / Double(double) / Float(float)
		// Long(long) / Character(char) / Boolean(boolean) / Short(short)
		
		Integer wrappedInt = 1000;
		System.out.println(wrappedInt);
		int unwrappedInt = wrappedInt; // 자동 타입 변환
		int unwrappedInt2 = wrappedInt.intValue();
		Integer wrappedInt2 = 1000;
		System.out.println(wrappedInt == wrappedInt2);
		// == 을 사용하여 비교할 경우 일정한 범위 내에서는 같다고 결과 나온다.
		// 하지만 그 범위를 벗어날 경우 다르다 라고 나오게 된다.
		// boolean => true, false
		// byte, short, int => -128 ~ 127
		// byte => 최소값 : -128 / 최대값 : 127
		// short => -32768 ~ 32767
		// int => 약 -21억 ~ 21억
		byte temp = 127;
		System.out.println(++temp);
		System.out.println(--temp);
		// unsigned? unsigned int => uInt
		// 1 byte => 8 bit => 2진수로 1111 1111 => 255
		// byte temp => 1 byte => 숫자를 몇까지? => 255 => -128 ~ 127

		System.out.println(wrappedInt.equals(wrappedInt2));
	}
}
