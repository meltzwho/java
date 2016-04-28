import java.util.*;
public class CombinationLock {
	LinkedList<Character> lock=new LinkedList<>();
	public CombinationLock(){
		buildLock();
	}
	//methods
	private void buildLock(){
		for(int i=0;i<39;i++){
			lock.addLast('-');
		}
	}
	private void displayLock(){
		top(0);
		middle(0);
		bottom();
	}
	public void moveLock(boolean turn, int amt){
		if(turn){
			
		}else{
			
		}
	}
	 //Postcondition: Prints the top half of the combination lock
    public static void top(int rotate){
	System.out.println("             " + rotate);
	for(int i=0; i <10 ; i++){
	    for (int j = 12; j>0+i ; j--){
		System.out.print(" ");
	    }
	    System.out.print("-");
	    if(i == 0)
		 System.out.println();
	    if(i!=0){
		for(int j= 1; j< 2*i; j++){
		    System.out.print(" ");
		}
		System.out.println("-");
	    }
	}
    }
    
    //Postcondition: prints the middle line
    public static void middle(int rotate){
	System.out.print(rotate +30+ "-");
	for(int i = 0; i<19; i++){
	    System.out.print(" ");
	}
	System.out.println("-" + (rotate +10));
    }
    
    //Postcondition: prints the bottom of the lock
    public static void bottom(int rotate){
	for(int i=0; i<10; i++){
	    for (int j= i+3; j>0; j--){
		System.out.print(" ");
	    }
	    if(i!=9)
		System.out.print("-");
	    for (int j=18-(2*i); j>1;j--){
		System.out.print(" ");
	    }
	    System.out.println("-");
	}
	System.out.println("            "+(rotate+20));
    }
}
