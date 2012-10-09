/**
 *
 */
package algo;

import io.Console;

/**
 * Selection Sorter
 *
 * @author Marcel Buchmann (s778451)
 * @email marcel.buchmann(- at -)googlemail.com
 * @version 1.0.0
 * @date 06.10.2012
 * @project de.bht.alg.s778451.sorter
 *
 * @Command SelectionSorter s = new SelectionSorter(); s.sort(array);
 */
public class SelectionSorter {

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
     * @param array a array of integer values
     */
    public int[] sort(int[] array) {

        final long timeStart = System.nanoTime();

        this.unsorted = array;
        selectionSort(array);

        final long timeEnd = System.nanoTime();
        SelectionSorter.time = ((Math.round((timeEnd - timeStart) / 1000)) / 1000);

        Console.textBuffer = Console.textBuffer + "\n\n Laufzeit: " + SelectionSorter.time + "\n";

        return this.unsorted;
    }

    /**
     * core of selection algorithm sorting
     *
     * @param array a array of integers
     */
    private void selectionSort(int[] array) {

        // i = input
        // o = output
        // m = minimum
        for (int o = 0; o < array.length - 1; o++) {
            int m = o;
            for (int i = o + 1; i < array.length; i++) {
                if (array[i] < array[m]) {
                    m = i;
                }
            }
            replace(array, o, m);
        }
    }

    /**
     * replacer
     *
     * @param array a array of integers
     * @param one integer one
     * @param two integer two
     */
    private void replace(int[] array, int one, int two) {
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;
        Console.output(array);
    }
}
