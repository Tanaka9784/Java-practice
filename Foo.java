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
		int[] intarray35 = new int[]{0,1,2}; out.print("35: " + Arrays.toString(intarray35) + ", ");
		Object[] objarray35 = {new Object(), new Object()}; out.println(Arrays.toString(objarray35));
		//inference variable T has incompatible bounds
		List<int[]> intlist440 = Arrays.asList(new int[]{1,2,3});
			//List<Integer> intlist440 = Arrays.asList(new int[]{1,2,3});
		//Collection.toArray()
		out.println("35: " + Arrays.toString(new ArrayDeque<Integer>(Arrays.asList(0,1)).toArray()));
		//reference types and primitive types
		// 1) A array doesn't reference a primitive data and a reference type.
		int i360 = 0; int i361 = 1; int i362 = 2;
		int[] intarray39 = new int[]{i360, i361, i362}; i360 = 3;
		out.print("36: " + Arrays.toString(intarray39) + ", "); 
		String s360 ="s360"; String[] sa36 = new String[]{s360}; s360 = "s361";
		out.println(Arrays.toString(sa36));
		// 2) List<T> doesn't have add() 
		List<Integer> il44 = new LinkedList<Integer>(Arrays.asList(0,1,2)); il44.add(3);
		// 3) List<T> doesn't reference a reference type.
		String s45 = "abc";
		List<String> ls45 = new ArrayList<>(); 
		ls45.add(s45); myprint(45,ls45);
		s45 = "bcd"; myprint(ls45);
		ls45.set(0,"cde"); myprint(ls45); myprint(0,s45);
		//ArrayDeque, Stack, FIFO, FIFO
		Deque<Object> do52 = new ArrayDeque<Object>(Arrays.asList(new Object(),new Object()));
		do52.addFirst(new Object()); do52.getFirst();
		Stack<Object> so52 = new Stack<Object>();
		so52.push(new Object()); so52.pop();
	}
	//enhanced out.print for me
	public static void myprint(Object obj){
		out.print(obj + ", ");
	}
	public static void myprint(int ln, Object obj){
		if(ln == 0){
			out.println(obj);
		}else{
			out.print(ln + ": " + obj + ", ");
		}
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
