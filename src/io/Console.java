package io;

/**
 * Console
 * 
 * @author Marcel Buchmann (s778451)
 * @email marcel.buchmann(- at -)googlemail.com
 * @version 1.0.0
 * @date 03.10.2012
 * @project de.bht.alg.s778451.sorter
 *
 */
public class Console {
	
	/**
	 * public static area
	 */
	public static int count = 0;
	public static String textBuffer = "";
	private static String lastLine = "";
	
	/**
	 * Entry point
	 * 
	 * @param array
	 */
	public static void output(int[] array) {
		String buffer = "";
		
		for (int i = 0; i < array.length; i++) {
			buffer = buffer + "  " + array[i];
		}
		
		if (lastLine.equals("")) {
			lastLine = buffer;
		} else {
			if (!buffer.equals(lastLine)) {
				textBuffer = textBuffer + "\n" + buffer;
				Console.count++;
			}
		}
		
		Console.count++;
	}

}
