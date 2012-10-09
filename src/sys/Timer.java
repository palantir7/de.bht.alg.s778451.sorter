package sys;

/**
 * @author Marcel Buchmann (s778451)
 * @email marcel.buchmann(- at -)googlemail.com
 * @version 1.0.0
 * @date 03.10.2012
 * @project de.bht.alg.s778451.sorter
 * 
 */
public class Timer {

	/**
	 * NanoTimer Test
	 * @param args
	 */
	public static void main(String[] args) {
		final long timeStart = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			// do nothing
		}
		final long timeEnd = System.nanoTime();
		System.out.println("Verlaufszeit der Schleife: "
				+ (timeEnd - timeStart) + " Nanosek.");
	}

}
