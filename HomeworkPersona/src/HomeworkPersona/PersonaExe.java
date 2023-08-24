package HomeworkPersona;

public class PersonaExe {
	
	public static void main(String[] args)
	{
		Pixie pixie = new Pixie();
		for(int i = 0; i <7; i++)
		{		
		pixie.levelup();
		pixie.getStatus();
		pixie.learn();
		pixie.getSkill();
		}
	}

}
