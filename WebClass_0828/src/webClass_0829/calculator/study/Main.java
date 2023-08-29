package webClass_0829.calculator.study;

public class Main {
	public static void main(String[] args)
	{	
		Calculator calc = new Calculator();
		System.out.println(calc.calculate('+',1,2,3,4,10));
		System.out.println(calc.calculate('-',10,1,1));
		System.out.println(calc.calculate('*',2,4,8));
		System.out.println(calc.calculate('/',1,2,2,2));
		
	}
	

}
