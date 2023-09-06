package webClass230906;

import java.util.Scanner;

public class HomeWorkLinkedListStack 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		SLLStack<String> box = new SLLStack();
		
		while(true) {
			System.out.println("1.넣기");
			System.out.println("2.빼기");
			int choice = scan.nextInt();
			scan.nextLine();
			switch(choice)
			{
			case 1:
				System.out.println("뭐를 넣을래?");
				String insert = scan.nextLine();
				box.push(insert);
				break;
				
			case 2:
				box.pop();
				break;	
			}
			
		}
	}
}

class Node<T>//이쪽코드를 이용해보자 다음노드를 가르키는 데이터
{
	T data;
	Node<T> next;
	
	public Node(T data)
	{
		this.data=data;//데이터를 넣고
		this.next=null;//다음 노드를 비워둔다
	}
}

class SLLStack<T>
{
	Scanner scan = new Scanner(System.in);
	Node<T>top = new Node<>(null);
	Node<T>nextTop = new Node<>(null);
	public SLLStack()
	{
		
	}
	public void push(T insert)//넣은 데이터를 새로운 노드에 넣고 기존노드 주소를 next에 넣어야한다.
	{
		nextTop = new Node<>(insert);//새로운 위를 만들어서 자료를 넣고
		nextTop.next=top;//위에서 아래를 바라본다.
		top=nextTop;//탑주소를 바꾼다 이부분이 문제인데
	}
	public void pop()
	{
		if(nextTop.data==null)
		{
			System.out.println("내용물이 없는데");
		}
		else {
		System.out.println(nextTop.data);
		nextTop=nextTop.next;
		}
		
	}
		
}