/**
 * 
 */
package algo;

import io.Console;

/**
 * Insertion Sorter
 * 
 * @author Marcel Buchmann (s778451)
 * @email marcel.buchmann(- at -)googlemail.com
 * @version 1.0.0
 * @date 06.10.2012
 * @project de.bht.alg.s778451.sorter
 * 
 * @Command InsertionSorter s = new InsertionSorter(); s.sort(array);
 */
public class InsertionSorter {

	/**
	 * private Area of Values
	 */
	private int[] unsorted;

	/**
	 * public static Area
	 */
	public static double time;

	/**
	 * entry point of sorter
	 * 
	 * @param array
	 *            a array of integer values
	 */
	public int[] sort(int[] array) {

		this.unsorted = array;
		insertionSort(array);

		return this.unsorted;
	}

	/**
	 * core of insertion algorithm sorting
	 * 
	 * @param array
	 *            a array of integers
	 */
	private void insertionSort(int[] array) {

		// local variables (incoming and outgoing)
		int i;
		int o;

		final long timeStart = System.nanoTime();

		// sorting algorithm
		for (o = 1; o < array.length; o++) {
			// buffer
			int temp = array[o];

			i = o;

			while (i > 0 && array[i - 1] >= temp) {
				array[i] = array[i - 1];
				--i;
			}
			Console.output(array);

			array[i] = temp;
		}

		final long timeEnd = System.nanoTime();
		
		InsertionSorter.time = ((Math.round((timeEnd - timeStart) / 1000)) / 1000);

		Console.textBuffer = Console.textBuffer + "\n\n Laufzeit: " + InsertionSorter.time + "\n";
	}
}
