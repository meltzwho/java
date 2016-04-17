
public class Generics {

	public static void main(String[] args) {
		myList<Integer> ints=new myList<>();
		ints.push(5);
		ints.push(4);
		ints.push(3);
		ints.push(2);
		ints.push(1);
		myList<Double> doubles=new myList<>();
		doubles.push(6.6);
		print(doubles,0);
		print(ints, 4);
		//incompatible type string
		//myList<String> strings=new myList<>();
	}
	public static void print(myList<?> list, int index){
		System.out.println(list.pop(index));
	}
}

class myList<T extends Number>{
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