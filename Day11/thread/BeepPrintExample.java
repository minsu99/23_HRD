package my.thread;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {

		Toolkit toolkit = Toolkit.getDefaultToolkit();

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					toolkit.beep();

					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		});
		//////////////////////////////////
		thread.start(); // 새 스레드 시작********
		/////////////////////////////////
		for (int i = 0; i < 5; i++) {
			System.out.println("띵 띙 뗑 띡 뗅 ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}