
public class isPalindrome {

	public static void main(String[] args) {
		System.out.print("Enter space separated strings to check: ");
		java.util.Scanner in=new java.util.Scanner(System.in);
		for(String checkMe: in.nextLine().split(" ")){
			System.out.printf("%s isPalindrome?: %b\n", checkMe, palindromeChecker(checkMe));
		}
	}

	public static boolean palindromeChecker(String checkMe){
		return palindromeChecker(0, checkMe.length()-1, checkMe);
	}
	
	public static boolean palindromeChecker(int low, int high, String checkMe){
		if(low==high||high-low==1){
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
