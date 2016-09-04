package day05;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TreadScopeShareData {

	private static Map<Thread, Integer> threaMap = new HashMap<Thread, Integer>();
	public static void main(String[] args) {

		for (int i = 0; i < 2; i++) {
			new Thread(
					new Runnable() {
						public void run() {
							int data = new Random().nextInt();
							System.out.println(Thread.currentThread().getName() + "has:" + data);
							threaMap.put(Thread.currentThread(), data);
							new A().getData();
							new B().getData();
						}
					}
					).start();
		}
	}

	static class A{
		public void getData(){
			 int data = threaMap.get(Thread.currentThread());
			System.out.println("A:" + Thread.currentThread().getName() + "has:" + data);
		}
	}
	
	static class B{
		public void getData(){
			int data = threaMap.get(Thread.currentThread());
			System.out.println("B:" + Thread.currentThread().getName() + "has:" + data);
		}
	}
}
