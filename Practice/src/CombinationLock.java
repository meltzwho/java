import java.util.*;

public class CombinationLock {
	//fields
	LinkedList<Character> lock=new LinkedList<>();
	LinkedList<Integer> nums=new LinkedList<>();
	//constructor
	public CombinationLock(){
		buildLock(true);
		displayLock(false);
	}
	//methods
	private void buildLock(boolean init){
		lock.clear();
		for(int i=0;i<40;i++){
			lock.add('-');
			if(init)
				nums.add(i);
		}
	}
	private void displayLock(boolean turn){
		int head=0;
		int tail=nums.size()-1;
		//Prints top to mid-line
		System.out.println("            "+nums.getFirst());
		for(int i=0;i<10;i++){
		    for (int j=12;j>i; j--){
				System.out.print(" ");
		    	}
		    if(i==0&&!turn)
			    System.out.print(lock.get(head++));
		    else
		    	System.out.print(lock.get(tail--));
		    if(i==0)
			 	System.out.println();
		    if(i!=0){
				for(int j= 1; j< 2*i; j++){
			    	System.out.print(" ");
				}
			System.out.println(lock.get(head++));
			}
		}
		//Prints mid-line
		if(turn)
			System.out.print(nums.get(++tail)+""+ lock.get(tail));
		else
			System.out.print(nums.get(tail)+""+ lock.get(tail));
		for(int i = 0; i<19; i++){
			System.out.print(" ");
		}
		if(turn)
			System.out.println(lock.get(++head) +""+ nums.get(head));
		else
			System.out.println(lock.get(head) +""+ nums.get(head));
		//Print from mid-line to bottom
		for(int i=0; i<10; i++){
		    for (int j= i+3; j>0; j--){
				System.out.print(" ");
		    }
		    if(i!=9)
		    	System.out.print(lock.get(--tail));
		    for (int j=18-(2*i); j>1;j--){
				System.out.print(" ");
		    }
		    System.out.println(lock.get(++head));
			}
		System.out.println("            "+nums.get(head));
}

	public void turn(boolean turn, int amt){
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
		displayLock(turn);
	}
	
	public static void main(String[] args){
		CombinationLock hi=new CombinationLock();
		hi.turn(true, 38);
		hi.turn(true, 25);
	}
}