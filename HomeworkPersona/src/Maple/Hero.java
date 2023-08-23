package Maple;

public class Hero {
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
		{"Japanese", "man", "나카고미 나오야"},
		{"Japanese", "woman", "오구라 비앙카"}
	};
	public String [] job = new String[] {
		"모험가", "전사"
	};
	public String[] waepon = new String[] {"두손도끼", "한손도끼", "두손검", "한손검"};
	public String[] subWaepon = new String[] {"메달", "방패"};
	public String mainStatus = "STR";
	public String[] subStatus = new String[] {
		"DEX"
	};
	public String[] jobList = new String[] {
		"검사", "파이터", "크루세이더", "히어로", "히어로", "히어로"
	};
	public String[][] globalWriting = new String[][] {
		{"Global", "Hero"},
		{"Japan", "ヒーロー"},
		{"China", "英雄(영웅)"},
		{"Taiwan", "英雄(영웅)"}
	};
	
	public double[] waeponRate = new double[] {1.34d, 1.44d};
	public int attackSpeed = 7;
	public double workmanwhip = 0.9;
//	public double getWorkmanwhip(int workmanwhip) {
//		return workmanwhip * 0.3 + 91d;
//	}
	
	public double getMainStatus(int mainStatus) {
		return mainStatus * 0.15 + 50;
	}
	
	public double getSubStatus(int subStatus) {
		return 30d;
	}
	
	public int getPower() {
		return (int) (Math.random() * 74 + 80);
	}
	
	public double getDamage() {
		return 0.65d;
	}
	
	public double getBossDamage() {
		return Math.random() * 0.04 + 0.2;
	}
	
	public double getFinalDamage() {
		return Math.random() * 393.71d + 142d;
	}
	
	public double getIgnoringDefense() {
		return Math.random() * 0.08d + 0.5d;
	}
	public String[] property = new String[] {"물리"};
	public double subAttack = 0;
	
	public int defense = 200;
//	public double getDefense(int defense) {
//		return defense * 2.5 + 620d;
//	}
//	public int tolerance = 30;
	public int getTolerance() {
		return (int) (Math.random() * 180 + 30);
	}
	public double allTolerance = 0.3d;
	public int evasion = 0;
	public int stance = 100;
	public boolean isStance = true;
	public boolean isMagicGuard = false;
	public double damageReduction = 0.4d;
//	public double getDamageReduction(int damageReduction) {
//		return damageReduction * 0.5 + 0.5;
//	}
	public int damageAbsorption = 0;
	public int damageRateReduction = 0;
//	public double getDamageRateReduction(int damageRateReduction) {
//		return damageRateReduction * 0.3375 + 0.325;
//	}	
	public boolean isGuard = false;
	
	public int criticalRate = 25;
	public int getCriticalRatePlus() {
		return 100;
	}
	public int criticalDamage = 0;
//	public int getCriticalDamage() {
//		return (int) (Math.random() * 1 + 20);
//	}
	public int getAverageCritical() {
		return (int) (Math.random() * 20 + 135);
	}
	
	public double movingSpeed = 1.1d;
	public double maxMovingSpeed = 1.5d;
	public double jumpingPower = 1.1d;
}
