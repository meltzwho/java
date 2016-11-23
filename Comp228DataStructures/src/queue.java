import ch03.stacks.*;

public class queue<T> {
	LinkedStack s1;
	LinkedStack s2;
	
	public boolean isEmpty(){
		return s1.isEmpty()&&s2.isEmpty();
	}
	
	public void enqueue(T element){
		s1.push(element);
	}
	
	public T dequeue(T element){
		while(!s1.isEmpty()){
			s2.push(s1.top());
			s1.pop();
		}
		
		T temp=(T)s2.top();
		s2.pop();
		
		while(!s2.isEmpty()){
			s1.push(s2.top());
			s2.pop();
		}
		
		return temp;
	}
}
