package webClass230906;

import java.util.LinkedList;
import java.util.Scanner;

public class NewHomeWork {//바뀌는게 없는데 이방법을 원한게 아닌것같다.
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Stack box = new Stack();
		
		while(true) {
		System.out.println("1.넣기");
		System.out.println("2.빼기");
		int choice = scan.nextInt();
		scan.nextLine();
		switch(choice)
		{
		case 1:
			System.out.println("1.정수넣기");
			System.out.println("2.문자넣기");
			choice = scan.nextInt();
			scan.nextLine();
			switch(choice)
			{
			case 1 :
				int insertInt = scan.nextInt();
				box.stackIn(insertInt);
			break;
			case 2 :
				String insertString = scan.nextLine();
				box.stackIn(insertString);				
			break;
			}
			
			
			break;
		case 2:
			box.stackOut();
			break;
			
			default:
				System.out.println("선택이 틀렸어");
				break;
			
		}
	}		
	}
}

class Stack <T>
{	
	LinkedList<T> list = new LinkedList();
	
	public void stackIn(T insert)
	{
		list.add(insert);
	}
	
	public void stackOut()
	{
		if(!list.isEmpty())
		{
			System.out.println(list.get(list.size()-1)+"가 나왔다.");
			list.remove(list.size()-1);
			
		}
		else
		{
			System.out.println("물건이 없는데");
			
		}
		
	}
	
}