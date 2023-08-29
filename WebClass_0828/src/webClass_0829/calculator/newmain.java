package webClass_0829.calculator;

public class newmain 
{
	public static void main(String[] args)
	{
		StringCal strCal = new StringCal();
		
		String[] temp = {};
		
		temp=strCal.calculate("1/2+3*4+2");
		for(int i = 0; i < temp.length; i++) 
		{
			System.out.println(temp[i]);
		}
		
		//곱하기를하고 값을 다시 넣는다. 1+2*3-4/2 = 1+ 6 -4/2 공백 값 공백
		//나누기를하고 값을 다시 넣는다.1+ 6 - 8
		//앞에서부터 +,-부호에 따라 실행한다. 공백일경우 무시하고 다음으로넘어간다.
	}

}
