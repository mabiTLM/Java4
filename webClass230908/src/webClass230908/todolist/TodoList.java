package webClass230908.todolist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TodoList {
	// 아이템 목록 출력 방법 : "제목 = 우선도"
//	TodoItem[] temp;
	// 중복처리 => Set => 제목을 기준으로 중복처리 << Set은 값만 있다.
	// 2개로 데이터를 다룬다 => Map => 키와 값 => 키 : 제목, 값 : Item
	private Map<String, TodoItem> hashList = new HashMap<String, TodoItem>();
	// 순서를 만들 수 있는, 정렬할 수 있는 => 정렬해주는 녀석이 무엇이었나?=>Tree
	// TreeSet, HashSet, HashMap을 배웠는데 TreeMap?
	private Map<Integer, List<TodoItem>> treeList = new TreeMap<Integer, List<TodoItem>>(Comparator.reverseOrder());
	
	public void add(
			int priority,
			String title,
			String content
			)//throws Exception
	{
		if(hashList.get(title)!=null)
		{
			System.out.println("제목 있어");
			//throw new Exception("제목 있어");
			return;
		}
		
		List<TodoItem> list = treeList.get(priority);
		if(list==null)
		{
			list = new ArrayList<TodoItem>();
			treeList.put(priority, list);
		}
		
		TodoItem temp = new TodoItem(priority, title, content);
		hashList.put(title, temp);
		list.add(temp);
	}
	
	public TodoItem getItem(String title)
	{		
		return hashList.get(title);
	}
	
	
	@Override
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		
		Iterator<Integer> treeIt = treeList.keySet().iterator();
		
		int count = 0;
		
		while(treeIt.hasNext())
		{
			//int tempPriority = treeIt.next();
			List<TodoItem> tempList = treeList.get(treeIt.next());
			for(TodoItem item : tempList)
			{
				sb.append("\n" + ++count + ". ");
				sb.append(item.toList()); 
			}
		}
		
		return sb.toString();
	}
	
		public void test() {
			add(1,"te","as");
			add(1,"bxzc","as");
			add(2,"te","as");
			add(2,"aasdfadf","as");
			System.out.println("--------------------");
			System.out.println(hashList);
			System.out.println("--------------------");
			System.out.println(treeList);
			System.out.println("--------------------");
			
			System.out.println(this);
			
			System.out.println(getItem("aasdfadf"));
		}
	}
