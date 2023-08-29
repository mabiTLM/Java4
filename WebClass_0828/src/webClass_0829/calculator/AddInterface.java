package webClass_0829.calculator;

public interface AddInterface 
{
	default int add(int num1, int num2)
	{
		return num1+num2;
	}
}