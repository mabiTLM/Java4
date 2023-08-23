package HomeworkPersona;



class Player//플레이어 캐릭터
{
	String name;
	int level = 1;
	int exp = 0;
	int knowledge=1;//지식
	int trick=1;//재주
	int gentleness=1;//상냥함
	int guts=1;//배짱
	int charm=1;//매력
	String currentPersona = "아르센";
	String PossessedPersona[];//소지 페르소나
	String itemBox; //아이템 클래스를 따로만들고 불러오는 방식
}



class TotalPersonaBook//페르소나 전서
{
	String personaName[] ={"아르센","픽시"} ;
	String personaArcana[] ={"광대","연인"} ;
	int personaDefaultLevel[] = {1,2};
	boolean confirmedpersona[] = {true,false};//페르소나 확인여부
	
	void personaBookList()
	{
		for(int i = 0; i<personaName.length; i++) 
		{
			if(confirmedpersona[i])
			System.out.println(personaName[i] + "	" + personaArcana[i] + "	" + personaDefaultLevel[i]);
		}
	}
	
}



class Arsene//공통부분으로 상위클래스를 만들어서 오버라이드 할 수 있을 것 같습니다.
{
	PersonaSkillInfo PersonaSkillInfo = new PersonaSkillInfo();
	final String name = "아르센";
	final String personaBookInfo = "전서 설명 : 프랑스의 소설가 모리스 르블랑이 발표한 소설 '아르센 뤼팽' 시리즈의 주인공에서 유래된 존재."
	+ " 신출귀몰한 변장의 달인. 선량한 시민들을 돕는 의적이라는 면도 겸비했다.";
	int level = 1;
	int str = 2;
	int magic = 2;
	int def = 2;
	int speed = 3;
	int luck = 1;
	int exp = 0;
	public int[] upstatus = {2,2,1,4,1};
	
	void levelup()//레벨당 자료가 없어서 임의 수치
	{
		level = level+1;
		str = str+2;
		magic = magic +2;
		def = def+1;
		speed = speed +4;
		luck = luck+1;
	}
	
	final String arcana = "광대";//아르카나는 변화하지 않는다.
	String[] weak = {"얼음", "빛"};//공격받을 때 공격속성이 일치하는게 있으면
	String[] resist = {"어둠"}; ////공격할 때 공격속성이 일치하는게 있으면
	String[] changeItem = {"괴도신사 스틱","대 괴도 스틱"};//통상인지 경보인지는 아이템화 시키는 곳에서
	final String summonSpeech = "내 이름은 황혼의 약탈자 아르센! 다시금 나의 힘이 필요한가...? 좋다. 마음껏 휘둘러 보거라.";//생성할 때 호출
	String[] specificity = {"배수의 닻","배턴 터치를 받았을 때, 포위당했을 때의 전용 스킬을 사용할 수 있다","계승 가능"};//효과를 불러올때는 0번으로 계승여부확인은 2번으로
	String[] nowSkill = {"에이하","","","","","","",""};//페르소나가 소지할 수 있는 스킬 8개
	String[] canLearnSkillname = {"에이하","슬래시","스쿤다","몽견침","역경의 각오"};
	String[] learnSkillInfo = {//이름과 뒷부분 분리후 배울 수 있는 스킬과 대조해서 불러오자
			"이름, 습득레벨, 소비, 설명\n",
			"에이하"," 1 SP 4 적 하나에게 주원 속성 소 대미지\n",
			"슬래시"," 2 HP 6.0% 적 하나에게 물리 속성 소 대미지\n",
			"스쿤다"," 4 SP 8 3턴간 적 하나의 명중율, 회피율 저하\n",
			"몽견침"," 5 HP 8.0% 적 하나에게 물리 속성 중 대미지. 중간 확률로 수면\n",
			"역경의 각오"," 7 - 포위되었을 때 크리티컬 확률이 상승\n"};
	int[] canLearnSkillLevel = {1,2,4,5,7};
	void printLearnSkill()//합치는 부분에 넣을 수 있을 것 같은 부분
	{
		for(int i = 0; i < learnSkillInfo.length; i++)
		{
			System.out.print(learnSkillInfo[i]);
		}
		
	}
	
	void learn()//스킬 이름을 가져온후 습득레벨과 비교한다 , 레벨업 했을 때 한번 수행
	{
		int temp = 1;
		for(int i = 0; i <PersonaSkillInfo.skillname.length; i++)// 전체 스킬 목록에서
		{
			for(int j = 0; j <canLearnSkillname.length; j++)//배울 수 있는 스킬이 있는가?
				{
				if(PersonaSkillInfo.skillname[i].equals(canLearnSkillname[j]))
				{
					if(this.level==canLearnSkillLevel[j])//레벨이 같으면
						{
						if(nowSkill[temp].isEmpty())//빈공간이있으면 추가
							{
							nowSkill[temp] = PersonaSkillInfo.skillname[i];
							break;
							}
						else
						{
							temp++;
							j--;
							if(temp>=7)
							{
								break;
							}
						}
					}
					if(temp>=7)
					{
						break;
					}
				}
			}
		}
	}
	
}



