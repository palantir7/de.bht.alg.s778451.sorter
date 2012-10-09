package algo;

import io.Console;

/**
 * MergeSorter
 * 
 * @author Marcel Buchmann (s778451)
 * @email marcel.buchmann(- at -)googlemail.com
 * @version 1.0.0
 * @date 02.10.2012
 * @project de.bht.alg.s778451.sorter
 * 
 * @Command MergeSorter s = new MergeSorter(); s.sort(array);
 */

public class MergeSorter {

	/**
	 * private Area of Values
	 */
	private int[] unsorted;
	private int[] buffer;
	private int n;

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

		final long timeStart = System.nanoTime();

		this.unsorted = array;
		n = array.length;

		// Depending on the version, either / or:
		buffer = new int[(n + 1) / 2];
		buffer = new int[n];
		mergesort(0, n - 1);

		final long timeEnd = System.nanoTime();		
		MergeSorter.time = ((Math.round((timeEnd - timeStart) / 1000)) / 1000);

		Console.textBuffer = Console.textBuffer + "\n\n Laufzeit: " + MergeSorter.time + "\n";

		return this.unsorted;
	}

	/**
	 * splitter of sorter
	 * 
	 * @param low
	 *            low value
	 * @param high
	 *            high value
	 */
	private void mergesort(int low, int high) {
		
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(low, middle);
			mergesort(middle + 1, high);
			merge(low, middle, high);
			Console.output(unsorted);
		}
	}

	/**
	 * sorting algorithm
	 * 
	 * @param low
	 *            low value
	 * @param middle
	 *            middle value
	 * @param high
	 *            high value
	 */
	void merge(int low, int middle, int high) {
		int i, j, k;

		// in both halves of unsorted copy to buffer
		for (i = low; i <= high; i++) {
			buffer[i] = unsorted[i];
		}

		// inner-values
		i = low;
		j = middle + 1;
		k = low;

		// each copy back next-greatest element
		while (i <= middle && j <= high) {
			if (buffer[i] <= buffer[j]) {
				unsorted[k++] = buffer[i++];
			} else {
				unsorted[k++] = buffer[j++];
			}
		}

		// Rest of the front half back copy if available
		while (i <= middle) {
			unsorted[k++] = buffer[i++];
		}
	}

}
