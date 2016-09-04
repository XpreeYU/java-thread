package day07;

/**
 * 多线程共享数据
 * @author Administrator
 *
 */
public class MultiThreadShareData {

	//方式二，两个线程共享同一份数据
	private static ShareData1 data11 = new ShareData1();
	
	public static void main(String[] args) {
		
		//方式一，两个线程共享同一份数据
		ShareData1 data1 = new ShareData1();
		new Thread(new MyThreadRunable1(data1 )).start();
		new Thread(new MyThreadRunable2(data1)).start();
	

		new Thread(new Runnable() {
			
			public void run() {

				data11.decrement();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			public void run() {

				data11.increment();
			}
		}) .start();
	}

}

class MyThreadRunable1 implements Runnable {

	private ShareData1 data1;
	public MyThreadRunable1(ShareData1 data1) {

		this.data1 = data1;
	}
	
	public void run() {
		data1.increment();
	}
	
}

class MyThreadRunable2 implements Runnable {

	private ShareData1 data1;
	public MyThreadRunable2(ShareData1 data1) {

		this.data1 = data1;
	}
	
	public void run() {
		data1.decrement();
	}
	
}

class ShareData1 /*implements Runnable*/{

	/*private int count = 100;
	public void run() {

		while(true){
			count--;
		}
	}*/
	
	private int j = 0;
	
	public synchronized void increment(){
		j++;
	}
	
	public synchronized void decrement(){
		j--;
	}

}
