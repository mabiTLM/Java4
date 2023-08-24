package HomeworkPersona;

public class Jackfrost extends PersonaBase{

	public Jackfrost() 
	{
		super(
				"잭 프로스트",
				"잉글랜드에 전해지는 겨울과 서리의 요정. 추운 날에 외출하는 자를 얼려 코끝을 빨갛게 만든다. 기뻐 뛰노는 것을 좋아하며, 만지는 것에 서릿발을 남긴다고 한다. 사악하진 않으나 화나게 만들면 얼음 투성이가 된다고 한다.",
				11,
				8,
				9,
				7,
				9,
				7,
				0,
				new int[]{3,5,3,2,2},
				"마법사",
				new String[]{"불"},
				new String[]{"얼음무효"},
				new String[]{"프로스트 두건 (방어구 / 모르가나 전용)"},
				"나는 잭 프로스트다호!\r\n"+"가면이 되더라도 앞으로 잘 부탁한...다호!",
				new String[]{},
				new String[]{"부흐","빙결 가드킬","바이스디","","","","",""},
				new String[]{"부흐","빙결 가드킬","바이스디","마하부흐","라쿤다","동결 확률 UP"},
				new String[]
						{
						"이름,		습득레벨,	소비,		설명",
						"부흐			1 		SP 4 	적 하나에게 빙결 속성 소 대미지",
						"빙결가드킬 	1 		SP 15 	적 전체의 빙결 내성을 제거한다. 방빙의 벽은 깰 수 없다",
						"바이스디 		3 		SP 4 	아군 하나의 화상, 동결, 감전 상태를 치유",
						"마하부흐 		5 		SP 8 	적 전체에게 빙결 속성 소 대미지",
						"라쿤다 		6 		0 		3턴간 적 하나의 방어력 저하",
						"동결 확률 UP 6 		0 		동결 상태이상의 부착률이 상승한다"
						},
				new int[]{1,1,1,12,13,15},
				new PersonaSkillInfo[]
						{
						new PersonaSkillInfo("부흐",4,"enemy",1,"얼음"),
						new PersonaSkillInfo("빙결 가드킬",15,"enemy",4,"내성변화"),
						new PersonaSkillInfo("바이스디",4,"ally",1,"상태이상"),
						new PersonaSkillInfo("마하부흐",10,"enemy",4,"얼음"),
						new PersonaSkillInfo("동결 확률 UP",15,"passive",1,"패시브")
						}
				);
		}

}
