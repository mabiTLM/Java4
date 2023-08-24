package HomeworkPersona;

public class TotalPersonaBook//페르소나 전서
{
	String personaName;// 페르소나 이름
	String personaArcana; //페르소나 아르카나
	int personaDefaultLevel; // 페르소나 저장 레벨
	boolean confirmedpersona;//페르소나 확인여부
	
	TotalPersonaBook(String personaName,String personaArcana,int personaDefaultLevel,boolean confirmedpersona)
	{}	
	
	TotalPersonaBook[] totalPersonaBook =
		{
			new TotalPersonaBook("아르센","광대",1,true),
			new TotalPersonaBook("픽시","연인",2,false),
			new TotalPersonaBook("잭 프로스트","마법사",11,false)
			};
	
	TotalPersonaBook()
	{}
	
	void personaBookList()
	{
		for(int i = 0; i<personaName.length(); i++) 
		{
			if(confirmedpersona) 
			{
			System.out.println(personaName + "	" + personaArcana + "	" + personaDefaultLevel);
			}
		}
	}
	
}