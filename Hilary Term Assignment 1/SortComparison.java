// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Neil Kilbane 18322169
 *  @version HT 2020
 *
 */

import java.io.*;

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
        return insertionSort(a, 0, a.length-1);
    }//end insertionsort

    static double[] insertionSort(double a[], int lo, int hi) {
        for(int i = lo+1; i < hi; i++) 
            for(int j = i; j > lo; j--)
                if(a[j] < a[j-1]) a = exchange(a, i, j);
        return a;
    }
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
        int min_idx;
        for(int i = 0; i < a.length-1; i++) {
            min_idx = i;
            for(int j = i+1; j < a.length; j++)
                if(a[j] < a[min_idx]) min_idx = j;
            a = exchange(a, i, min_idx);
        }
        return a;
    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
        return quickSort(a, 0, a.length-1);
    }//end quicksort

    static double[] quickSort(double[] a, int lo, int hi) {
        if(hi <= lo) return a;
        if(hi - lo + 1 <= 10) return insertionSort(a, lo, hi); 
        int lt = lo;
        int gt = hi;
        double v = a[hi];
        int i = lo;
        while(i <= gt) {
            if (a[i] < v) exchange(a, lt++, i++);
            else if (a[i] > v) exchange(a, i, gt--);
            else i++;
        }
        a = quickSort(a, lo, lt-1);
        a = quickSort(a, gt+1, hi);
        return a;
    }

    static double[] exchange(double[] numbers, int i, int j) {
        double temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
        return numbers;
    }

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
        int n = a.length;
        double[] aux = new double[n];
        for(int sz = 1; sz < n; sz = sz+sz)
            for(int lo = 0; lo < n - sz; lo += sz+sz)	
                merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, n-1));
        return a;
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
    * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
        double[] aux = new double[a.length];
        mergeSortRecursive(a, aux, 0, a.length - 1);
        return a;
   }//end mergeSortRecursive

    static void mergeSortRecursive (double[] a, double[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        mergeSortRecursive(a, aux, lo, mid);
        mergeSortRecursive(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    static void merge (double[] a, double[] aux, int lo, int mid, int hi)
    {
        for(int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo, j = mid+1;
        for(int k = lo; k <= hi; k++) {
            if (i > mid)              a[k] = aux[j++];
            else if (j > hi)          a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else                      a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

 }//end class

