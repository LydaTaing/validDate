import java.util.Scanner;

public class leepYear {

	public static void main(String[] args) {
		Scanner console = new Scanner (System.in);
		System.out.print("What is year?");
		int year = console.nextInt();
		
		if (isleap(year)) {
			System.out.println(year+ " is a leap year.");
		}
	}

	private static boolean isleap (int year) {
	
		if (year%4 == 0) {//it fully div by 4
			if (year%100==0) {// it fully div by 100
				if (year%400 ==0) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}
}
