/*
 *
 *
 *
 * **/
import java.lang.*;
import java.util.*;
import java.util.function.*;
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
		ls45.add(s45); myprint("i",45,ls45);
		s45 = "bcd"; myprint("n",ls45);
		ls45.set(0,"cde"); myprint("n",ls45); myprint("e",s45);
		//ArrayDeque, Stack, FIFO, FIFO
		Deque<Object> do52 = new ArrayDeque<Object>(Arrays.asList(new Object(),new Object()));
		do52.addFirst(new Object()); do52.getFirst();
		Stack<Object> so52 = new Stack<Object>();
		so52.push(new Object()); so52.pop();
		//Set
		Set<Number> sd59 = new HashSet<Number>(); sd59 = new TreeSet<Number>();
		sd59.addAll(Arrays.asList(0,1,2)); myprint("i",59, sd59); 
		//Map<K,V>
		Map<Integer,Object> mio62 = new TreeMap<>(); mio62 = new HashMap<Integer,Object>();
		mio62.put(0,new Object()); mio62.put(1,new Object()); myprint2(62,mio62.entrySet());
		for(Map.Entry<Integer,Object> me62:mio62.entrySet()) myprint2(me62.getKey() + "=" + me62.getValue());
		//Comparable, Comparator, TreeSet, TreeMap, nullsFirst
		class Cc66 implements Comparable<Cc66>, Serializable {
			private int id;
			public Cc66(int id){	this.id = id;	}
			public int getId(){ return id; }
			@Override
			public int compareTo(Cc66 c){ return this.id - c.id; }
			@Override
			public String toString(){ return Integer.toString(id); }
		}
		Set<Object> so66 = new  TreeSet<>(); 
		try{so66.add(new Object());}catch(ClassCastException e){myprint2(66,e.getMessage());}
		try{so66.add(null); }catch(NullPointerException e){myprint2(e.getMessage());}//Why does the Exception return null?
		Set<Cc66> sc66 = new  TreeSet<>();
		sc66.add(new Cc66(2));sc66.add(new Cc66(0));sc66.add(new Cc66(1));sc66.add(new Cc66(-1));myprint2(66, sc66);
		sc66 = new  TreeSet<>(new Comparator<Cc66>(){
			@Override public int compare(Cc66 c1, Cc66 c2){ return c1.getId() + 10; }}); 
		sc66.add(new Cc66(2));sc66.add(new Cc66(0));sc66.add(new Cc66(1));sc66.add(new Cc66(-1));myprint2(sc66);
		sc66 = new  TreeSet<>(Comparator.nullsFirst(new Comparator<Cc66>(){
			@Override public int compare(Cc66 c1, Cc66 c2){	return c1.getId() - c2.getId(); }})); 
		sc66.add(new Cc66(2));sc66.add(new Cc66(0));sc66.add(new Cc66(1));sc66.add(new Cc66(-1));sc66.add(null);myprint2(sc66);
		//FunctionInterface
		Supplier<Object> so87 = () -> new Object(); Object o87 = so87.get(); myprint2(87,o87);
		Consumer<Object> co87 = o -> o = null; co87.accept(new Object());
		Predicate<Object> po87 = o -> o.equals(new Object()); boolean b87 = po87.test(new Object()); myprint2(b87);
		Function<Object,Integer> foi87 = o -> 1; int i87 = foi87.apply(new Object()); myprint2(i87);
	}
	//myprint2; enhanced myprint
	public static void myprint2(int ln, Object obj){
		out.print("\n" + ln + ": " + obj);
	}
	public static void myprint2(Object obj){
		out.print(", " + obj);
	}		
	//myprint; enhanced out.print for me
	public static void myprint(String opt, Object obj){
		myprint(opt, 0, obj);
	}
	public static void myprint(String opt, int ln, Object obj){
		switch(opt){
			case "o"://once
				out.print(ln + ": " + obj + "\n");
				break;
			case "i"://initial
				out.print(ln + ": " + obj);
				break;
			case "n"://not initial
				out.print(", " + obj);
				break;
			case "e"://end
				out.print(", " + obj + "\n");
				break;
			default:
				throw new IllegalArgumentException("Invalid option: " + opt);	
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
