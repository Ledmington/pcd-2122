package pcd.lab02.check_act;

public class Counter {

	private int cont;
	private final int min;
	private final int max;

	public Counter(int min, int max) {
		this.min = min;
		this.max = max;
		this.cont = max;
	}

	public synchronized void inc() throws OverflowException {
		if (cont + 1 > max) {
			throw new OverflowException();
		}
		cont++;
	}

	public synchronized void dec() throws UnderflowException {
		if (cont - 1 < min) {
			throw new UnderflowException();
		}
		cont--;
	}

	public synchronized int getValue() {
		return cont;
	}
}
