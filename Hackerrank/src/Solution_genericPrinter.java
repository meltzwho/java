class Printer{
	public <T> void printArray(T[] arr){
		for(T element: arr){
			System.out.println(element);
		}
	}
}