class Pixie{
	PersonaSkillInfo PersonaSkillInfo = new PersonaSkillInfo();
	final String name = "픽시";
	final String personaBookInfo = "잉글랜드에 전해지는 자그마한 숲의 요정. 사람의 눈을 피해 살지만 우호적이고, "
	+ "은혜를 베풀면 보답한다고 한다. 게으른 자에게는 벌을 내리는 등 도덕적인 면도 있다."
			+ " 원래는 세례를 받지 않고 죽은 아이의 영혼이라고도 한다.";
	int level = 2;
	int str = 1;
	int magic = 3;
	int def = 3;
	int speed = 4;
	int luck = 2;
	int exp = 0;
	public int[] upstatus = new int[]{1,2,2,3,2};
	void levelup()//레벨당 자료가 없어서 임의 수치
	{
		level = level+1;
		str = str+1;
		magic = magic+2;
		def = def+2;
		speed = speed+3;
		luck = luck+2;
	}

	
	final String arcana = "연인";//아르카나는 변화하지 않는다.
	String[] weak = new String[]{"총격", "얼음","어둠"};//공격받을 때 공격속성이 일치하는게 있으면
	String[] resist = new String[]{"전기","빛"}; ////공격할 때 공격속성이 일치하는게 있으면
	String[] changeItem = new String[]{"지오(스킬 카드)","마하지오(스킬 카드)"};//통상인지 경보인지는 아이템화 시키는 곳에서
	final String summonSpeech = "난 픽시야! 네 가면이 되어서 같이 소란피울 거야!";
	String[] specificity = new String[]{"추가 전도체","다운된 적에 대한 감전율이 상승한다","계승 가능"};//효과를 불러올때는 0번으로 계승여부확인은 2번으로
	String[] nowSkill = new String[]{"지오","디아","","","","","",""};//페르소나가 소지할 수 있는 스킬 8개
	String[] canLearnSkillname = new String[]{"지오","디아","파트라","타루카쟈","혼란 내성"};
	String[] learnSkill = new String[]{
			"이름, 습득레벨, 소비, 설명",
			"지오 1 SP 4 적 하나에게 전격 속성 소 대미지",
			"디아 1 SP 3 아군 하나의 HP 소 회복",
			"파트라 3 SP 4 3턴간 적 하나의 명중율, 회피율 저하,",
			"타루카쟈 5 SP 8 적 하나에게 물리 속성 중 대미지. 중간 확률로 수면,",
			"혼란 내성 6 - 포위되었을 때 크리티컬 확률이 상승"};
	int[] canLearnSkillLevel = new int[]{1,1,3,5,6};
	
	void learn()//스킬 이름을 가져온후 습득레벨과 비교한다 , 레벨업 했을 때 한번 수행
	{
		int temp = 1;
		for(int i = 0; i <PersonaSkillInfo.skillname.length; i++)//전체 스킬 목록에서
		{
			for(int j = 0; j <canLearnSkillname.length; j++)//배울 수 있는 스킬이 있는가?
			{
				if(PersonaSkillInfo.skillname[i].equals(canLearnSkillname[j]))
				{
					if(this.level==canLearnSkillLevel[i])//레벨이 같으면
					{
						if(nowSkill[temp].isEmpty())//빈공간이있으면 추가
						{
							nowSkill[temp] = PersonaSkillInfo.skillname[i];
							break;
						}
						else
						{
							temp++;
							j--;
							if(temp>=7)
							{
								break;
							}
						}
					}
					if(temp>=7)
					{
						break;
					}
				}
			}
		}
	}
}



class PersonaSkillInfo //클래스 자체를 배열화시키자
{
	enum Persona {에이하,슬래시,스쿤다,몽견침,역경의_각오,지오,디아,파트라,타루카쟈,혼란_내성};//스킬이 몇번이지 까먹지 않기위해서
	String skillname[] = {"에이하","슬래시","스쿤다","몽견침","역경의 각오","지오","디아","파트라","타루카쟈","혼란 내성"};
	int useMp[] = {4,0,8,0,0,4,3,4,8,0};
	int useHp[] = {0,6,0,8,0,0,0,0,0,0};
	String target[] = {"enemy","enemy","enemy","enemy","passive","enemy","ally","enemy","enemy","passive"};
	int targetNumber[] = {1,1,1,1,1,1,1,1,1,1};
	String type[] = {"어둠","물리","변화","물리","물리","패시브","전기","회복","변화","변화","패시브"};
}



class MixPersona //합성
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



public class Persona5_0821
{
	public static void main(String[] args)
	{
		//실행 확인용 코드들
		// Arsene a = new Arsene();
		// a.printLearnSkill();
		
		//MixPersona m = new MixPersona();
		//m.fusionTable();
		//m.getfusionTable();
	}

}//확인용