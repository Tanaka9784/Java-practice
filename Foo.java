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
		int[] a = {1,2,3};
		Class<int[]> klass = int[].class;
		System.gc();
		Bar<? extends Object, ? extends Object> bar = new Foo().new Bar<Object, Object>();
		bar.doIt(bar);
	}
	public class Bar<T, U extends T>{
		public Bar(){
		}
		public <TT> void doIt(TT tt){
		}
		public void doIt(Bar<?,?> bar){
			System.out.println("Bar.doIt()");
		}
	}
	public class Buz<E> extends Bar<List<E>, ArrayList<E>>{
		public Buz(){
		}
		public void doIt(){
			List<?> list;
			doIt(new Buz<String>());
			
		}
	}
}
