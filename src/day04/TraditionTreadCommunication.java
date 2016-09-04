package day04;

import java.util.Timer;

import day03.TraditionTreadSynchronizatized;

public class TraditionTreadCommunication {

	public static void main(String[] args) {

		final Business business = new Business();
		new Thread(
			new Runnable() {
				
				public void run() {

					for (int i = 1; i <= 10; i++) {
						business.sub(i);
					}
				}
			}
				).start();
		
		for (int i = 1; i <= 10; i++) {
			business.main(i);
		}
	}

}

	class Business{
		private boolean isSub = true;
		public synchronized void sub(int i){
			while (!isSub) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 50; j++) {
				System.out.println("sub"+i+",hello:"+j);
			}
			isSub = false;
			this.notify();
		}
		
		public synchronized void main(int i){
			while (isSub) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 100; j++) {
				System.out.println("main"+i+",hello2:"+j);
			}
			isSub = true;
			this.notify();
		}
	}