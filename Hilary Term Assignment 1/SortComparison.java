// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Neil Kilbane 18322169
 *  @version HT 2020
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
        double temp;
        for(int i = 1; i < a.length; i++) {
            for(int j = i; j > 0; j--) {
                if(a[j] < a[j-1]) {
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
        return a;
    }//end insertionsort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
        int n = a.length;
        for(int i = 0; i < n-1; i++) {
            int min_idx = i;
            for(int j = i+1; j < n; j++) {
                if(a[j] < a[min_idx])
                    min_idx = j;
            }
            double temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
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
        if (a.length <= 10) return insertionSort(a);
        recursiveQuick(a, 0, a.length-1);
        return a;
    }//end quicksort

    static void recursiveQuick(double[] numbers, int lo, int hi) {
        if(hi <= lo) {
            return;
        }
        int lt = lo;
        int gt = hi;
        double v = numbers[hi];
        int i = lo;
        while(i <= gt) {
            if (numbers[i] < v) exchange(numbers, lt++, i++);
            else if (numbers[i] > v) exchange(numbers, i, gt--);
            else i++;
        }
        recursiveQuick(numbers, lo, lt-1);
        recursiveQuick(numbers, gt+1, hi);
    }

    static void exchange(double[] numbers, int i, int j) {
        double temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
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
        long startTime = 0, endTime = 0, duration;
        String[] inputFiles = { "numbers10.txt", "numbers100.txt", 
                                "numbers1000.txt", "numbers1000Duplicates.txt", 
                                "numbersNearlyOrdered1000.txt", "numbersReverse1000.txt", 
                                "numbersSorted1000.txt" };
        int[] fileSizes = { 10, 100, 1000, 1000, 1000, 1000, 1000 };
        String fileName = inputFiles[0];
        File file = new File(fileName);
        double[] a = {}, insertionSort, selectionSort, quickSort, mergeSortIterative,
                                                                mergeSortRecursive;
        for(int i = 0; i < inputFiles.length; i++) {
                fileName = inputFiles[i];
                file = new File(fileName);
                try{
                        FileReader fileReader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        a = new double[fileSizes[i]];
                        for(int j = 0; j < a.length; j++)
                                a[j] = Double.parseDouble(bufferedReader.readLine());
                        bufferedReader.close();
                        startTime = System.nanoTime();
                        insertionSort = insertionSort(a);
                        endTime = System.nanoTime();
                        duration = endTime - startTime;
                        System.out.println("Insertion Sort on " + fileName + " took " + 
                                                                        duration + "ns");
                        startTime = System.nanoTime();
                        selectionSort = selectionSort(a);
                        endTime = System.nanoTime();
                        duration = endTime - startTime;
                        System.out.println("Selection Sort on " + fileName + " took " + 
                                                                        duration + "ns");
                        startTime = System.nanoTime();
                        quickSort = quickSort(a);
                        endTime = System.nanoTime();
                        duration = endTime - startTime;
                        System.out.println("Quick Sort on " + fileName + " took " + 
                                                                        duration + "ns");
                        startTime = System.nanoTime();
                        mergeSortIterative = mergeSortIterative(a);
                        endTime = System.nanoTime();
                        duration = endTime - startTime;
                        System.out.println("Iterative Merge Sort on " + fileName + 
                                                        " took " + duration + "ns");
                        startTime = System.nanoTime();
                        mergeSortRecursive = mergeSortRecursive(a);
                        endTime = System.nanoTime();
                        duration = endTime - startTime;
                        System.out.println("Recursive Merge Sort on " + fileName + 
                                                        " took " + duration + "ns");
                }
                catch(FileNotFoundException ex) {
                        System.out.println("Unable to open file '" + fileName + "'");
                }
                catch(IOException ex) {
                        System.out.println("Error reading file '" + fileName + "'");
                }

        }
    }

 }//end class

