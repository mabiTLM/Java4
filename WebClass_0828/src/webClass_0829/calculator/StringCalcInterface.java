package webClass_0829.calculator;

public class StringCalcInterface implements ForStringCalSetting //,StringCalSetting
{
//	public default String[] setNumber(String input)
//	{
//		String[] temp = {};
//		temp = StringCalSetting.super.setNumber(input);
//		return temp;
//	}
	
	public String[] setNumber(String input)
	{
		String[] temp = {};
		temp = ForStringCalSetting.super.setNumber(input);
		return temp;
	}
}
