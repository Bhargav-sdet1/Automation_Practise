package programs;

public class StringRev {

	public static void main(String[] args) {
		String name="Bhargav Goud";
		
		for(int i=name.length()-1;i>=0;i--)
		{
			System.out.print(name.charAt(i));
			System.out.println("Tst");
		}

	}

}