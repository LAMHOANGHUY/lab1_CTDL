package task2;

import java.util.*;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T next = iter.next();
			if (p.test(next)) {
				iter.remove();
			}
		}
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		// TODO
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T next = iter.next();
			if (!p.test(next)) {
				iter.remove();
			}
		}
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		// TODO
		Set<T> re = new HashSet<>();
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T next = iter.next();
			if (p.test(next)) {
				re.add(next);
			}
		}
		return re;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		// TODO
		int index = 0;
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T next = iter.next();
			if (p.test(next)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public static void main(String[] args) {
		Even even = new Even();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(7);
		list.add(8);

		MyPredicates myPredicates = new MyPredicates();

		// 1. remove : 
//		System.out.println("before :" + list);
//		myPredicates.remove(list, even);
//		System.out.println("after :" + list);
		
		// 2. retain
//		System.out.println("before :" + list);
//		myPredicates.retain(list, even);
//		System.out.println("after :" +  list);
		
		// 3. collect :
//		System.out.println("list :" + list);
//		Set<Integer> set = myPredicates.collect(list, even);
//		System.out.println("collect : " + set.toString());
		
		// 4. find :
//		System.out.println("find is :" + myPredicates.find(list, even));
	}
}
