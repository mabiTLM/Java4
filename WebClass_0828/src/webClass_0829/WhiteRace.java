package webClass_0829;

public final class WhiteRace extends Person
{
	int[] skinColor;
	WhiteRace()
	{
		super();
		skinColor = new int[] {255,255,255,1}; //R,G,B,투명도
		String tempColor = "ffffff";
		// 0||1
		// 11 => 3 / 111 => 7 / 1111 => 15 / 0~1111 16
	}
}
