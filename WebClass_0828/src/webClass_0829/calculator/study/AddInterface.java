package webClass_0829.calculator.study;

public interface AddInterface 
{
	default int add(int num1, int num2)
	{
		return num1+num2;
	}
}