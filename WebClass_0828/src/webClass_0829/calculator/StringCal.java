package webClass_0829.calculator;

public class StringCal implements StringCalcInterface
{
	public String[] calculate(String a)
	{
		String[] arrTemp = {};
		arrTemp = StringCalcInterface.super.setNumber(a);//넣으면 배열로 변환
		arrTemp = StringCalcInterface.super.muliple(arrTemp);
		arrTemp = StringCalcInterface.super.divide(arrTemp);
		
		double temp = 0;
		
		
		return arrTemp;
	}
}
