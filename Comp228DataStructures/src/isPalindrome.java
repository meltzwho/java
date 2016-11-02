
//Eric Meltzer
public class isPalindrome {

	public static void main(String[] args) {
		String checkMe="";
		while(true){ //scary loop
			System.out.print("Enter string to check (quit to stop checking): ");
			java.util.Scanner in=new java.util.Scanner(System.in);
			checkMe=in.nextLine();
			if(checkMe.equals("quit"))break;
			System.out.printf
			("%s isPalindrome?: %b (checked recusively)\n", checkMe, palindromeChecker(checkMe.replaceAll("\\s", "")));
			System.out.printf
			("%s isPalindrome?: %b (checked iteratively)\n", checkMe, iterativePChecker(checkMe.replaceAll("\\s", "")));
		//above regular expression in replaceAll method removes whitespace
		}
	}
	
	public static boolean iterativePChecker(String checkMe){
		int high=checkMe.length()-1;
		for(int i=0;i<checkMe.length()/2;i++){
			if(checkMe.charAt(i)!=checkMe.charAt(high--)){
				return false;
			}
		}
		return true;
	}
	
	public static boolean palindromeChecker(String checkMe){
		return palindromeChecker(0, checkMe.length()-1, checkMe);
	}
	
	public static boolean palindromeChecker(int low, int high, String checkMe){
		if(low==high||low>high){
			return true;
		}
		else if(checkMe.charAt(low)==checkMe.charAt(high)){
			return palindromeChecker(++low, --high, checkMe);
		}
		else{
			return false;
		}
	}
}
