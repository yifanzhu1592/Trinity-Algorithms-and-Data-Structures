
//							          Insertion		Selection		Quick		Merge		
// 1000 random				       5700			  3500			 410		 780		(microseconds)
// 1000 few unique			      600			   420			 120		 160
// 1000 nearly ordered		    600			  2000			 170		 120
// 1000 reverse order		      380			   510			 760		  80
// 1000 sorted				        390			   570			 640		  40
// 10000 random				      47000			 36000			 800		 930
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 * Test class for SortComparison.java
 *
 * @author Yifan Zhu
 * @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest {
	// ~ Constructor ........................................................
	@Test
	public void testConstructor() {
		new SortComparison();
	}

	// ~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the methods work for empty arrays
	 */
	@Test
	public void testEmpty() {
		double[] a = {};
		assertEquals("Check if insertion sort works for empty array", "[]",
				Arrays.toString(SortComparison.insertionSort(a)));

		double[] b = {};
		assertEquals("Check if selection sort works for empty array", "[]",
				Arrays.toString(SortComparison.selectionSort(b)));

		double[] c = {};
		assertEquals("Check if quick sort works for empty array", "[]", Arrays.toString(SortComparison.quickSort(c)));

		double[] d = {};
		assertEquals("Check if merge sort works for empty array", "[]", Arrays.toString(SortComparison.mergeSort(d)));
	}

	// TODO: add more tests here. Each line of code and each decision in
	// SortComparison.java should
	// be executed at least once from at least one test.

	// ----------------------------------------------------------
	/**
	 * Check that the methods work for empty arrays
	 */
	@Test
	public void testArray() {
		double[] a = { 5, 4, 3, 2, 1, 6 };
		assertEquals("Check if insertion sort works for array a", "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0]",
				Arrays.toString(SortComparison.insertionSort(a)));

		double[] b = { 5, 4, 3, 2, 1 };
		assertEquals("Check if selection sort works for array b", "[1.0, 2.0, 3.0, 4.0, 5.0]",
				Arrays.toString(SortComparison.selectionSort(b)));

		double[] c = { 5, 4, 3, 3, 7, 9, 2, 5, 2, 1 };
		assertEquals("Check if quick sort works for array c", "[1.0, 2.0, 2.0, 3.0, 3.0, 4.0, 5.0, 5.0, 7.0, 9.0]",
				Arrays.toString(SortComparison.quickSort(c)));

		double[] d = { 5, 4, 3, 6, 9, 7, 7, 1, 2, 1 };
		assertEquals("Check if merge sort works for array d", "[1.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 7.0, 9.0]",
				Arrays.toString(SortComparison.mergeSort(d)));
	}

	// ----------------------------------------------------------
	/**
	 * Main Method. Use this main method to create the experiments needed to answer
	 * the experimental performance questions of this assignment.
	 *
	 */
	public static void main(String[] args) {
		// TODO: implement this method
		File file1 = new File("numbers1000.txt");
		double[] a = new double[1000];
		int i = 0;
		Scanner sc;
		try {
			sc = new Scanner(file1);
			while (sc.hasNextLine()) {
				a[i] = Double.valueOf(sc.nextLine());
				i++;
			}

			double[] aInsertion = Arrays.copyOf(a, a.length);
			long startTime = System.nanoTime();
			SortComparison.insertionSort(aInsertion);
			long elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 ramdom, insertion sort: " + elapsedTime / 1000 + " microseconds");

			double[] aSelection = Arrays.copyOf(a, a.length);
			startTime = System.nanoTime();
			SortComparison.selectionSort(aSelection);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 ramdom, selection sort: " + elapsedTime / 1000 + " microseconds");

			double[] aQuick = Arrays.copyOf(a, a.length);
			startTime = System.nanoTime();
			SortComparison.quickSort(aQuick);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 ramdom, quick sort: " + elapsedTime / 1000 + " microseconds");

			double[] aMerge = Arrays.copyOf(a, a.length);
			startTime = System.nanoTime();
			SortComparison.mergeSort(aMerge);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 ramdom, merge sort: " + elapsedTime / 1000 + " microseconds");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		File file2 = new File("numbers1000Duplicates.txt");
		double[] b = new double[1000];
		i = 0;
		try {
			sc = new Scanner(file2);
			while (sc.hasNextLine()) {
				b[i] = Double.valueOf(sc.nextLine());
				i++;
			}

			double[] bInsertion = Arrays.copyOf(b, b.length);
			long startTime = System.nanoTime();
			SortComparison.insertionSort(bInsertion);
			long elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 few unique, insertion sort: " + elapsedTime / 1000 + " microseconds");

			double[] bSelection = Arrays.copyOf(b, b.length);
			startTime = System.nanoTime();
			SortComparison.selectionSort(bSelection);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 few unique, selection sort: " + elapsedTime / 1000 + " microseconds");

			double[] bQuick = Arrays.copyOf(b, b.length);
			startTime = System.nanoTime();
			SortComparison.quickSort(bQuick);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 few unique, quick sort: " + elapsedTime / 1000 + " microseconds");

			double[] bMerge = Arrays.copyOf(b, b.length);
			startTime = System.nanoTime();
			SortComparison.mergeSort(bMerge);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 few unique, merge sort: " + elapsedTime / 1000 + " microseconds");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		File file3 = new File("numbersNearlyOrdered1000.txt");
		double[] c = new double[1000];
		i = 0;
		try {
			sc = new Scanner(file3);
			while (sc.hasNextLine()) {
				c[i] = Double.valueOf(sc.nextLine());
				i++;
			}

			double[] cInsertion = Arrays.copyOf(c, c.length);
			long startTime = System.nanoTime();
			SortComparison.insertionSort(cInsertion);
			long elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 nearly ordered, insertion sort: " + elapsedTime / 1000 + " microseconds");

			double[] cSelection = Arrays.copyOf(c, c.length);
			startTime = System.nanoTime();
			SortComparison.selectionSort(cSelection);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 nearly ordered, selection sort: " + elapsedTime / 1000 + " microseconds");

			double[] cQuick = Arrays.copyOf(c, c.length);
			startTime = System.nanoTime();
			SortComparison.quickSort(cQuick);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 nearly ordered, quick sort: " + elapsedTime / 1000 + " microseconds");

			double[] cMerge = Arrays.copyOf(c, c.length);
			startTime = System.nanoTime();
			SortComparison.mergeSort(cMerge);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 nearly ordered, merge sort: " + elapsedTime / 1000 + " microseconds");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		File file4 = new File("numbersReverse1000.txt");
		double[] d = new double[1000];
		i = 0;
		try {
			sc = new Scanner(file4);
			while (sc.hasNextLine()) {
				d[i] = Double.valueOf(sc.nextLine());
				i++;
			}

			double[] dInsertion = Arrays.copyOf(d, d.length);
			long startTime = System.nanoTime();
			SortComparison.insertionSort(dInsertion);
			long elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 reverse order, insertion sort: " + elapsedTime / 1000 + " microseconds");

			double[] dSelection = Arrays.copyOf(d, d.length);
			startTime = System.nanoTime();
			SortComparison.selectionSort(dSelection);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 reverse order, selection sort: " + elapsedTime / 1000 + " microseconds");

			double[] dQuick = Arrays.copyOf(d, d.length);
			startTime = System.nanoTime();
			SortComparison.quickSort(dQuick);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 reverse order, quick sort: " + elapsedTime / 1000 + " microseconds");

			double[] dMerge = Arrays.copyOf(d, d.length);
			startTime = System.nanoTime();
			SortComparison.mergeSort(dMerge);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 reverse order, merge sort: " + elapsedTime / 1000 + " microseconds");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		File file5 = new File("numbersSorted1000.txt");
		double[] e = new double[1000];
		i = 0;
		try {
			sc = new Scanner(file5);
			while (sc.hasNextLine()) {
				e[i] = Double.valueOf(sc.nextLine());
				i++;
			}

			double[] eInsertion = Arrays.copyOf(e, e.length);
			long startTime = System.nanoTime();
			SortComparison.insertionSort(eInsertion);
			long elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 sorted, insertion sort: " + elapsedTime / 1000 + " microseconds");

			double[] eSelection = Arrays.copyOf(e, e.length);
			startTime = System.nanoTime();
			SortComparison.selectionSort(eSelection);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 sorted, selection sort: " + elapsedTime / 1000 + " microseconds");

			double[] eQuick = Arrays.copyOf(e, e.length);
			startTime = System.nanoTime();
			SortComparison.quickSort(eQuick);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 sorted, quick sort: " + elapsedTime / 1000 + " microseconds");

			double[] eMerge = Arrays.copyOf(e, e.length);
			startTime = System.nanoTime();
			SortComparison.mergeSort(eMerge);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("1000 sorted, merge sort: " + elapsedTime / 1000 + " microseconds");

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		File file6 = new File("numbers10000.txt");
		double[] f = new double[10000];
		i = 0;
		try {
			sc = new Scanner(file6);
			while (sc.hasNextLine()) {
				f[i] = Double.valueOf(sc.nextLine());
				i++;
			}

			double[] fInsertion = Arrays.copyOf(f, f.length);
			long startTime = System.nanoTime();
			SortComparison.insertionSort(fInsertion);
			long elapsedTime = System.nanoTime() - startTime;
			System.out.println("10000 random, insertion sort: " + elapsedTime / 1000 + " microseconds");

			double[] fSelection = Arrays.copyOf(f, f.length);
			startTime = System.nanoTime();
			SortComparison.selectionSort(fSelection);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("10000 random, selection sort: " + elapsedTime / 1000 + " microseconds");

			double[] fQuick = Arrays.copyOf(f, f.length);
			startTime = System.nanoTime();
			SortComparison.quickSort(fQuick);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("10000 random, quick sort: " + elapsedTime / 1000 + " microseconds");

			double[] fMerge = Arrays.copyOf(f, f.length);
			startTime = System.nanoTime();
			SortComparison.mergeSort(fMerge);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("10000 random, merge sort: " + elapsedTime / 1000 + " microseconds");

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}

}
