package web230911;

import java.util.Arrays;

public class MatchTest {
	public static void test()
	{
		int[] arr = {1,3,5,7};
		int[] arr1 = {2,4,6,8};
		
		System.out.println(Arrays.stream(arr).allMatch(item->item%2==0));
		System.out.println(Arrays.stream(arr1).allMatch(item->item%2==0));
		
		System.out.println(Arrays.stream(arr).anyMatch(item->item%2==0));
		System.out.println(Arrays.stream(arr1).anyMatch(item->item%2==0));
		
		System.out.println(Arrays.stream(arr).noneMatch(item->item%2==0));
		System.out.println(Arrays.stream(arr1).noneMatch(item->item%2==0));
	}

}
