package webClass_0829.calculator;

public interface ForStringCalSetting 
{
	default String[] setNumber(String input)
	{
		String[] temp = new String[input.length()];
		int tempArrNum = 0;
		char[] inputChar = input.toCharArray();
		
		
		for(int i = 0; i <temp.length; i++)
		{
			temp[i]="";
		}
		
		temp[0] = ""+inputChar[0];
		
			for(int i = 1; i < input.length(); i++) //리플레이스를 하나로
			{
				if(temp[0].equals("-"))
				{
					tempArrNum--;
				}
				if(inputChar[i]=='+'||inputChar[i]=='-'||inputChar[i]=='*'||inputChar[i]=='/')
				{
					tempArrNum++;
				}
				else if((inputChar[i-1]=='+'||inputChar[i-1]=='-'||inputChar[i-1]=='*'||inputChar[i-1]=='/'))
				{tempArrNum++;}//푸시 오류 확인					
				
				if(i>=2) {
					if(inputChar[i-1]=='-'&&(inputChar[i-2]=='+'||inputChar[i-2]=='-'||inputChar[i-2]=='*'||inputChar[i-2]=='/'))
					{
						tempArrNum--;
						}
					}				
				temp[tempArrNum] = temp[tempArrNum]+inputChar[i];
				}
			return temp;
	}	
}			
//숫자일경우 앞 배열에 추가 문자일경우
//다음배열로 - 제외
//
//-(4*3) 이럴때 오류
//괄호인 경우는 무시해야한다.
