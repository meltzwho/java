import java.util.*;
public class Iterators {

	public static void main(String[] args) {
		myLinkedList<String> strings=new myLinkedList<>();
		strings.add("Paul");
		strings.add("Blart");	
		ListIterator<String> itr=strings.listIterator(strings.size());
		System.out.println("strings before iteration: "+strings);
		while(itr.hasPrevious()){
			System.out.println("strings.size: "+strings.size());
			System.out.println("current iteration: "+itr.previous());
		}
		System.out.println("strings after iteration: "+strings);
	}
}
class myLinkedList<T> extends LinkedList<T>{
	public String toString(){
		String s="";
		for(T element: this){
			s+=element+" ";
		}
		return s;
		}
}
