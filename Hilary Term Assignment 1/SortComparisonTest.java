import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
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
    }

}

