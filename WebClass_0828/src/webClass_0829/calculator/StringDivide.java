package webClass_0829.calculator;

public interface StringDivide 
{
	default String[] divide(String[] input)
	{
		String[] temp = {};
		
		temp = input;
		
		int divideCount = 0;
		int tempCount=0;
		
		for(int i = 0; i < temp.length; i++)
		{
			if(temp[i].equals("/"))
			{
				temp[i] = ""+(Double.valueOf(temp[i-1])/Double.valueOf(temp[i+1]));
				temp[i-1] = "";
				temp[i+1] = "";
				divideCount=divideCount+2;
			}
		}
		
		String[] result = new String[temp.length-divideCount];
		
		for(int i = 0; i<result.length; i++)//공백제거
		{
			if(temp[i+tempCount].equals(""))
			{
				tempCount++;
			}
			result[i]=temp[i+tempCount];
		}
		
		return result;
	}
}
