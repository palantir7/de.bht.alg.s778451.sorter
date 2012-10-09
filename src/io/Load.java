package io;

import java.io.IOException;

import algo.HeapSorter;
import algo.MergeSorter;
import algo.QuickSorter;
import io.FileIntArray;

/**
 * @author Marcel Buchmann (s778451)
 * @email marcel.buchmann(- at -)googlemail.com
 * @version 1.0.0
 * @date 02.10.2012
 * @project de.bht.alg.s778451.sorter
 *
 */

public class Load {
	
	/**
	 * public static Area
	 */
	public static int[] bufferQuick = null;
	public static int[] bufferMerge = null;
	public static int[] bufferHeap  = null;

	/**
	 * Fileloader Test
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String file = args[0];
		int[] array = FileIntArray.FileToIntArray(file);
		
		// ------------------------------------------------------------ \\
		
		QuickSorter q = new QuickSorter(); 
		bufferQuick = q.sort(array);
		
		// ------------------------------------------------------------ \\
		
		MergeSorter m = new MergeSorter(); 
		bufferMerge = m.sort(array);
		
		// ------------------------------------------------------------ \\
		
		HeapSorter h = new HeapSorter(); 
		bufferHeap = h.sort(array);
		
	}

}
