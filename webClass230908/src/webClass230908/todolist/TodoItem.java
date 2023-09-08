package webClass230908.todolist;

public class TodoItem {
	// 우선도, 제목, 내용
	private int priority;
	private String title;
	private String content;
	
	public TodoItem(int priority,String title, String content)
	{
		this.priority=priority;
		this.title=title;
		this.content=content;
	}
	
	@Override
	public String toString() {
		return "제목 : "+title + "\n우선도 : " + priority + "\n내용 :" + content;
	}
	
	public String toList() {
		return title+ " = " +priority;
	}
	
}
