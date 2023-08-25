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
		MainPlayerCharacter m = new MainPlayerCharacter();
		m.getOwnedItem();
		EnemyCharacter e = new EnemyCharacter();
		e.getEnemyCharacter();
		
	}
	
	
}
