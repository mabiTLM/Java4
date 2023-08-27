package MakeGame_0824.StoryBundle;

import java.util.Scanner;

import MakeGame_0824.CharacterBundle.MainPlayerCharacter;

public class IntroStory extends StoryText
{
	public IntroStory(MainPlayerCharacter mainChar) {
		super(mainChar);
		// TODO Auto-generated constructor stub
	}

	private String intro =
			"당신은 조그만 마을에 소작농으로 여동생과 함께 살고 있다.\n"
			+ "최근 지각변동에 의해 주변에 던전으로 통하는 입구가 나타났다.\n"
			+ "주변 사람들은 떼돈을 벌 기회라며 던전으로 향했지만 \n"
			+ "어렸을 때 부터 마을 사람들에게 부모님이 던전에 갔다가 죽었다는 것을 들어온 나는 근처에 갈 생각도 하지 않았다.\n"
			+ "그러던 어느 날 여동생이 쓰러져있었다. 다행이 얼마 안가 의식을 찾았고 의사에게 데려가보니 약만 있으면 금방 나을 수 있는 병이란다.\n"
			+ "그래 어디서든 돈만 있으면 약을 구할 수 있는 흔한병이다.\n"
			+ "돈... 돈이 필요하다...\n"
			+ "이대로 동생이 죽어가는걸 지켜보던지.. 던전으로 가는 도박을 할 수 밖에 없다..";
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
