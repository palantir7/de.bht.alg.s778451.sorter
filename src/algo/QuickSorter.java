package algo;

import io.Console;

/**
 * QuickSorter
 *
 * @author Marcel Buchmann (s778451)
 * @email marcel.buchmann(- at -)googlemail.com
 * @version 1.0.0
 * @date 02.10.2012
 * @project de.bht.alg.s778451.sorter
 *
 * @Command QuickSorter s = new QuickSorter(); s.sort(array);
 */
public class QuickSorter {

    /**
     * private Area of Values
     */
    private int[] unsorted;
    private int n;
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
        n = array.length;
        quicksort(0, n - 1);

        final long timeEnd = System.nanoTime();
        QuickSorter.time = ((Math.round((timeEnd - timeStart) / 1000)) / 1000);

        Console.textBuffer = Console.textBuffer + "\n\n Laufzeit: " + QuickSorter.time + "\n";

        return this.unsorted;
    }

    /**
     * sorting algorithm
     *
     * @param low low value
     * @param high high value
     */
    private void quicksort(int low, int high) {
        int i = low, j = high;

        // Predicate x
        int x = unsorted[(low + high) / 2];

        // splitting
        while (i <= j) {
            while (unsorted[i] < x) {
                i++;
            }
            while (unsorted[j] > x) {
                j--;
            }
            if (i <= j) {
                replace(i, j);
                i++;
                j--;
            }
        }

        // recursion method
        if (low < j) {
            quicksort(low, j);
        }
        if (i < high) {
            quicksort(i, high);
        }
    }

    /**
     * replacer
     *
     * @param i pointer i (left side)
     * @param j pointer j (right side)
     */
    private void replace(int i, int j) {
        int t = unsorted[i];
        unsorted[i] = unsorted[j];
        unsorted[j] = t;
        Console.output(unsorted);
    }
}
