package MakeGame_0824.StoryBundle;

import java.util.Scanner;

import MakeGame_0824.CharacterBundle.MainPlayerCharacter;

public class Tutorial extends StoryText
{
	
	public Tutorial(MainPlayerCharacter mainChar) {
		super(mainChar);
		// TODO Auto-generated constructor stub
	}

	private String start =
			"목적\n"
			+ "던전을 돌아서 돈을 벌어서 치료제를 사자!\n"
			+ "게임오버 조건\n"
			+ "1. hp나 sp가 0이 된다.\n"
			+ "2. 시간이 너무 오래 지체된다.\n"
			+ "3. 그외에 이벤트들\n"
			+ "마을에서의 이동\n"
			+ "마을 이동은 숫자로 선택 할 수 있으며 글자로도 선택 할 수 있습니다.\n"
			+ "ex) 집에 있을 때 2번을 눌러서 마을 광장으로 이동 할 수 있고 던전입구를 입력해서 던전입구로 이동 할 수도 있습니다.\n"
			+ "던전에서의 이동\n"
			+ "던전에서는 8,2,4,6으로만 이동 가능합니다.\n"
			+ "본인 위치를 포함한 8칸만이 보이며 벽으로는 이동 할 수 없습니다.\n"
			+ "이동하다보면 랜덤으로 적이나오거나 이벤트가 발생합니다.\n"
			+ "전투에 관하여\n"
			+ "전투 선택지 역시 1,2,3,4,5의 숫자만 입력받습니다.\n"
			+ "1. 싸운다 : 무기 공격력을 기반으로 적에게 데미지를 입힙니다.\n"
			+ "2. 스킬 : 현재 알고 있는 스킬들이 표시 됩니다.\n"
			+ "스킬의 발동은 해당하는 스킬의 이름을 정확히 입력하여야 발동합니다.\n"
			+ "주의 : 이름이 틀릴 경우 행동이 넘어가며 취소 할 수 없습니다.\n"
			+ "3.아이템 : 장비를 변경하거나 포션을 사용 할 수 있습니다. 행동을 소비하지 않습니다.\n"
			+ "4.스테이터스 : 현재 상태를 자세히 확인합니다.\n"
			+ "5.도망친다 : 전투에서 벗어납니다\n";
	private boolean watchAgain=true;
	Scanner scan = new Scanner(System.in);
	public void tutorialText()
	{
		while(watchAgain) 
		{
			System.out.println("튜토리얼을 스킵할까요? Y or 아무키");
			String temp = scan.nextLine();
			if(temp.equals("Y")|temp.equals("y"))
			{
				setWatchAgain(false);
				break;
			}
			System.out.println(getStart());
			System.out.println("계속하려면 엔터키를 눌러주세요.");
			scan.nextLine();
			setWatchAgain(false);
		}
	}
	
	public void setWatchAgain(boolean watchAgain)
	{
		this.watchAgain=watchAgain;
	}
	
	public String getStart()
	{
		return start;
	}
}
