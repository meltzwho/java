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
		
	}
}