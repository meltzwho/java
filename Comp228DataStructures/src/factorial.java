import java.util.Scanner;

public class factorial {

	public static void main(String[] args) {
		
		//loop
		long x=1;
		int factorial;
		System.out.print("Enter int to preform factorial on: ");
		Scanner in=new Scanner(System.in);
		factorial=in.nextInt();
		for(int i=1;i<=factorial;i++){
			x=x*i;
		}
		System.out.println(x);
		
		//recusive
		System.out.println(doFactorial(factorial));
		//fib
		System.out.println(fib(factorial));
	}
	
	public static long doFactorial(long x){
		if(x==0){
			return 1;
		}
		return x*doFactorial(x-1);
	}
	
	public static long fib(long x){
		if(x==0){
			return 0;
		}
		if(x==1){
			return 1;
		}
		return fib(x-1)+fib(x-2);
	}
}
