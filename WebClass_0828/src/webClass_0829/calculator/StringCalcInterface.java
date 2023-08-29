package webClass_0829.calculator;

public interface StringCalcInterface extends StringCalSetting
{
	public default String[] setNumber(String input)
	{
		String[] temp = {};
		temp = StringCalSetting.super.setNumber(input);
		return temp;
	}
}
