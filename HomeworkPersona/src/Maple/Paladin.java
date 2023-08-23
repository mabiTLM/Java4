package Maple;

public class Paladin {
	//	public static void main(String[] args) {
	//	Shadower test = new Shadower();
	//	System.out.println(test.getMainStatus(10));
	//}
	
	public String gender = "Man";
	public String kind = "human";
	public String[][] voice = new String[][] {
		{"Korean", "man", "이호산"},
		{"Korean", "woman", "김은아"},
		{"Global", "man", "브렌트 무카이"},
		{"Global", "woman", "발레리 아렘"},
		{"Japanese", "man", "오오모모 요스케"},
		{"Japanese", "woman", "슈토 유키나"}
	};
	public String [] job = new String[] {
		"모험가", "전사"
	};
	public String[] waepon = new String[] {"두손둔기", "한손둔기", "두손검", "한손검"};
	public String[] subWaepon = new String[] {"로자리오", "방패"};
	public String mainStatus = "STR";
	public String[] subStatus = new String[] {
		"DEX"
	};
	public String[] jobList = new String[] {
		"검사", "페이지", "나이트", "팔라딘", "팔라딘"	
	};
	public String[][] globalWriting = new String[][] {
		{"Global", "Paladin"},
		{"Japan", "パラディン"},
		{"China", "圣骑士(성기사)"},
		{"Taiwan", "聖騎士(성기사)"}
	};
	
	public double[] waeponRate = new double[] {1.24d, 1.34d};
	public int attackSpeed = 7;
//	public double workmanwhip = 0.9;
	public double getWorkmanwhip(int workmanwhip) {
		return workmanwhip * 0.3 + 91d;
	}
	
	public double getMainStatus(int mainStatus) {
		return mainStatus * (int) (Math.random() * 4 + 0.16) + (int) (Math.random() * 30 + 50);
	}
	
	public double getSubStatus(int subStatus) {
		return 30d;
	}
	
	public int getPower() {
		return 110;
	}
	
	public int getDamage() {
		return (int) (Math.random() * 10 + 25);
	}
	
	public int getBossDamage() {
		return 0;
	}
	
	public double getFinalDamage() {
		return Math.random() * 146.91d + 71.82d;
	}
	
	public double getIgnoringDefense() {
		return Math.random() * 27.27d + 31d;
	}
	public String[] property = new String[] {"물리", "성"};
	public double subAttack = 0;
	
//	public int defense = 110;
	public double getDefense(int defense) {
		return defense * 2.5 + 620d;
	}
//	public int tolerance = 30;
	public int getTolerance() {
		return (int) (Math.random() * 80 + 50);
	}
	public double allTolerance = 0.4d;
	public int evasion = 0;
	public int stance = 100;
	public boolean isStance = true;
	public boolean isMagicGuard = false;
//	public int damageReduction = 60;
	public double getDamageReduction(int damageReduction) {
		return damageReduction * 0.5 + 0.5;
	}
	public int damageAbsorption = 0;
//	public boolean damageRateReduction = 10d;
	public double getDamageRateReduction(int damageRateReduction) {
		return damageRateReduction * 0.3375 + 0.325;
	}	
	public boolean isGuard = true;
	
	public int criticalRate = 47;
	public int getCriticalRatePlus() {
		return 50;
	}
	public int getCriticalDamage() {
		return (int) (Math.random() * 1 + 20);
	}
	public int getAverageCritical() {
		return (int) (Math.random() * 1 + 155);
	}
	
	public double movingSpeed = 1.1d;
	public double maxMovingSpeed = 1.5d;
	public double jumpingPower = 1.1d;
}
