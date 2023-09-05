package webClass230905;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeworkStack 
{
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Stack stack = new Stack();
		while(true) {
			System.out.println("1.물건 넣기");
			System.out.println("2.물건 빼기");
			
			int choice = scan.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("뭐를 넣을래?");
				scan.nextLine();
				String insert = scan.nextLine();
				stack.stackIn(insert);
				break;
			case 2:
				stack.stackOut();
				break;
			default:
				break;
			}
		}
	}
}

class Stack<T>
{
	List<T> list = new ArrayList();
	
	public void stackIn(T insert) 
	{
		list.add(insert);
	}
	
	public void stackOut()
	{
		if(!list.isEmpty()) {
			System.out.println(list.get(list.size()-1)+"가 나왔다.");
			list.remove(list.size()-1);
		}
		else
		{
			System.out.println("물건이 없는데");
		}
	}
	
}
