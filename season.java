import java.util.Scanner;

public class season {

	public static void main(String[] args) {
		Scanner console = new Scanner (System.in);
		System.out.print("The date: ");
		int date = console.nextInt();
		System.out.print("The month: ");
		int month = console.nextInt();
		String season = Calseason(date, month);
		System.out.println("The season is "+ season);

	}

	private static String Calseason(int date, int month) {
		String result="";
		if (month>=9 && date <= 22) {
				if (month <=12 && date <=20) {
					result = "Fall";
				}	
		}
		if (month<=3 && date <= 21) {
			if (month <=12 && date <=20) {
				result = "Winter";
			}	
		}
		
		return result;
		
	}

}
