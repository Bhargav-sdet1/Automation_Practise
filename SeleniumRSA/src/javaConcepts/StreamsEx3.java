package javaConcepts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamsEx3 {

	public static void main(String[] args) {
		
		List<Integer> val=Arrays.asList(1,2,3,4,1,9,2,3,4,5);
		//Sort and print
		val.stream().distinct().sorted().forEach(s->System.out.println(s));
		//Sort and assign to list and print required
		List<Integer> lis=val.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(lis.get(3));
	}

}
