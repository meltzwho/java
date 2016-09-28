
public class stackArray {

	static int stackArray[]=new int[5];
	static int top=-1;
	
	public void push(int num){
		stackArray[++top]=num;
	}
	
	public int pop(){
		return stackArray[top--];
	}
	
	public int peek(){
		return stackArray[top];
	}

}
