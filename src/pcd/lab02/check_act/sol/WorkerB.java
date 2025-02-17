package pcd.lab02.check_act.sol;

import java.util.concurrent.Semaphore;

public class WorkerB extends Thread {

	private Counter counter;
	private int ntimes;
	private Semaphore mutex;

	public WorkerB(Counter c, int ntimes, Semaphore mutex) {
		counter = c;
		this.ntimes = ntimes;
		this.mutex = mutex;
	}

	public void run() {
		try {
			for (int i = 0; i < ntimes; i++) {
				try {
					mutex.acquire();
					if (counter.getValue() < 1) {
						counter.inc();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					mutex.release();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
