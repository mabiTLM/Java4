package Maple;

public class Shadower {
//	public static void main(String[] args) {
//		Shadower test = new Shadower();
//		System.out.println(test.getMainStatus(10));
//	}
	
	public String gender = "Woman";
	public String kind = "human";
	public String[][] voice = new String[][] {
		{"Korean", "man", "이호산"},
		{"Korean", "woman", "이소운"},
		{"Global", "man", "토니 아졸리노"},
		{"Global", "woman", "잰시 원"},
		{"Japanese", "man", "카네모토 료스케"},
		{"Japanese", "woman", "타나카 토모미"}
	};
	public String [] job = new String[] {
		"모험가", "도적"
	};
	public String waepon[] = new String[] {"단검"};
	public String[] subWaepon = new String[] {"단검용 검집", "방패"};
	public String mainStatus = "Luk";
	public String[] subStatus = new String[] {
		"DEX", "STR"
	};
	public String[] jobList = new String[] {
		"로그", "시프", "시프마스터", "섀도어", "섀도어"	
	};
	public String[][] globalWriting = new String[][] {
		{"Global", "Shadower"},
		{"Japan", "シャドー"},
		{"China", "侠盗(협도)"},
		{"Taiwan", "暗影神偷(암영신투)"}
	};
	
	public double waeponRate = 1.3d;
	public int attackSpeed = 6;
	public double workmanwhip = 0.9;
	
	public double getMainStatus(int mainStatus) {
		return mainStatus * 1.15d + 80d;
	}

	public double getSubStatus(int subStatus) {
		return subStatus + 30d;
	}

	public int getPower() {
		return (int) (Math.random() * 30 + 160);
	}

	public int getDamage() {
		return (int) (Math.random() * 10 + 25);
	}

	public int getBossDamage() {
		return 0;
	}

	public double getFinalDamage() {
		return Math.random() * 108.44d + 43.75d;
	}
	
	public int getIgnoringDefense() {
		return 20;
	}
	public String property = "물리";
	public double subAttack = 0.7d;
	
	public int defense = 110;
	public int tolerance = 30;
	public double allTolerance = 0.3d;
	public int evasion = 56;
	public int stance = 100;
	public boolean isStance = true;
	public boolean isMagicGuard = false;
	public int damageReduction = 60;
	public int damageAbsorption = 0;
	public double damageRateReduction = 10d;	
	public boolean isGuard = false;
	
	public int criticalRate = 55;
	public int getCriticalRatePlus() {
		return (int) (Math.random() * 75 + 25);
	}
	public int getCriticalDamage() {
		return (int) (Math.random() * 20 + 40);
	}
	public int getAverageCritical() {
		return (int) (Math.random() * 20 + 195);
	}

	public double movingSpeed = 1.4d;
	public double maxMovingSpeed = 1.6d;
	public double jumpingPower = 1.2d;
}
