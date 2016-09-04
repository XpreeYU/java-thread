package day06;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TreadLockShareData {

	//private static Map<Thread, Integer> threaMap = new HashMap<Thread, Integer>();
	//private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
	public static void main(String[] args) {

		for (int i = 0; i < 2; i++) {
			new Thread(
					new Runnable() {
						public void run() {
							int data = new Random().nextInt();
							System.out.println(Thread.currentThread().getName() + "has:" + data);
							//x.set(data);
							MyThreaScopeData.getInstance().setName("name:" + data);
							MyThreaScopeData.getInstance().setAge(data);
							new A().getData();
							new B().getData();
						}
					}
					).start();
		}
	}

	static class A{
		public void getData(){
			// int data = x.get();
			MyThreaScopeData myData = MyThreaScopeData.getInstance();
			System.out.println("A:" + Thread.currentThread().getName() + "has:" + myData.getName() + myData.getAge());
		}
	}
	
	static class B{
		public void getData(){
		//int data = x.get();
			MyThreaScopeData myData = MyThreaScopeData.getInstance();
			System.out.println("B:" + Thread.currentThread().getName() + "has:" + myData.getName() + myData.getAge());
		}
	}
}


	class MyThreaScopeData {
		
		//创建单例
		public static /*synchronized*/ MyThreaScopeData getInstance(){
			MyThreaScopeData instace = map.get();
			if (instace == null) {
				instace = new MyThreaScopeData();
				map.set(instace);
			}
			return instace;
		}
	
		//private static MyThreaScopeData instace = null;
		private static ThreadLocal<MyThreaScopeData> map = new ThreadLocal<MyThreaScopeData>();
		
		private String name;
		private int age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
	}

