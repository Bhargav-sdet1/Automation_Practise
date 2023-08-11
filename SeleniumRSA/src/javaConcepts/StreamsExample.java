package javaConcepts;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

public class StreamsExample {

	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Ram");
		names.add("Bhargav");
		names.add("Vinee");
		names.add("Ramesh");
		names.add("Prasanna");
		
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		
		long d=Stream.of("Bhargav","Ram","Ramesh","Prasanna","Vinee").filter(s->s.startsWith("R")).count();
		System.out.println(d);
		
		names.stream().filter(s->s.startsWith("R")).sorted()
			.map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		List<String> ls =Stream.of("Bhargav","Ram","Vithika","Ramya").filter(s->s.endsWith("a"))
			.map(s->s.toUpperCase())
			.collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		
	}

}
