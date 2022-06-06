package pcd.lab03.sem.ex;

/**
 * Unsynchronized version
 *
 * @author aricci
 * @TODO make it sync
 */
public class TestPingPong {
	public static void main(String[] args) {
		new Pinger().start();
		new Ponger().start();
	}

}
