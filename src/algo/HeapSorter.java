package algo;

import io.Console;

/**
 * HeapSorter
 *
 * @author Marcel Buchmann (s778451)
 * @email marcel.buchmann(- at -)googlemail.com
 * @version 1.0.0
 * @date 02.10.2012
 * @project de.bht.alg.s778451.sorter
 *
 * @Command HeapSorter s = new HeapSorter(); s.sort(array);
 */
public class HeapSorter {

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
        heapsort();

        final long timeEnd = System.nanoTime();
        HeapSorter.time = ((Math.round((timeEnd - timeStart) / 1000)) / 1000);

        Console.textBuffer = Console.textBuffer + "\n\n Laufzeit: " + HeapSorter.time + "\n";

        return this.unsorted;
    }

    /**
     * tree builder
     */
    private void heapsort() {
        nodeBuilder();
        while (n > 1) {
            n--;
            replace(0, n);
            leafORnode(0);
        }
    }

    /**
     * fork build
     */
    private void nodeBuilder() {
        for (int heap = n / 2 - 1; heap >= 0; heap--) {
            leafORnode(heap);
        }
    }

    /**
     * core of heap algorithm sorting leafs and folks
     *
     * @param heap
     */
    private void leafORnode(int heap) {

        // first successor of heap
        int nextHeap = 2 * heap + 1;

        while (nextHeap < n) {

            // there is a second successor?
            if (nextHeap + 1 < n) {

                // nextHeap is the successor of heap with maximum mark
                if (unsorted[nextHeap + 1] > unsorted[nextHeap]) {
                    Console.output(unsorted);
                    nextHeap++;
                }
            }

            if (unsorted[heap] >= unsorted[nextHeap]) {
                // heap has the heap-property
                return;
            }

            // if heap hasn't the heap-property
            // replace heaps and heap = nextHeap
            replace(heap, nextHeap);
            heap = nextHeap;
            nextHeap = 2 * heap + 1;
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
    }
}
