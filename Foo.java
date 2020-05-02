/*
 *
 *
 *
 * **/
import java.lang.*;
import java.util.*;
import java.io.*;
import static java.lang.System.out;
public class Foo{
	public Foo(){
	}
	public static void main(String[] args){
		//reflection
		Class<int[]> klass = int[].class;
		//System class
		System.gc();
		//use generic class
		Bar<? extends Object, ? extends Object> bar = new Foo().new Bar<Object, Object>();
		//collection interface
		List<Object> objlist26 = new ArrayList<Object>();
		objlist26 = new LinkedList<Object>();
		objlist26.add(new Object());
		//CAP#1 error
		List<?> list28 = new LinkedList<Object>();//list28.add(new Object());
		//Arrays.asList(). Arrays class is a menmber of the Java Collection Framework.
		List<Object> objlist32 = Arrays.asList(new Object(), new Object(), new Object());
			//ArrayList<Object> objlist320 = objlist32;
			//out.println(Arrays.asList(new Object(), new Object(), new Object()));
		//Arrays.toString()
		int[] intarray35 = new int[]{0,1,2}; out.println(Arrays.toString(intarray35));
		Object[] objarray35 = {new Object(), new Object()}; out.println(Arrays.toString(objarray35));
		//inference variable T has incompatible bounds
		List<int[]> intlist440 = Arrays.asList(new int[]{1,2,3});
			//List<Integer> intlist440 = Arrays.asList(new int[]{1,2,3});
		//reference types and primitive types
		// 1) A array doesn't reference a primitive data.
		int i360 = 0; int i361 = 1; int i362 = 2;
		int[] intarray39 = new int[]{i360, i361, i362}; i360 = 3;
		out.println(Arrays.toString(intarray39));
		// 2) List<T> doesn't have add() 
		List<Integer> il44 = new LinkedList<Integer>(Arrays.asList(0,1,2)); il44.add(3);
		// 3) List<T> doesn't reference a reference type.
		String s45 = "abc";
		List<String> ls45 = new ArrayList<>(); 
		ls45.add(s45); out.println(ls45);
		s45 = "bcd"; out.println(ls45);
		ls45.set(0,"cde"); out.println(ls45); out.println(s45);
	}
	//generic class
	public class Bar<T, U extends T>{
		public Bar(){
		}
		//generic method
		public <TT> void doIt(TT tt){
		}
		//wildcard type in argument
		public void doIt(Bar<?,?> bar){
		}
		//inheritance of generic class
		public class Buz<E> extends Bar<List<E>, LinkedList<E>>{
			public Buz(){
			}
			public void doIt(){
				doIt(new Buz<String>());
			}
		}
	}
}
