package MakeGame_0824;

import java.util.Scanner;

import MakeGame_0824.CharacterBundle.EnemyCharacter;
import MakeGame_0824.CharacterBundle.MainPlayerCharacter;

public class Battle 
{
	int atk;
	int def;
	
	void battleChoice()
	{
			System.out.println("1.싸운다");
			System.out.println("2.아이템");
			System.out.println("3.방어");
			System.out.println("4.도망친다");
			Scanner scan= new Scanner(System.in);
	}
	
	void battleCalculator() 
	{
		//임시 변수명 코드 확정될때 수정할 것
		MainPlayerCharacter m = new MainPlayerCharacter(); //캐릭터 자료불러오고
		m.equip(); //장비장착
		OwnedItem[] o= m.getOwnedItem(); //장비 장착한걸 클래스화
		
		EnemyCharacter e = new EnemyCharacter();
		EnemyCharacter[] eArray = e.firstEnemyDatabase();
		while(true) 
		{
			System.out.println("장작한 아이템" + o[0].getItemName());
			
			System.out.println("적hp"+eArray[0].getHp());
			
			if(eArray[0].getHp()<=0)
			{
				System.out.println("이겼다!");
				break;
			}
			
			System.out.println("공격 " + o[0].getWeaponAtk());
			
			eArray[0].setHp(eArray[0].getHp()-o[0].getWeaponAtk());
		}
	}
	
	
}
