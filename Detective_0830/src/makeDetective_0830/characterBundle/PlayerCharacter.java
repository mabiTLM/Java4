package makeDetective_0830.characterBundle;

public class PlayerCharacter extends CharacterBase 
{
	public PlayerCharacter()
	{//플레이어블 캐릭터
		super("주인공",
				new String[] {},
				new OwnedSkill[]{},
				new OwnedItem[] {},
				5,
				0);
	}

}
