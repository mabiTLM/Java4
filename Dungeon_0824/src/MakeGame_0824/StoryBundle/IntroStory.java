package MakeGame_0824.StoryBundle;

import java.util.Scanner;

public class IntroStory extends StoryText
{
	private String intro =
			"최근 지각변동에 의해 주변에 던전으로 통하는 입구가 나타났다.\n"
			+ "";
	private boolean watchAgain=true;
	Scanner scan = new Scanner(System.in);
	public void introText()
	{
		while(watchAgain) 
		{
			System.out.println("인트로 스토리를 스킵할까요? Y or 아무키");
			String temp = scan.nextLine();
			if(temp.equals("Y")|temp.equals("y"))
			{
				setWatchAgain(false);
				break;
			}
			System.out.println(getIntro());
			System.out.println("계속하려면 엔터키를 눌러주세요.");
			scan.nextLine();
			setWatchAgain(false);
		}
	}
	
	public void setWatchAgain(boolean watchAgain)
	{
		this.watchAgain=watchAgain;
	}
	
	public String getIntro()
	{
		return intro;
	}
}
