import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 *                     |Insert   |Selection|Merge Recursive|Merge Iterative|Quick
 *  10 random          |272484ns |5032ns   |10373ns        |29944ns        |4510ns
 *  100 random         |203102ns |98695ns  |48889ns        |38919ns        |168644ns
 *  1000 random        |6281779ns|4812637ns|194943ns       |134724ns       |2720281ns
 *  1000 few unique    |4874658ns|1347660ns|103706ns       |140851ns       |364905ns
 *  1000 nearly ordered|4638424ns|1345090ns|53802ns        |70458ns        |776472ns
 *  1000 reverse order |899306ns |1343089ns|38888ns        |67712ns        |812481ns
 *  1000 sorted        |737640ns |1336707ns|46089ns        |76434ns        |805057ns
 *  
 *  Questions:
 *  a. The order of input has an impact on the performance of insertion sort.
 *     This is because the further an element is from it's sorted position,
 *     the more compares are needed.
 *
 *  b. Insertion sort had the biggest difference between best and worst performance.
 *
 *  c. Iterative merge sort had the best scalability, selection sort had the worst.
 *
 *  d. No.
 *
 *  e. 10 random: quick sort
 *     100 random: iterative merge sort
 *     1000 random: iterative merge sort
 *     1000 few unique: recursive merge sort
 *     1000 nearly ordered: recursive merge sort
 *     1000 reverse order: recursive merge sort
 *     1000 sorted: recursive merge sort
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
        double[] a = new double[0];

        double[] insertionSortedArray = SortComparison.insertionSort(a);
        double[] selectionSortedArray = SortComparison.selectionSort(a);
        double[] quickSortedArray = SortComparison.quickSort(a);
        double[] mergeSortedArrayIterative = SortComparison.mergeSortIterative(a);
        double[] mergeSortedArrayRecursive = SortComparison.mergeSortRecursive(a);

        assertArrayEquals("Checking insertionSort on empty array", a, insertionSortedArray, 0.0);
        assertArrayEquals("Checking selectionSort on empty array", a, selectionSortedArray, 0.0);
        assertArrayEquals("Checking quickSort on empty array", a, quickSortedArray, 0.0);
        assertArrayEquals("Checking mergeSortIterative on empty array", a, mergeSortedArrayIterative, 0.0);
        assertArrayEquals("Checking mergeSortRecursive on empty array", a, mergeSortedArrayRecursive, 0.0);

        
    }

    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.
    
    @Test
    public void testLengthOne()
    {
        double[] a = { 5.7 };

        double[] insertionSortedArray = SortComparison.insertionSort(a);
        double[] selectionSortedArray = SortComparison.selectionSort(a);
        double[] quickSortedArray = SortComparison.quickSort(a);
        double[] mergeSortedArrayIterative = SortComparison.mergeSortIterative(a);
        double[] mergeSortedArrayRecursive = SortComparison.mergeSortRecursive(a);

        assertArrayEquals("Checking insertionSort on empty array", a, insertionSortedArray, 0.0);
        assertArrayEquals("Checking selectionSort on empty array", a, selectionSortedArray, 0.0);
        assertArrayEquals("Checking quickSort on empty array", a, quickSortedArray, 0.0);
        assertArrayEquals("Checking mergeSortIterative on empty array", a, mergeSortedArrayIterative, 0.0);
        assertArrayEquals("Checking mergeSortRecursive on empty array", a, mergeSortedArrayRecursive, 0.0);

        
    }

    @Test
    public void testLengthTwo()
    {
        double[] a = { 5.7, -3.1 };
        double[] b = { -3.1, 5.7 };

        double[] insertionSortedArray = SortComparison.insertionSort(a);
        double[] selectionSortedArray = SortComparison.selectionSort(a);
        double[] quickSortedArray = SortComparison.quickSort(a);
        double[] mergeSortedArrayIterative = SortComparison.mergeSortIterative(a);
        double[] mergeSortedArrayRecursive = SortComparison.mergeSortRecursive(a);

        assertArrayEquals("Checking insertionSort on empty array", b, insertionSortedArray, 0.0);
        assertArrayEquals("Checking selectionSort on empty array", b, selectionSortedArray, 0.0);
        assertArrayEquals("Checking quickSort on empty array", b, quickSortedArray, 0.0);
        assertArrayEquals("Checking mergeSortIterative on empty array", b, mergeSortedArrayIterative, 0.0);
        assertArrayEquals("Checking mergeSortRecursive on empty array", b, mergeSortedArrayRecursive, 0.0);

        
    }

    @Test
    public void testLengthEleven()
    {
        double[] a = { 20.0, 2.0, 19.0, 5.0, 14.0, 10.0, 6.0, 13.0, 17.0, 1.0, 16.0, 12.0, 3.0, 11.0, 8.0, 4.0, 9.0, 7.0, 18.0, 15.0 };
        double[] b = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0 };

        double[] insertionSortedArray = SortComparison.insertionSort(a);
        double[] selectionSortedArray = SortComparison.selectionSort(a);
        double[] quickSortedArray = SortComparison.quickSort(a);
        double[] mergeSortedArrayIterative = SortComparison.mergeSortIterative(a);
        double[] mergeSortedArrayRecursive = SortComparison.mergeSortRecursive(a);

        assertArrayEquals("Checking insertionSort on empty array", b, insertionSortedArray, 0.0);
        assertArrayEquals("Checking selectionSort on empty array", b, selectionSortedArray, 0.0);
        assertArrayEquals("Checking quickSort on empty array", b, quickSortedArray, 0.0);
        assertArrayEquals("Checking mergeSortIterative on empty array", b, mergeSortedArrayIterative, 0.0);
        assertArrayEquals("Checking mergeSortRecursive on empty array", b, mergeSortedArrayRecursive, 0.0);

        
    }
    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
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
                insertionSort = SortComparison.insertionSort(a);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Insertion Sort on " + fileName + " took " + 
                                                                duration + "ns");
                startTime = System.nanoTime();
                selectionSort = SortComparison.selectionSort(a);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Selection Sort on " + fileName + " took " + 
                                                                duration + "ns");
                startTime = System.nanoTime();
                quickSort = SortComparison.quickSort(a);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Quick Sort on " + fileName + " took " + 
                                                                duration + "ns");
                startTime = System.nanoTime();
                mergeSortIterative = SortComparison.mergeSortIterative(a);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Iterative Merge Sort on " + fileName + 
                                                " took " + duration + "ns");
                startTime = System.nanoTime();
                mergeSortRecursive = SortComparison.mergeSortRecursive(a);
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

}

