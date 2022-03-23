package pcd.lab04.monitors.barrier;

public class ReusableBarrier implements Barrier {

	private int n;
	private final int max;
	
	public ReusableBarrier(int nParticipants) {
		n = nParticipants;
		max = nParticipants;
	}
	
	@Override
	public synchronized void hitAndWaitAll() throws InterruptedException {
		n--;
		if(n == 0) {
			notifyAll();
			n = max;
		}
		else {
			wait();
		}
	}
}
