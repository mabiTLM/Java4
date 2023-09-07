package webClass230907;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) 
	{
		TreeSet<Integer> treeSet = new TreeSet<>();//트리 구조라 정렬을 해준다
		treeSet.add(6);
		treeSet.add(12);
		treeSet.add(7);
		treeSet.add(1);
		treeSet.add(6);
		treeSet.add(6);
		treeSet.add(6);
		System.out.println(treeSet.size());
		System.out.println(treeSet);
		
		for(Integer i : treeSet)
		{
			System.out.println(i);
		}
		System.out.println("처음은 " + treeSet.first());
		System.out.println("마지막은 " + treeSet.last());
		System.out.println("7 미만은 " + treeSet.lower(7));
		System.out.println("7 초과는 " + treeSet.higher(7));
		System.out.println("7 이하는 " + treeSet.floor(7));
		System.out.println("7 이상은 " + treeSet.ceiling(7));
		
		NavigableSet<Integer> descendingTreeSet = treeSet.descendingSet();
		System.out.println(descendingTreeSet);
		
		for(Integer i : descendingTreeSet)
		{
			System.out.println(i);
		}
		
		NavigableSet<Integer> rangeTreeSet = treeSet.tailSet(7, false);//true 이상 false 초과
		for(Integer i : rangeTreeSet)
		{
			System.out.println(i);
		}
		
		NavigableSet<Integer> rangeTreeSet2 = treeSet.headSet(7, true);//true 이상 false 초과
		for(Integer i : rangeTreeSet2)
		{
			System.out.println(i);
		}
		NavigableSet<Integer> rangeTreeSet3 = treeSet.subSet(1,false,12,false);//true 이상 false 초과
		for(Integer i : rangeTreeSet3)
		{
			System.out.println(i);
		}
	}
}
