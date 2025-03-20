package com.example.LowLevelDesign.creational.Singleton;

import java.lang.reflect.Constructor;

/*Single thread environment*/
public class Main {
	public static void main(String[] args) throws Exception {

		Singleton s1 = Singleton.getInstance();
		System.out.println(s1.hashCode());
		
		
		/*Ways to Break the singleton class functionality.
		 * 1.using the reflection api.
		 * solution:if constructor exist throw the runtime exception inside constructor.
		 * or make the class as enum so that we can't create new instance for it.
		 * 2.using the serilization and deserilization
		 * Solution:By implementing the read resolve.
		 * 3.using the clonable constructor.
		 * 
		 * */
		Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		Singleton s2 = constructor.newInstance();
		System.out.println(s2.hashCode());
	}

}

/*Multi-thread environment*/
//public class Main {
//	public static void main(String[] args) {
//        Thread threadFoo = new Thread(new ThreadFoo());
//        Thread threadBar = new Thread(new ThreadBar());
//
//        threadFoo.start();
//        threadBar.start();
//	}
//
//	 static class ThreadFoo implements Runnable {
//		public void run() {
//			Singleton instance = Singleton.getInstance();
//			System.out.println("This is from thread1 : "+instance.hashCode());
//		}
//	}
//
//	 static class ThreadBar implements Runnable{
//		public void run() {
//			Singleton instance = Singleton.getInstance();
//			System.out.println("This is from thread2 : "+instance.hashCode());
//		}
//	}
//}
