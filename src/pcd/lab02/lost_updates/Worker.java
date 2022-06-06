package pcd.lab02.lost_updates;

import java.util.concurrent.locks.*;

public class Worker extends Thread {

	private final UnsafeCounter counter;
	private final int ntimes;
	private final Lock lock;

	public Worker(UnsafeCounter c, int ntimes, Lock lock) {
		counter = c;
		this.ntimes = ntimes;
		this.lock = lock;
	}

	public void run() {
		for (int i = 0; i < ntimes; i++) {
			try {
				lock.lockInterruptibly();
				counter.inc();
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}
}
