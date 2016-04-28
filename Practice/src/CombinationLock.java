import java.util.*;

public class CombinationLock {
	//fields
	LinkedList<Character> lock=new LinkedList<>();
	LinkedList<Integer> nums=new LinkedList<>();
	boolean whichway;
	//constructor
	public CombinationLock(){
		buildLock(true);
		displayLock();
	}
	//methods
	private void buildLock(boolean init){
		lock.clear();
		for(int i=0;i<39;i++){
			lock.add('-');
			if(init)
				nums.add(i);
		}
	}
	private void displayLock(){
		int count=0;
		int count2=nums.size();
			System.out.println("            " + nums.getFirst());
			for(int i=0; i <10 ; i++){
		    		for (int j = 12; j>0+i ; j--){
					System.out.print(" ");
		    		}
		    		if(i==0&&!whichway){
			    		System.out.print(lock.get(++count));
		    		}else{
		    		System.out.print(lock.get(--count2));
		    		}
		    		if(i == 0)
			 		System.out.println();
		    		if(i!=0){
					for(int j= 1; j< 2*i; j++){
			    			System.out.print(" ");
					}
				System.out.println(lock.get(++count));
		    		}
			}
	    	
	    
	    	//Postcondition: prints the middle line
			
			if(whichway)
				System.out.print(nums.get(++count2)+""+ lock.get(--count2));
			else
				System.out.print(nums.get(count2)+""+ lock.get(--count2));
			for(int i = 0; i<19; i++){
		    		System.out.print(" ");
			}
			if(whichway)
				System.out.println(lock.get(++count) +""+ nums.get(count));
			else
				System.out.println(lock.get(count) +""+ nums.get(count));
	    	
	    
	    	//Postcondition: prints the bottom of the lock

			for(int i=0; i<10; i++){
		    		for (int j= i+3; j>0; j--){
					System.out.print(" ");
		    		}
		    		if(i!=9)
					System.out.print(lock.get(--count2));
		    		for (int j=18-(2*i); j>1;j--){
					System.out.print(" ");
		    		}
		    		System.out.println(lock.get(++count));
			}
			System.out.println("            "+nums.get(count));
}

	public void turn(boolean turn, int amt){
		whichway=turn;
		buildLock(false);
		if(turn){
			while(nums.getFirst()!=amt){
				nums.addFirst(nums.removeLast());
				lock.removeLast();
				lock.addFirst('+');
			}
		}else{
			while(nums.getFirst()!=amt){
				nums.addLast(nums.removeFirst());
				lock.removeFirst();
				lock.addLast('+');
			}
		}
		displayLock();
	}
	
	public static void main(String[] args){
		CombinationLock hi=new CombinationLock();
		hi.turn(false, 4);
		hi.turn(false, 8);
	}
}