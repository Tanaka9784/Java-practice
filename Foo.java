/*
 *
 *
 *
 * **/
import java.util.*;
public class Foo{
	public Foo(){
	}
	public static void main(String[] args){
		//reflection
		Class<int[]> klass = int[].class;
		//System class
		System.out.println();
		System.gc();
		//use generic class
		Bar<? extends Object, ? extends Object> bar = new Foo().new Bar<Object, Object>();
		//collection interface
		List<Object> list;
		list = new ArrayList<Object>();
		list = new LinkedList<Object>();
		list.add(new Object());
		//CAP#1 error
		List<?> list2 = new LinkedList<Object>();//list2.add(new Object());
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
