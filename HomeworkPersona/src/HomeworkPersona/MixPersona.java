package HomeworkPersona;

public class MixPersona //합성
{
	TotalPersonaBook totalPersonaBook = new TotalPersonaBook();//합성시 결과물의 조건을 위해 필요
	Player player = new Player();//합성시 페르소나 갱신을 위해 필요
	String[] personnaArcana = {"광대","마법사","여법황","여황제","황제","법황","연인","전차","정의","은둔자","운명","힘","사형수","사신","절제","악마","탑","별","달","태양","심판","세계"};
	String[] fusionResultTable = 
		{
			"광대","사신","달","사형수","절제","은둔자","전차","달","별","여법황","연인","사신","탑","힘","법황","절제","여황제","마법사","정의","정의","태양",
			"마법사","절제","정의","사형수","사신","악마","여법황","황제","연인","정의","광대","여황제","은둔자","전차","법황","절제","여법황","연인","법황","힘",
			"여법황","황제","여황제","마법사","운명","법황","사신","절제","마법사","악마","사신","마법사","악마","달","사형수","은둔자","법황","전차","정의",
			"여황제","정의","광대","심판","별","연인","힘","은둔자","전차","여법황","광대","여법황","태양","황제","연인","운명","탑","황제",
			"황제","운명","광대","힘","전차","법황","태양","탑","악마","은둔자","악마","정의","별","연인","탑","심판","여법황",
			"법황","힘","별","사형수","운명","정의","광대","태양","전차","사신","사형수","심판","탑","여법황","연인","여황제",
			"연인","절제","심판","전차","힘","사신","태양","절제","힘","달","여황제","전차","마법사","여황제","사형수,",
			"전차","달","악마","여법황","은둔자","광대","악마","힘","절제","운명","달","연인","여법황","합체불가",
			"정의","마법사","황제","법황","연인","광대","황제","광대","태양","여황제","악마","사형수","합체불가",
			"은둔자","별","법황","별","힘","힘","여법황","심판","힘","여법황","악마","황제",
			"운명","절제","황제","별","여황제","법황","사형수","악마","태양","별","탑",
			"힘","절제","법황","전차","사신","전차","달","마법사","달","운명",
			"사형수","달","사신","운명","은둔자","정의","힘","법황","별",
			"사신","사형수","전차","태양","악마","법황","여법황","합체불가",
			"절제","광대","운명","태양","운명","마법사","은둔자",
			"악마","마법사","힘","전차","은둔자","연인,",
			"탑","사신","은둔자","황제","달",
			"별","절제","심판","운명",
			"달","여황제","광대",
			"태양","사신",
			"심판"
		};
	String[] fusion = new String[(personnaArcana.length-1)*personnaArcana.length/2+personnaArcana.length];
	String resultArcana;
	int resultLevel;
	String mixPersonaResult;
	Arsene a = new Arsene();//정확히는 선택한 페르소나칸에서 호출 해야한다
	Pixie p = new Pixie();
	
	void fusionTable()
	{
		int temp = 0;
		for(int i = 0; i<personnaArcana.length; i++)
		{
			for(int j = 0; j<personnaArcana.length; j++) 
			{
				if(i>j)
				{
					temp--;
					continue;					
					}
				fusion[i+j+temp] = personnaArcana[i]+personnaArcana[j];
			}
			temp = temp +personnaArcana.length-1;
		}
	}
	
	void getfusionTable()
	{
		int temp = 22;
		int temp2 =22;
		for(int i = 0; i<fusion.length; i++)
		{
			System.out.print(fusion[i]);
			if((i+1)%(temp)==0)
			{
				System.out.println();
				temp = temp+temp2-1;;
				temp2--;
			}
		}
	}
	
	void mix()
	{
		resultArcana = a.arcana +p.arcana;//선택한 페르소나의 아르카나 합성
		String resultArcanaReverse = p.arcana +a.arcana;//역순도 찾기
		for(int i = 0; i <fusion.length; i++)//조건이 뭘까? 수동? 규칙? 일단 표자체를 코딩
			{
				if(fusion[i].equals(resultArcana)|fusion[i].equals(resultArcanaReverse))
				{
					mixPersonaResult=resultArcana;
					break;
				}
				else if(i==fusion.length-1)//합성불가능
				{
					mixPersonaResult="합성 룰가능";
					break;
				}
			}
		resultLevel=a.level/p.level+1;//소지페르소나 = 전체페르소나(mixPersonaResult아르카나,resultLevel레벨) 모양으로 일치하는걸 찾아야한다
		}
	}