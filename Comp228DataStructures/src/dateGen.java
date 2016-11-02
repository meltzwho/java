
//Eric Meltzer
public class dateGen {

	public static void main(String[] args) {
		
		boolean continueCheck=true;
		Integer year;
		Palindrome checker=new Palindrome();
		
		while(continueCheck){
			
			System.out.print("Enter year to check in YYYY format (type quit to stop checking): ");
			java.util.Scanner in=new java.util.Scanner(System.in);
			
			try{
				year=in.nextInt();
			}
			catch(java.util.InputMismatchException ex){
				if(in.next().equals("quit"))
					continueCheck=false;
				else{
				System.out.println("Invalid year");
				}
				continue;
			}
			
			for(int i=1;i<=12;i++){
				for(int j=1;j<=daysInMonth(year,i);j++){
					//format date in various ways MM/DD/YYYY, M/D/YYYY, MM/DD/YY, M/D/YY
					String MMDDYYYY=String.format("%02d%02d%d", i, j, year);
					String MDYYYY=String.format("%d%d%d", i, j, year);
					String MMDDYY=String.format("%02d%02d%02d", i, j, Integer.parseInt(year.toString().substring(2,4)));
					String MDYY=String.format("%d%d%02d", i, j, Integer.parseInt(year.toString().substring(2,4)));
					
					if(checker.test(MMDDYYYY)){
						System.out.println(MMDDYYYY+" is palindrome MMDDYYYY");
					}
					if(checker.test(MDYYYY)&&!MDYYYY.equals(MMDDYYYY)){ //check to avoid redundancy
						System.out.println(MDYYYY+" is palindrome MDYYYY");
					}
					if(checker.test(MMDDYY)){
						System.out.println(MMDDYY+" is palindrome MMDDYY");
					}
					if(checker.test(MDYY)&&!MDYY.equals(MMDDYY)){ //check to avoid redundancy
						System.out.println(MDYY+" is palindrome MDYY");
					}
				}
			}
		
		}
	
	}
	
	//determine correct days in month
	public static int daysInMonth(int year, int month) {
	    int daysInMonth;
	    switch (month) {
	        case 1:
	        case 3:
	        case 5: 
	        case 7:
	        case 8:
	        case 10:
	        case 12:
	            daysInMonth = 31;
	            break;
	        case 2:
	            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
	                daysInMonth = 29;
	            } else {
	                daysInMonth = 28;
	            }
	            break;
	        default:
	        	daysInMonth = 30;
	    }
	    return daysInMonth;
	}
}
