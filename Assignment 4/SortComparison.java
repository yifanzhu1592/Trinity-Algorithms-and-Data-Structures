// -------------------------------------------------------------------------

/**
 * This class contains static methods that implementing sorting of an array of
 * numbers using different sort algorithms.
 *
 * @author Yifan Zhu
 * @version HT 2020
 */

class SortComparison {

	/**
	 * Sorts an array of doubles using InsertionSort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	static double[] insertionSort(double a[]) {

		// todo: implement the sort
		double temp;
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
		return a;
	}// end insertionsort

	/**
	 * Sorts an array of doubles using Selection Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] selectionSort(double a[]) {

		// todo: implement the sort
		int n = a.length;

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}

			double temp = a[minIndex];
			a[minIndex] = a[i];
			a[i] = temp;
		}
		return a;
	}// end selectionsort

	/**
	 * Sorts an array of doubles using Quick Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] quickSort(double a[]) {

		// todo: implement the sort
		quickSort(a, 0, a.length - 1);
		return a;
	}// end quicksort

	static void quickSort(double[] a, int low, int high) {
		if (high <= low) {
			return;
		}
		int pivotPosition = partition(a, low, high);
		quickSort(a, low, pivotPosition - 1);
		quickSort(a, pivotPosition + 1, high);
	}

	static int partition(double[] a, int low, int high) {
		int i = low;
		int j = high + 1;
		double pivot = a[low];
		while (true) {
			while (a[++i] < pivot) {
				if (i == high)
					break;
			}
			while (a[--j] >= pivot) {
				if (j == low)
					break;
			}
			if (i >= j)
				break;
			double temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		a[low] = a[j];
		a[j] = pivot;
		return j;
	}

	/**
	 * Sorts an array of doubles using Merge Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	/**
	 * Sorts an array of doubles using iterative implementation of Merge Sort. This
	 * method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */

	static double[] mergeSort(double a[]) {

		// todo: implement the sort
		double[] auxiliary = new double[a.length];
		mergeSort(a, auxiliary, 0, a.length - 1);
		return a;
	}// end mergesort

	static void mergeSort(double[] a, double[] auxiliary, int low, int high) {
		if (high <= low) {
			return;
		}
		int middle = low + (high - low) / 2;
		mergeSort(a, auxiliary, low, middle);
		mergeSort(a, auxiliary, middle + 1, high);
		merge(a, auxiliary, low, middle, high);
	}

	static void merge(double[] a, double[] auxiliary, int low, int middle, int high) {
		for (int k = low; k <= high; k++) {
			auxiliary[k] = a[k];
		}

		int i = low, j = middle + 1;
		for (int k = low; k <= high; k++) {
			if (i > middle)
				a[k] = auxiliary[j++];
			else if (j > high)
				a[k] = auxiliary[i++];
			else if (auxiliary[j] < auxiliary[i])
				a[k] = auxiliary[j++];
			else
				a[k] = auxiliary[i++];
		}
	}

//	public static void main(String[] args) {

	// todo: do experiments as per assignment instructions
//	}

}// end class
