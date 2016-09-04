package day01;

/**
 * 
 * @author Administrator
 *创建线程的两种方式
 */
public class TraditionalThread {

	public static void main(String[] args) {

		//first
		Thread thread = new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("1:"+Thread.currentThread().getName());
					System.out.println("2"+this.currentThread().getName());
					super.run();
				}
			}
		};
		
		thread.start();
		
		//second
		Thread thread2 = new Thread(new Runnable() {
			
			public void run() {
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("3:"+Thread.currentThread().getName());
				}
			}
		});
		thread2.start();
		
		
		//父类的runable方法，子类的run方法,如果子类存在了run方法，那就执行子类的，否则执行父类的
		//new Thread(Runnable().run){run}.start();
		new Thread(
				new Runnable() {
					public void run() {
						while(true){
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println("runable"+Thread.currentThread().getName());
						}
					}
				}
				){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("4:"+Thread.currentThread().getName());
				}
			}
		}.start();
	}

}
