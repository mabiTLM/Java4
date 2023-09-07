package makeCardGame230901.mapBundle;

import java.util.Scanner;

import makeCardGame230901.battleBundle.BattleCombine;
import makeCardGame230901.battleBundle.MONSTERTYPE;
import makeCardGame230901.characterBundle.PlayerCharacter;
import makeCardGame230901.village.MoveInVillage;

public class StageBase 
{
	EventInDungeon eventInDungeon;
	BattleCombine battleCombine;
	MoveInVillage moveInvillage;
	PlayerCharacter player;
	Scanner scan = new Scanner(System.in);
	StageBase(BattleCombine battleCombine,	MoveInVillage moveInvillage,PlayerCharacter player)
	{
		this.battleCombine=battleCombine;
		this.moveInvillage=moveInvillage;
		this.player=player;
		this.eventInDungeon= new EventInDungeon(player);
	}
	
	private int height=14;
	private int width=3;
	protected int firstMap[][] = new int[15][7];
	
	public void movePlayer()
	{		
		while(true)
		{
			try
			{
				System.out.println("어디로 이동할까요? 1,2,3");
				
				int choice = scan.nextInt();
				scan.nextLine();
				if(canMove(choice))
				{
					if(choice==1)
					{
						height--;
						width--;
					}
					else if(choice==2)
					{
						height--;
					}
					else if(choice==3)
					{
						height--;
						width++;
					}
					symbolEncount();
				}
				else
				{
					System.out.println("맵밖으론 못나가");
				}
				break;
				}
			catch(Exception e)
			{
				scan.nextLine();
			}
		}
	}
	
	public void symbolEncount()
	{
		MONSTERTYPE mT;
		if(height<0)
		{
			System.out.println("보스출현!");
			battleCombine.getBattle().setMonsterType(MONSTERTYPE.BOSS);
			battleCombine.battleCombine(moveInvillage);
		}
		else if(firstMap[height][width]==1)//엘리트
		{
			battleCombine.getBattle().setMonsterType(MONSTERTYPE.ELITE);
			battleCombine.battleCombine(moveInvillage);
		}
		else if(firstMap[height][width]==2)//일반
		{
			battleCombine.getBattle().setMonsterType(MONSTERTYPE.NORMAL);
			battleCombine.battleCombine(moveInvillage);
		}
		else if(firstMap[height][width]==3)//이벤
		{
			eventInDungeon.event();
		}
		else if(firstMap[height][width]==4)//불
		{
			eventInDungeon.campfire();
		}
		else if(firstMap[height][width]==5)//상점
		{

		}
	}
	
	public boolean canMove(int choice)
	{
		boolean temp = false;
		if(width-1>=0&&choice==1) 
		{
			temp=true;
		}
		else if(width+1<=6&&choice==3) 
		{
			temp=true;
		}
		else if(choice==2) 
		{
			temp=true;
		}
		return temp;
	}
	
	
	public void watchMap()
	{
		for(int i = 0; i<=height; i++)
		{
			for(int j = 0; j<7; j++)
			{
				String mapPrintTemp="";
				if(i==height&&j==width)
				{
					mapPrintTemp="*나*";
				}				
				else if(firstMap[i][j]==1)
				{
					mapPrintTemp="엘리트";
				}
				else if(firstMap[i][j]==2)
				{
					mapPrintTemp="일반몹";
				}
				else if(firstMap[i][j]==3)
				{
					mapPrintTemp="이벤트";
				}
				else if(firstMap[i][j]==4)
				{
					mapPrintTemp="모닥불";
				}
				else if(firstMap[i][j]==5)
				{
					mapPrintTemp="상_점";
				}
				System.out.print(mapPrintTemp + " ");
			}
			System.out.println();
			System.out.println();
		}
	}
	
	
	//set모음
	
	public void setHeight(int height)
	{
		this.height=height;
	}
	public void setWidth(int width)
	{
		this.width=width;
	}
	
	//get모음
	public int getHeight()
	{
		return height;
	}
	public int getWidth()
	{
		return width;
	}
}
