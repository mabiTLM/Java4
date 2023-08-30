package webClass_0829.calculator;

public interface StringMultiply 
{
	default String[] multiple(String[] input)
	{
		String[] temp = {};
		String[] result = {};
		temp = input;
		
		int multiCount = 0;
		int tempCount=0;
		
		for(int i = 0; i < temp.length; i++)
		{
			if(temp[i].equals("*"))//앞에서부터 흝으니까 값을 뒤로 앞에두개를 공백으로
			{
				temp[i+1] = ""+(Double.valueOf(temp[i+1])*Double.valueOf(temp[i-1]));
				temp[i-1] = "";
				temp[i] = "";
				multiCount=multiCount+2;
			}
		}
		
		result = new String[temp.length-multiCount];
		
		for(int j = 0; j<result.length; j++)//공백제거
		{
			if(temp[j+tempCount].equals(""))
			{
				tempCount++;
			}
			result[j]=temp[j+tempCount];
		}
		
		return result;
	}
}
