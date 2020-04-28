/*
 *
 *
 *
 * **/
public class Foo<T>{
	Foo(){
	}
	public static void main(String[] args){
		Foo<int[]> foo = new Foo<>();	
		int[] a = {1,2,3};
		Class<int[]> klass = int[].class;
		System.gc();
	}
}
