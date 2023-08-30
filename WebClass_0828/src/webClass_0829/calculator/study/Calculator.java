package webClass_0829.calculator.study;

public class Calculator implements CalcInterface
{
	public double calculate(char operator, int ...nums)
	{
		switch(operator)
		{
		case '+':
			return CalcInterface.super.add(nums);
		case '-':
			return CalcInterface.super.minus(nums);
		case '*':
			return CalcInterface.super.multiply(nums);
		case '/':
			return CalcInterface.super.divide(nums);
			
		default:
			return 0;
		}
	}
	
}
