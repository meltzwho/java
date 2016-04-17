import java.util.*;
public class Iterators {

	public static void main(String[] args) {
		Collection<String> strings=new myArrayList<>();
		strings.add("Paul");
		strings.add("Blart");
		Iterator<String> itr=strings.iterator();
		System.out.println("strings before iteration: "+strings);
		while(itr.hasNext()){
			System.out.println("strings.size: "+strings.size());
			System.out.println("current iteration: "+itr.next());
			itr.remove();	
		}
		System.out.println("strings after iteration: "+strings);
	}
}
class myArrayList<T> extends ArrayList<T>{
	public String toString(){
		String s="";
		for(int i=0;i<super.size();i++){
			s+=super.get(i)+" ";
		}
		return s;
		}
}
