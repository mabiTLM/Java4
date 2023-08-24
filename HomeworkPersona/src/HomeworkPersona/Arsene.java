package HomeworkPersona;

public class Arsene extends PersonaBase {

	public Arsene() {
		super(
		"아르센",
		"전서 설명 : 프랑스의 소설가 모리스 르블랑이 발표한 소설 '아르센 뤼팽' 시리즈의 주인공에서 유래된 존재."
		+ " 신출귀몰한 변장의 달인. 선량한 시민들을 돕는 의적이라는 면도 겸비했다.",
		1,
		2,
		2,
		2,
		3,
		1,
		0,
		new int[]{2,2,1,4,1},
		"광대",
		new String[]{"얼음","빛"},
		new String[]{"어둠"},
		new String[]{"괴도신사 스틱","대 괴도 스틱"},
		"내 이름은 황혼의 약탈자 아르센! 다시금 나의 힘이 필요한가...? 좋다. 마음껏 휘둘러 보거라.",
		new String[]{"배수의 닻","배턴 터치를 받았을 때, 포위당했을 때의 전용 스킬을 사용할 수 있다","계승 가능"},
		new String[]{"에이하","","","","","","",""},
		new String[]{"에이하","슬래시","스쿤다","몽견침","역경의 각오"},
		new String[]{
				"이름,		습득레벨, 소비,		설명",
				"에이하		1 		SP 4	적 하나에게 주원 속성 소 대미지",
				"슬래시		2 		HP 6.0% 적 하나에게 물리 속성 소 대미지",
				"스쿤다		4 		SP 8 	3턴간 적 하나의 명중율, 회피율 저하",
				"몽견침 		5 		HP 8.0% 적 하나에게 물리 속성 중 대미지. 중간 확률로 수면",
				"역경의 각오 	7 		0 		포위되었을 때 크리티컬 확률이 상승\n"},
		new int[]{1,2,4,5,7},
		new PersonaSkillInfo[]
				{
						new PersonaSkillInfo("에이하",4,"enemy",1,"어둠"),
						new PersonaSkillInfo("슬래시",6.0,"enemy",1,"물리"),
						new PersonaSkillInfo("스쿤다",8,"enemy",1,"스탯변화"),
						new PersonaSkillInfo("몽견침",8.0,"enemy",1,"물리"),
						new PersonaSkillInfo("역경의 각오",0,"passive",1,"패시브")
				});
		}

}
