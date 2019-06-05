
public class PhoneTester {

	public static void main(String[] args) {
		Galaxy s9 = new Galaxy("S9", 99, "Verizon","Something really annoying" );
		IPhone iPhone10 = new IPhone("X",100,"AT&T","Marimba");
		iPhone10.displayInfo();
		System.out.println(iPhone10.getRingTone());
		s9.displayInfo();
		System.out.println(s9.getRingTone());
	}

}
