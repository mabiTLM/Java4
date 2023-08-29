package webClass_0829.calculator;

public interface StringCalcInterface extends ForStringCalSetting,StringMultiply,StringDivide //,StringCalSetting
{
//	public default String[] setNumber(String input)
//	{
//		String[] temp = {};
//		temp = StringCalSetting.super.setNumber(input);
//		return temp;
//	}
	
	public default String[] setNumber(String input)
	{
		String[] temp = {};
		temp = ForStringCalSetting.super.setNumber(input);
		return temp;
	}
	
	public default String[] muliple(String[] input)
	{
		String[] temp = {};
		temp = StringMultiply.super.multiple(input);
		return temp;
	}
	public default String[] divide(String[] input)
	{
		String[] temp = {};
		temp = StringMultiply.super.multiple(input);
		return temp;
	}
}
