package day02;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 传统定时器
 * @author Administrator
 *
 */
public class TraditionTimer {

	public static void main(String[] args) {

		//新建一个定时器
//		new Timer().schedule(new TimerTask() {
//			
//			@Override
//			public void run() {
//				
//				System.out.println("炸！！！");
//			}
//		}, 10000, 6000);
		
		
		new Timer().schedule(new MyTimerTask(), 2000);
		while (true) {
			System.out.println("打。。。。" + new Date().getSeconds());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

    //连环炸弹
	class MyTimerTask extends TimerTask{
			static int count = 0;
			@Override
			public void run() {
				count = (count+1)%2;
				System.out.println("炸。。。。。2");
				new Timer().schedule(new MyTimerTask(), 2000+2000*count );
			}
		}
