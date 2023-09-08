package webClass230908;

public class Student implements Comparable<Student>{
	private String name;
	private int score; 
	//평균
	
	Student(String name, int score)
	{
		this.name=name;
		this.score=score;
	}
	
	public String getName()
	{
		return name;
	}
	public int getScore() {
		return score;
	}
	
	@Override
	public int hashCode()//이름으로 중복검사해라
	{
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object s)//중복처리
	{
		if(name.equals(((Student) s).getName())) return true;
		return false;
	}
	
	@Override
	public String toString()
	{
		return name+" : "+ score;
	}
	
	@Override
	public int compareTo(Student s)//양수면위로 0이면 제자리 음수면 아래로
	{
		return score-s.getScore();
	}
}
