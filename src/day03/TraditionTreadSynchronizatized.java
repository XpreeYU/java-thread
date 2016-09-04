package day03;


public class TraditionTreadSynchronizatized {

	public static void main(String[] args) {

		TraditionTreadSynchronizatized synchronizatized = new TraditionTreadSynchronizatized();
		synchronizatized.init();
		
		
	}

	public void init(){
		final Outer outer =new Outer();
		new Thread(new Runnable() {
			
			public void run() {
				while (true) {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outer.printer("yujiansong");
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			public void run() {
				while (true) {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outer.printer3("sunyingrui");
				}
			}
		}).start();
	}
	
	//内部类实现打印
	static class Outer{
		private void printer(String name){
			int lentgth = name.length();
			
			//使用锁实现线程互斥
			//outer.class === this
			synchronized (Outer.class) {
				
				for (int i = 0; i < lentgth; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
		
		//使用锁实现线程互斥
		public synchronized void printer2(String name){
			int lentgth = name.length();
				for (int i = 0; i < lentgth; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
		}
		
		//使用锁实现线程互斥
		public static synchronized void printer3(String name){
			int lentgth = name.length();
				for (int i = 0; i < lentgth; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
				}
	}
}
