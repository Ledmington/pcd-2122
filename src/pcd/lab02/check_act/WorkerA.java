package pcd.lab02.check_act;

public class WorkerA extends Thread {

	private final Counter counter;
	private final int ntimes;

	public WorkerA(Counter c, int ntimes) {
		counter = c;
		this.ntimes = ntimes;
	}

	public void run() {
		try {
			for (int i = 0; i < ntimes; i++) {
				synchronized (counter) {
					if (counter.getValue() > 0) {
						counter.dec();
					}
					Thread.sleep(1);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
