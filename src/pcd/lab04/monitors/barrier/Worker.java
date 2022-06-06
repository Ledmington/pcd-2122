package pcd.lab04.monitors.barrier;

import java.util.Random;

public class Worker extends Thread {

	private final Barrier barrier;

	public Worker(String name, Barrier barrier) {
		super(name);
		this.barrier = barrier;
	}

	public void run() {
		Random gen = new Random(System.nanoTime());
		try {
			for (int i = 0; i < 10; i++) {
				log("before " + i);
				barrier.hitAndWaitAll();
				log("after " + i);
			}
		} catch (InterruptedException ex) {
			log("Interrupted!");
		}
	}

	private void log(String msg) {
		synchronized (System.out) {
			System.out.println("[ " + getName() + " ] " + msg);
		}
	}
}
