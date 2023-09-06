package webClass230906;

public class App {
	public static void main(String[] args)
	{
		Player player = new Player("임",100,20);
		Monster monster = new Monster("적",80,15);
		
		boolean isGame= true;
		
		System.out.println("싸워라");
		System.out.println(player.getName());
		
		while(isGame)
		{
			STATE playerSelect = player.selectAction();
			switch(playerSelect)
			{
			case ATTACK:
				//플레이어
				System.out.println(player.getName()+"가 "+monster.getName()+"에게 " +player.attack() + "만큼 데미지를 입힘");
				monster.takeDamage(player.attack());
				
				
				if(!monster.isAlive())//사망처리 하다말았다
				{
					System.out.println();
				}
				
				//몬스터
				System.out.println(monster.getName()+"가 "+player.getName()+"에게 " +monster.attack() + "만큼 데미지를 입힘");
				player.takeDamage(monster.attack());
				
				if(!player.isAlive())
				{
					System.out.println();
				}
				
				break;
			case USE_ITEM:
				player.useItem();
				break;
			case RUN:
				
			}
		}
	}
}
