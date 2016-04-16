
public class Generics {

	public static void main(String[] args) {
		myList<Integer> ints=new myList<>();
		myList<String> strings=new myList<>();
		strings.push("teststr");
		System.out.println(strings.size());
		ints.push(123);
		ints.push(321);
		System.out.println(ints.pop(1));
		System.out.println(ints.size());
	}

}
class myList<T>{
	//fields
	private java.util.ArrayList<T> list=new java.util.ArrayList<>();
	//methods
	public void push(T obj){
		list.add(obj);
	}
	public int size(){
		return list.size();
	}
	public T pop(int i){
		T obj=list.get(i);
		list.remove(i);
		return obj;
	}
}