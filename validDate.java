import java.util.Scanner;

public class validDate {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter the date(mm dd yyyy): ");
		int month = console.nextInt();
		int day = console.nextInt();
		int year = console.nextInt();
		
		if (isDateValid(month, day, year)){	
			nextDay(month, day, year);
			System.out.print("Enter the advance date(mm dd yyyy): ");
			int m = console.nextInt();
			int d = console.nextInt();
			int y = console.nextInt();
			
			
			int sub= advanceToDate(m,d,y, month, day, year);
			System.out.printf("You were %d days old.", sub);
			
			
		}
		else {
			System.out.println("Date is NOT valid!");
		}
	}
		

	
	private static int advanceToDate(int m, int d, int y, int month, int day, int year) {
		int sub=0;
		int leap=0;
		int month30=0;
		int month31=0;
		int feb=0;
		for (int i =year; i<y-year; i++) {
			if (isLeap(i)) {
				leap++;
			}
		}
		if (month<m) {
			for (int i=month; i<(Math.abs(m-month)+month); i++) {
				if (i == 1 || i == 3 || i == 5
						|| i == 7 || i == 8 || i == 10
						|| i == 12) {
					month31++;
				}else if(i == 4 || i == 6 || i == 9 || i == 11) {
					month30++;		
				}else {
					feb++;
				}
			
			}
			if(isLeap(y)) {
				sub=(d-day)+(month30*30)+(month31*31)+(feb*29)+((y-year-leap)*365)+(leap*366);
			}else {
				sub=(d-day)+(month30*30)+(month31*31)+(feb*28)+((y-year-leap)*365)+(leap*366);
			}
		}
		else if(month>m) {
			for (int i=m; i<(Math.abs(m-month)+m); i++) {
				if (i == 1 || i == 3 || i == 5
						|| i == 7 || i == 8 || i == 10
						|| i == 12) {
						month31++;
				}else if(i == 4 || i == 6 || i == 9 || i == 11) {
					month30++;
						
				}else {
					feb++;
				}
			}
			if (isLeap(y)) {
				sub=(d-day)-((month30*30)+(month31*31)+(feb*28))+((y-year-leap)*365)+(leap*366);
			}else {
				sub=(d-day)-((month30*30)+(month31*31)+(feb*28))+((y-year-leap)*365)+(leap*366);
			}
		}
		return sub;
	}






	private static void nextDay(int month, int day, int year) {
		int Nd=day;
		int Nm=month;
		int Ny=year;
		if (month == 1 || month == 3 || month == 5
				|| month == 7 || month == 8 || month == 10
				|| month == 12) {
			if (month<12) {
				if(day<31) {
					Nd++;
				}else if(day==31) {
					Nd=1;
					Nm++;
				}
			}else if (month==12) {
				if(day<31) {
					Nd++;
					Nm=1;
					Ny++;
				}else if(day==31) {
					Nd=1;
					Nm=1;
					Ny++;
				}
			}	
		}else if(month == 4 || month == 6 || month == 9 || month == 11){
				if(day<30) {
					Nd++;
				}else if(day==30) {
					Nd=1;
					Nm++;
				}
		}else {//feb
			if(day<29) {
				Nd++;
			}else if (day==29) {
				Nd=1;
				Nm++;
			}
		}
		System.out.printf("The next date after %d %d, %d is %d %d, %d", month, day , year, Nm, Nd, Ny);
	}






	private static boolean isLeap(int year) {

		if (year % 4 == 0) {// it fully div by 4
			if (year % 100 == 0) {// it fully div by 100
				if (year % 400 == 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	private static boolean isDateValid(int month, int date, int year) {
		if (year > 0) {
			if (month > 0) {
				if (month <= 12) {
					if (date >= 1) {
						if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
								|| month == 12) {
							if (date >= 31) {
								return true;
							} else {
								return false;
							}
						} else if (month == 4 || month == 6 || month == 9 || month == 11) {
							if (date >= 30) {
								return true;
							} else {
								return false;
							}
						} else {// Feb
							if (isLeap(year)) {
								if (date <= 29) {
									return true;
								} else {
									return false;
								}
							} else if (date <= 28) {
								return true;
							} else {
								return false;
							}

						}
					}

					else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}

