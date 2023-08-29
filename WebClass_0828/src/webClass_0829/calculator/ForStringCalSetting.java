package webClass_0829.calculator;

public interface ForStringCalSetting 
{
	default String[] setNumber(String input)
	{
		String[] temp = new String[input.length()];
		int tempArrNum = 0;
		
		char[] inputChar = input.toCharArray();
		if(input.replaceAll("[0-9\\+./\\*()\\-]","").isEmpty())//숫자랑 기호만 받고
		{			
			for(int i = 0; i < input.length(); i++) //리플레이스를 하나로
			{
				if(inputChar[i]=='+'||inputChar[i]=='-'||inputChar[i]=='*'||inputChar[i]=='/')
				{
					if(inputChar[i]=='-'&&inputChar[i+1]=='-')//맨마지막이 기호면 어차피 오류 나중에 예외처리
					{
						
					}
				}
				else
				{
					inputChar[]
				}
				
			}
			
//			숫자일경우 앞 배열에 추가 문자일경우
//			다음배열로 - 제외
//
//			-(4*3) 이럴때 오류
//			괄호인 경우는 무시해야한다.
		}
		
		return temp;
	}
	
}
