package Maple;
import HomeworkPersona.PersonaBase;
import AmongUs.Crew;

public class Main
{
	public static void main(String[] args) 
	{
		Characters shadower = new Characters(
				"Woman",
				"human",
				new String[][] 
					{
					{"Korean", "man", "이호산"},
					{"Korean", "woman", "이소운"},
					{"Global", "man", "토니 아졸리노"},
					{"Global", "woman", "잰시 원"},
					{"Japanese", "man", "카네모토 료스케"},
					{"Japanese", "woman", "타나카 토모미"}},
				new String[]{"모험가", "도적"},
				new String[] {"단검"},
				new String[] {"단검용 검집", "방패"},
				"Luk",
				new String[] {"DEX", "STR"},
				new String[] {"로그", "시프", "시프마스터", "섀도어", "섀도어"},
				new String[][] 
					{
					{"Global", "Shadower"},
					{"Japan", "シャドー"},
					{"China", "侠盗(협도)"},
					{"Taiwan", "暗影神偷(암영신투)"}	},
					1.3d,
					6,
					0.9,
					"물리",
					0.7d,
					110,
					30,
					0.3d,
					56,
					100,
					true,
					false,
					60,
					0,
					10d,
					false,
					55,
					1.4d,
					1.6d,
					1.2d				
				);
		
		Characters paladin = new Characters(
				"Woman",
				"human",
				new String[][] 
					{
					{"Korean", "man", "이호산"},
					{"Korean", "woman", "이소운"},
					{"Global", "man", "토니 아졸리노"},
					{"Global", "woman", "잰시 원"},
					{"Japanese", "man", "카네모토 료스케"},
					{"Japanese", "woman", "타나카 토모미"}},
				new String[]{"모험가", "도적"},
				new String[] {"두손둔기", "한손둔기", "두손검", "한손검"},
				new String[] {"단검용 검집", "방패"},
				"Luk",
				new String[] {"DEX", "STR"},
				new String[] {"로그", "시프", "시프마스터", "섀도어", "섀도어"},
				new String[][] 
					{
					{"Global", "Shadower"},
					{"Japan", "シャドー"},
					{"China", "侠盗(협도)"},
					{"Taiwan", "暗影神偷(암영신투)"}	},
					1.3d,
					6,
					0.9,
					"물리",
					0.7d,
					110,
					30,
					0.3d,
					56,
					100,
					true,
					false,
					60,
					0,
					10d,
					false,
					55,
					1.4d,
					1.6d,
					1.2d				
				);
		PersonaBase pixie = new PersonaBase(
				"픽시",
				"잉글랜드에 전해지는 자그마한 숲의 요정. 사람의 눈을 피해 살지만 우호적이고, "
				+ "은혜를 베풀면 보답한다고 한다. 게으른 자에게는 벌을 내리는 등 도덕적인 면도 있다."
				+ " 원래는 세례를 받지 않고 죽은 아이의 영혼이라고도 한다.",
				2,
				1,
				3,
				3,d
				4,
				2,
				0,
				new int[]{1,2,2,3,2},
				"연인",
				new String[]{"총격", "얼음","어둠"},
				new String[]{"전기","빛"},
				new String[]{"지오(스킬 카드)","마하지오(스킬 카드)"},
				"난 픽시야! 네 가면이 되어서 같이 소란피울 거야!",
				new String[]{"추가 전도체","다운된 적에 대한 감전율이 상승한다","계승 가능"},
				new String[]{"지오","디아","","","","","",""},
				new String[]{"지오","디아","파트라","타루카쟈","혼란 내성"},
				new String[]{
						"이름, 습득레벨, 소비, 설명",
						"지오 1 SP 4 적 하나에게 전격 속성 소 대미지",
						"디아 1 SP 3 아군 하나의 HP 소 회복",
						"파트라 3 SP 4 3턴간 적 하나의 명중율, 회피율 저하,",
						"타루카쟈 5 SP 8 적 하나에게 물리 속성 중 대미지. 중간 확률로 수면,",
						"혼란 내성 6 - 포위되었을 때 크리티컬 확률이 상승"},
				new int[]{1,1,3,5,6});
		
		System.out.println(shadower.waepon[0]);
		System.out.println(paladin.waepon[0]);
		pixie.getStatus();
		pixie.levelup();
		pixie.getStatus();
		
		Crew crew= new Crew();
		//crew.die = 1;
		Imporster imporster = new Imporster();
		imporster.character.die = 1;
		
	}
}