package pcd.lab02.lost_updates.sol_with_lock;

public class UnsafeCounter {

	private int cont;

	public UnsafeCounter(int base) {
		this.cont = base;
	}

	public void inc() {
		cont++;
	}

	public int getValue() {
		return cont;
	}
}
