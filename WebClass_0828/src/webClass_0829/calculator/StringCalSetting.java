package webClass_0829.calculator;

public interface StringCalSetting 
{
	default String[] setNumber(String input)
	{
		String[] temp = {"0"};
		String[] tempNoBlank = {};
		
		if(input.replaceAll("[0-9\\+./\\*()\\-]","").isEmpty())//숫자랑 기호만 받고
		{
			
//			for(int i = 0; i < input.length(); i++) //리플레이스를 하나로
//			{
//				input.toCharArray();
//			}
			
//			숫자일경우 앞 배열에 추가 문자일경우
//			다음배열로 - 제외
//
//			-(4*3) 이럴때 오류
//			괄호인 경우는 무시해야한다.
			
			input=input.replaceAll(" ",""); //공백제거
			input=input.replaceAll("+"," + ");
			input=input.replaceAll("-"," - ");
			input=" "+input;//음수시작일수 있으니까
			input=input.replaceAll("  - "," -");//음수화
			input=input.replaceAll("*"," * ");
			input=input.replaceAll("/"," / ");
			temp = input.split(" ");
			tempNoBlank = new String[temp.length-1];
			for(int i = 1; i<temp.length; i++)
			{
				tempNoBlank[i-1]=temp[i];
			}
		}
		return tempNoBlank;
	}
}
