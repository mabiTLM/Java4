package webClass_0829.calculator.study;

public interface CalcInterface extends AddInterface, MinusInterface, MultiplyInterface, DivideInterface, remainInterface
{
	public default int add(int ...nums) //...은 몇개 받을지 모르고 한번에 처리한다. 
	{
		int temp = 0;
		for(int num : nums)
		{
			temp = AddInterface.super.add(temp,num);
		}
		return temp;
	}
	
	public default int minus(int ...nums) //...은 몇개 받을지 모르고 한번에 처리한다. 
	{
		int temp = nums[0];
		for(int i = 1; i <nums.length; i++)
		{
			temp = MinusInterface.super.minus(temp,nums[i]);
		}
		return temp;
	}
	
	public default int multiply(int ...nums) //...은 몇개 받을지 모르고 한번에 처리한다. 
	{
		int temp = nums[0];
		for(int i = 1; i <nums.length; i++)
		{
			temp = MultiplyInterface.super.multiply(temp,nums[i]);
		}
		return temp;
	}
	
	public default double divide(int ...nums) //...은 몇개 받을지 모르고 한번에 처리한다. 
	{
		double temp = nums[0];
		for(int i = 1; i <nums.length; i++)
		{
			temp = DivideInterface.super.divide(temp,nums[i]);
		}
		return temp;
	}
}
