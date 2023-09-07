package webClass230907;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class TodoList 
{
	public static void main(String[] args)
	{
		ListUp list = new ListUp();
		Scanner scan = new Scanner(System.in);
		while(true) {
			try
			{
				int choice;				
				System.out.println("1. 메모하기");
				System.out.println("2. 메모보기");
				choice=scan.nextInt();
				scan.nextLine();
				if(choice==1) {
					list.memo();
				}
				else if(choice==2) {
					list.open();
				}
			}
			catch(Exception e)
			{
				scan.nextLine();
				System.out.println("우선도는 숫자만 입력해주세요.");
			}
		}
	}
}


class ListUp//제목과 내용 적기
{
	ArrayList temp;//밑줄나오지만 밑에서 값넣어주니까 지우면 안된다.
	ListUp myAdress = this;
	Map<Integer, ArrayList<String>> priorityAndTitle = new HashMap<>();
	Map<String, String> titleAndDetail = new HashMap<>();	
	TreeSet<Integer> treeSet = new TreeSet<>();
	Map<String, ListUp> infinity = new HashMap<>();
	
	void memo()//제목과 우선도 입력
	{
		int priority;
		String title;
		String detail;
		Scanner scan = new Scanner(System.in);
		System.out.println("우선도를 입력해주세요.");
		priority=scan.nextInt();
		scan.nextLine();
		System.out.println("제목을 입력해주세요.");
		title=scan.nextLine();
		System.out.println("내용을 입력해주세요.");
		detail=scan.nextLine();
		
		if(titleAndDetail.get(title)==null)//같은 제목이 비어있을때만 추가 
		{
			if(priorityAndTitle.get(priority)==null)//우선도가 없으면 만들고
				{
				temp = new ArrayList();
				priorityAndTitle.put(priority, temp);// 우선도에 따른 제목을 여러개 받을 수 있고
				}
			priorityAndTitle.get(priority).add(title);//이미 있을땐 추가만 한다.
			titleAndDetail.put(title, detail); //제목당 내용은 하나
			treeSet.add(priority);
			
		}
		else
		{
			System.out.println("이미 같은 행동이 있어");
		}		
	}
	
	void open()
	{
		Scanner scan = new Scanner(System.in);
		for(Integer i : treeSet)
		{
			for(String j : priorityAndTitle.get(i))
			{
				System.out.println("우선도"+i+" : "+j);
			}
		}
		
		System.out.println("보고싶은 제목을 입력해주세요");
		String tempChoice = scan.nextLine();
		boolean isTempChoice = false;
		{
			for(Integer i : treeSet)
			{
				for(String j : priorityAndTitle.get(i))
				{
					if(j.equals(tempChoice))
					{
						isTempChoice=true;
						System.out.println(j+" : "+titleAndDetail.get(j));
						infinity(titleAndDetail.get(j));
						break;
					}
				}
			}
		}
		if(!isTempChoice)
		{
			System.out.println("그런 제목은 없어");
		}		
	}
	
	void infinity(String title)
	{
		if(infinity.get(title)==null)
		{
			infinity.put(title, myAdress);
			myAdress = new ListUp();			
		}
		int choice;
		Scanner scan = new Scanner(System.in);
		System.out.println("1. 메모하기");
		System.out.println("2. 메모보기");
		System.out.println("돌아가려면 아무거나");
		choice=scan.nextInt();
		scan.nextLine();
		if(choice==1) {
			myAdress.memo();
		}
		else if(choice==2) {
			myAdress.open();
		}
		
	}
}