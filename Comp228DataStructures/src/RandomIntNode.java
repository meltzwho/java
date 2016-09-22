import java.util.Random;

public class RandomIntNode {
	private int value;
	private static int defaultRange = 100;
	private RandomIntNode next;
	
	public RandomIntNode() {
		Random rn = new Random();
		value = rn.nextInt(defaultRange) + 1;
		next = null;
	}
	
	public RandomIntNode(int range) {
		Random rn = new Random();
		value = rn.nextInt(range) + 1;
		next = null;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue() {
		Random rn = new Random();
		value = rn.nextInt(defaultRange) + 1;
	}
	
	public void setValue(int range) {
		Random rn = new Random();
		value = rn.nextInt(range) + 1;
	}
	
	public RandomIntNode getNext() {
		return next;
	}
	
	public void setNext(RandomIntNode next) {
		this.next = next;
	}

}

class LinkedListPractice{
	
	public static void main(String args[]){
		RandomIntNode head=new RandomIntNode();
		RandomIntNode current=null;
		RandomIntNode prev=null;
		
		current=head;
		for(int i=0;i<9;i++){
			prev=current;
			current=new RandomIntNode();
			prev.setNext(current);
		}
		current=head;
		while(current!=null){
			System.out.println(current.getValue());
			current=current.getNext();
		}
		current=head;
		prev=null;
		while(current!=null){
			if(current.getValue()%2==0){
				if(prev==null){
					head=current.getNext();
				}
				else{
					prev.setNext(current.getNext());
				}
			}
			else{
				prev=current;
			}
			current=current.getNext();
		}
		current=head;
		System.out.println("Evens removed:");
		while(current!=null){
			System.out.println(current.getValue());
			current=current.getNext();
		}
	}
}