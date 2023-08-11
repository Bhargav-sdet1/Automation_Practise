package javaConcepts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsEx2 {

	public static void main(String[] args) {
		
		List<Integer> val=Arrays.asList(1,2,3,4,1,9,2,3,4,5);
		val.stream().distinct().sorted().forEach(s->System.out.println(s));
		
		//Taking data directly in stream
		Stream.of(1,2,3,4,1,2,5,9,1,2,6,5,0).distinct().sorted().forEach(s->System.out.println(s));
	}

}
