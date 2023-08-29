package webClass_0829.calculator;

public class newmain 
{
	public static void main(String[] args)
	{
		StringCalcInterface a = new StringCalcInterface();
		
		String[] temp = {};
		
		System.out.println();
		temp = a.setNumber("9+4+5-4*223131+761-456103");
		
		for(int i = 0; i< temp.length; i++)
		{
			System.out.println(temp[i]);
		}
	}

}
